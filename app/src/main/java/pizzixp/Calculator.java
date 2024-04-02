package pizzixp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import net.objecthunter.exp4j.*;;
public class Calculator
{
    Calculator()
    {
        System.out.println("Calculator object created");

        var width = Toolkit.getDefaultToolkit().getScreenSize().width;
        var height = Toolkit.getDefaultToolkit().getScreenSize().height;

        //Frame Creation
        var frame = new JFrame("Calculator");
        frame.setSize(300, 300);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        //Calculator Display
        var DisplayPanel = new JPanel();
        DisplayPanel.setLayout(new BoxLayout(DisplayPanel, BoxLayout.X_AXIS));
        var Display = new JTextField();
        //Display.setText("0");
        Display.setEditable(false);

        DisplayPanel.add(Display);

        //Main Panel
        var MainPanel = new JPanel();
        MainPanel.setLayout(new GridLayout(4,4));
        MainPanel.setBorder(new EmptyBorder(10,10,10,10));
        initializeDivideSection(MainPanel);

        //make buttons write to the display
        var buttons = MainPanel.getComponents();
        System.out.println(buttons.toString());
        for (var button : buttons)
        {
            if (button instanceof JPanel)
            {
                var row = (JPanel) button;
                var rowButtons = row.getComponents();
                for (var rowButton : rowButtons)
                {
                    if (rowButton instanceof JButton)
                    {
                        var button1 = (JButton) rowButton;
                        button1.addActionListener(e -> {
                            if (!button1.getText().equals("="))
                            {
                                Display.setText(Display.getText() + button1.getText());
                            }
                        });
                    }
                }
            }
        }
        
        //Make equal button calculate the expression
        var ButtonEqual = (JButton) ((JPanel) MainPanel.getComponent(3)).getComponent(2);
        ButtonEqual.addActionListener(e -> {
            try
            {
                var expression = new ExpressionBuilder(Display.getText()).build();
                Display.setText(Double.toString(expression.evaluate()));
            }
            catch (Exception ex)
            {
                Display.setText("Error");
            }
        });

        // Add DisplayPanel and MainPanel to frame with GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;

        //Frame Generation
        gbc.weighty = 0.3;
        frame.add(DisplayPanel,gbc);
        gbc.weighty = 0.7;
        gbc.weightx = 0.8;
        frame.add(MainPanel,gbc);
        frame.setVisible(true);

    }





    private void initializeDivideSection(JPanel MainPanel) {
        //Row 1
        var Row1 = new JPanel();
        Row1.setLayout(new GridLayout(1,4));
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
        Row2.setLayout(new GridLayout(1,4));
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
        Row3.setLayout(new GridLayout(1,4));
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
        Row4.setLayout(new GridLayout(1,4));
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
        
    }
}
