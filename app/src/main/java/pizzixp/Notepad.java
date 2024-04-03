package pizzixp;

import javax.print.DocFlavor.READER;
import javax.swing.*;

import java.awt.TextArea;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;
import java.io.FileReader;
import javax.swing.filechooser.*;
import javax.swing.plaf.FileChooserUI;
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


        //Menu bar
        JMenuBar mb = new JMenuBar();
        JMenu FileMenu = new JMenu("FILE");
        var CloseMenuItem = new JMenuItem("Close");
        var ExitMenuItem = new JMenuItem("Exit");
        var OpenMenuItem = new JMenuItem("Open");

        FileMenu.add(CloseMenuItem);
        FileMenu.add(ExitMenuItem);
        FileMenu.add(OpenMenuItem);

        mb.add(FileMenu);
        frame.setJMenuBar(mb);
        //Text area
        var NotepadPanel = new JPanel();        
        JTextArea textArea = new JTextArea();
        NotepadPanel.add(textArea);

        //Save Text area to file
        var SaveMenuItem = new JMenuItem("Save");
        FileMenu.add(SaveMenuItem);


        frame.add(NotepadPanel);


        CloseMenuItem.addActionListener(e -> 
        {
            frame.dispose();
        });

        ExitMenuItem.addActionListener(e -> 
        {
            System.exit(0);
        });
        
        OpenMenuItem.addActionListener(e ->
        {
            var fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES","txt","text");
            fileChooser.setFileFilter(filter);
            var returnValue = fileChooser.showOpenDialog(textArea);
            if (returnValue == JFileChooser.APPROVE_OPTION)
            {
                var file = fileChooser.getSelectedFile();
                try
                {
                    String text;
                    text = new Scanner(file).nextLine();
                    textArea.setText(text);
                }
                catch(IOException e1)
                {
                    System.out.println(e1);
                    throw new RuntimeException("Accirt");
                }
                

            }
        });
        SaveMenuItem.addActionListener(e -> 
        {
            var text = textArea.getText();
            var fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            fileChooser.setFileFilter(filter);
            var returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION)
            {
                var file = fileChooser.getSelectedFile();
                if (!file.getName().toLowerCase().endsWith(".txt")) {
                    file = new File(file.getParentFile(), file.getName() + ".txt");
                }
                try
                {
                    var writer = new FileWriter(file);
                    writer.write(text);
                    writer.close();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        
        frame.setVisible(true);
        
    }
}
