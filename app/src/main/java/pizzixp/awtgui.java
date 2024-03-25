package pizzixp;

import java.awt.*;
import java.awt.event.*;

public class awtgui extends Frame
{
    awtgui()
    {

        Button b = new Button("click me");
        b.setBounds(30, 100, 80, 30);// setting button position
        add(b);                                       //adding button into frame
        setSize(300, 300);               //frame size 300 width and 300 height
        setLayout(null);                          //no layout manager
        MenuBar mb = new MenuBar();
        mb.add(new Menu("File"));
        setMenuBar(mb);


         // Add a WindowListener that listens for the windowClosing event
         addWindowListener(new WindowAdapter()
         {
             public void windowClosing(WindowEvent we)
             {
                 System.exit(0);
             }
         });

        setVisible(true);              //now frame will be visible, by default not visible
        
    }
 
}
