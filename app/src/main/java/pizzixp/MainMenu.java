package pizzixp;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class MainMenu
{
    MainMenu()
    {
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();


        //Menu principale frame
        var MainMenu = new JFrame("Main Menu");
        MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenu.setSize(600, 400);
        var BottoneJswing = new JButton("Java Swing GUI");
        var BottoneAWT = new JButton("AWT GUI");
        Dimension buttonSize = new Dimension(width, height);
        BottoneJswing.setPreferredSize(buttonSize);
        BottoneAWT.setPreferredSize(buttonSize);
        var PanelCenter = new JPanel();
        PanelCenter.setLayout(new BoxLayout(PanelCenter, BoxLayout.X_AXIS));

        PanelCenter.add(Box.createVerticalGlue()); // Spazio sopra
        PanelCenter.add(Box.createHorizontalGlue()); // Spazio a sinistra
        PanelCenter.add(BottoneJswing);
        PanelCenter.add(BottoneAWT);
        PanelCenter.add(Box.createHorizontalGlue()); // Spazio a destra
        PanelCenter.add(Box.createVerticalGlue()); // Spazio sotto



        //Funzionalita Bottoni
        BottoneJswing.addActionListener(e ->
        {
            new JavaSwingGui();
            MainMenu.setVisible(false);
        }
        );

        BottoneAWT.addActionListener(e ->
        {
            new awtgui();
            MainMenu.setVisible(false);
        }
        );
        
        MainMenu.add(PanelCenter);
        MainMenu.setVisible(true);
    }

}
