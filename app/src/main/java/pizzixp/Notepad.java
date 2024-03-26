package pizzixp;

import javax.swing.*;
import java.awt.Toolkit;

public class Notepad
{
    Notepad ()
    {
        var width = Toolkit.getDefaultToolkit().getScreenSize().width;
        var height = Toolkit.getDefaultToolkit().getScreenSize().height;

        JFrame frame = new JFrame("Notepad");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var w = width / 2;       var h = height / 2;
        frame.setSize(w,h);
        frame.setVisible(true);
        
    }
}
