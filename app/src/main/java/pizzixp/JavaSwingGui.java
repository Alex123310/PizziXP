package pizzixp;

import java.awt.BorderLayout;
import javax.swing.*;
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
        m1.add(m11);
        m1.add(m12);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);


        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        /*----Cancella Dopo----Start*/
        var mb1 = new JMenuBar();
        var mb11 = new JMenu("TEST DI UNA SECONDA BARRA");
        mb1.add(mb11);
        frame.getContentPane().add(BorderLayout.SOUTH, mb1);
        var mb3 = new JMenuBar();
        var mb31 = new JMenu("TEST DI UNA TERZA BARRA");
        mb3.add(mb31);
        frame.getContentPane().add(BorderLayout.CENTER, mb3);
        /*---Cancella Dopo-------End*/
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.setVisible(true);
    }
}