package pizzixp;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import imgscalr.*;
import java.awt.Graphics;
import java.awt.Dimension;
import java.net.URL;
public class JavaSwingGui
{
    JavaSwingGui()
    {
        var width = Toolkit.getDefaultToolkit().getScreenSize().width;
        var height = Toolkit.getDefaultToolkit().getScreenSize().height;

        //Creating the Frame
        JFrame frame = new JFrame("Gay frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m12 = new JMenuItem("Save as");
        JMenuItem m13 = new JMenuItem("Close");
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);



        //Creating center panel

        //Declaring all image urls
        URL PlaceholderIconLocation = getClass().getResource("/PlaceholderIcon.png");
        URL XPWallpaperLocation = getClass().getResource("/Wallpaper.png");
        URL NotepadIconLocation = getClass().getResource("/Notepad.jpeg");
        URL CalculatorIconLocation = getClass().getResource("/Calculator.jpeg");

        var PanelCenter = new JPanel();
        PanelCenter.setLayout(new BoxLayout(PanelCenter, BoxLayout.Y_AXIS));
        //app/src/main/resources/Wallpaper.png
        WallpaperPanel wallpaperPanel = new WallpaperPanel(XPWallpaperLocation);

        //Notepad Button
        BufferedImage NotepadIcon;
        NotepadIcon = URLtoBufferedImage.convert(NotepadIconLocation);
        NotepadIcon = Scalr.resize(NotepadIcon,100);
        var NotepadButton = new JButton(new ImageIcon(NotepadIcon));

        //Calculator button
        BufferedImage CalculatorIcon;
        CalculatorIcon = URLtoBufferedImage.convert(CalculatorIconLocation);
        CalculatorIcon = Scalr.resize(CalculatorIcon,100);
        var CalculatorButton = new JButton(new ImageIcon(CalculatorIcon));

        wallpaperPanel.add(NotepadButton);
        wallpaperPanel.add(CalculatorButton);

        PanelCenter.add(wallpaperPanel);
        


        //Creating the panel at bottom and adding components
        JPanel TaskBar = new JPanel(); // the panel is not visible in output
        var TaskBarLocation = getClass().getResource("/TaskBar.png");
        var TaskBarImage = URLtoBufferedImage.convert(TaskBarLocation);
        TaskBarImage = Scalr.resize(TaskBarImage, width, 50);
        TaskBar.add(new JLabel(new ImageIcon(TaskBarImage)));
        TaskBar.setLayout(new BoxLayout(TaskBar, BoxLayout.X_AXIS));


        //Button Fuctionality
        m13.addActionListener(e -> {
                frame.setVisible(false);
                frame.dispose();
                new MainMenu();
        });

        NotepadButton.addActionListener(e -> {
            new Notepad();
        });

        CalculatorButton.addActionListener(e -> {
            new Calculator();
        });
        
        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, PanelCenter);
        frame.getContentPane().add(BorderLayout.SOUTH, TaskBar);

        frame.setVisible(true);
    }
}

//this class will draw the image on the panel
class WallpaperPanel extends JPanel
{

    private BufferedImage image;
    private int w,h;
    public WallpaperPanel(URL path){

        //reads the image
        try
        {
            image = ImageIO.read(path);
            w = Toolkit.getDefaultToolkit().getScreenSize().width;
            h = Toolkit.getDefaultToolkit().getScreenSize().height;

        } catch (IOException ioe) 
        {
            System.out.println("Could not read in the pic");
            //System.exit(0);
        }

    }
    public Dimension getPreferredSize() {
        return new Dimension(w,h);
    }
    //this will draw the image
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,w,h,this);
    }
}

class URLtoBufferedImage
{
    public static BufferedImage convert(URL url)
    {
        try
        {
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not read in the pic");
        }
    }
}