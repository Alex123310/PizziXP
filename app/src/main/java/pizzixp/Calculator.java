package pizzixp;

import javax.swing.*;

public class Calculator
{
    Calculator()
    {
        System.out.println("Calculator object created");

        var frame = new JFrame("Calculator");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        //Calculator Display
        var DisplayPanel = new JPanel();
        var Display = new JTextField();
        Display.setText("0");
        Display.setEditable(false);

        DisplayPanel.add(Display);

        //Main Panel
        var MainPanel = new JPanel();
        MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));
        
        //Row 1
        var Row1 = new JPanel();
        Row1.setLayout(new BoxLayout(Row1, BoxLayout.X_AXIS));
        var Button1 = new JButton("1");
        var Button2 = new JButton("2");
        var Button3 = new JButton("3");
        var ButtonPlus = new JButton("+");

        Row1.add(Button1);
        Row1.add(Button2);
        Row1.add(Button3);
        Row1.add(ButtonPlus);

        //Row 2
        var Row2 = new JPanel();
        Row2.setLayout(new BoxLayout(Row2, BoxLayout.X_AXIS));
        var Button4 = new JButton("4");
        var Button5 = new JButton("5");
        var Button6 = new JButton("6");
        var ButtonMinus = new JButton("-");

        Row2.add(Button4);
        Row2.add(Button5);
        Row2.add(Button6);
        Row2.add(ButtonMinus);

        //Row 3
        var Row3 = new JPanel();
        Row3.setLayout(new BoxLayout(Row3, BoxLayout.X_AXIS));
        var Button7 = new JButton("7");
        var Button8 = new JButton("8");
        var Button9 = new JButton("9");
        var ButtonMultiply = new JButton("*");

        Row3.add(Button7);
        Row3.add(Button8);
        Row3.add(Button9);
        Row3.add(ButtonMultiply);

        //Row 4
        var Row4 = new JPanel();
        Row4.setLayout(new BoxLayout(Row4, BoxLayout.X_AXIS));
        var Button0 = new JButton("0");
        var ButtonDot = new JButton(".");
        var ButtonEqual = new JButton("=");
        var ButtonDivide = new JButton("/");

        Row4.add(Button0);
        Row4.add(ButtonDot);
        Row4.add(ButtonEqual);
        Row4.add(ButtonDivide);

        //Adding Rows to Main Panel
        MainPanel.add(Row1);
        MainPanel.add(Row2);
        MainPanel.add(Row3);
        MainPanel.add(Row4);

        //Frame Generation
        frame.add(DisplayPanel);
        frame.add(MainPanel);
        frame.setVisible(true);

    }
}
