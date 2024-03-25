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
        var PanelCenter = new JPanel();
        PanelCenter.setLayout(new BoxLayout(PanelCenter, BoxLayout.Y_AXIS));
        var labelTest = new JLabel("Test Imagine");
        //app/src/main/resources/Wallpaper.png
        URL XPWallpaperLocation = getClass().getResource("/Wallpaper.png");
        WallpaperPanel wallpaperPanel = new WallpaperPanel(XPWallpaperLocation.getPath());
        PanelCenter.add(wallpaperPanel);
        PanelCenter.add(labelTest);
        
        //Creating the panel at bottom and adding components
        JPanel PanelSouth = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        PanelSouth.add(label); // Components Added using Flow Layout
        PanelSouth.add(tf);
        PanelSouth.add(send);
        PanelSouth.add(reset);


        //Button Fuctionality
        m13.addActionListener(e -> {
                frame.setVisible(false);
                frame.dispose();
                new MainMenu();
        });

        
        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, PanelCenter);
        frame.getContentPane().add(BorderLayout.SOUTH, PanelSouth);

        frame.setVisible(true);
    }
}

//this class will draw the image on the panel
class WallpaperPanel extends JPanel
{

    private BufferedImage image;
    private int w,h;
    public WallpaperPanel(String fname){

        //reads the image
        try
        {
            image = ImageIO.read(new File(fname));
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
        g.drawImage(image,0,0,this);
    }
}