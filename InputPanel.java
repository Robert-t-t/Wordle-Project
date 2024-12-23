import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;



import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel
{
    JTextField textField;
    JButton submitButton;


    public InputPanel()
    {
        this.setLayout(new FlowLayout());

        //Input Field
        textField = new JTextField(10);
        textField.setPreferredSize(new Dimension(200, 40));
        textField.setBackground(Color.GREEN);
        textField.setForeground(Color.ORANGE);
        this.add(textField);

        //Submit Button
        submitButton = new JButton("Submit");
        submitButton.setForeground(Color.ORANGE);
        submitButton.setPreferredSize(new Dimension(100, 40));
        this.add(submitButton);


        

    }

    public String getInput()
    {
        return textField.getText().toUpperCase();
    }

    public JButton getButton()
    {
        return submitButton;
    }

}
