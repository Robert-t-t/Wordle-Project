import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.SwingConstants;

public class GameFrame extends JFrame 
{
    private GridPanel gridPanel;
    private InputPanel inputPanel;
    
    public GameFrame()
    {
        this.setTitle("Wordle");
        this.setForeground(Color.ORANGE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 600);
        this.getContentPane().setBackground(new Color(81, 81, 81));
        this.setLayout(new BorderLayout());

        // title of the game
       JLabel titleLabel = new JLabel("Wordle", SwingConstants.CENTER);
       titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
       this.add(titleLabel, BorderLayout.NORTH);



        //create and addd the input panel
        inputPanel = new InputPanel();
        inputPanel.setBackground(new Color(73,73, 73));
        this.add(inputPanel, BorderLayout.SOUTH);

        //Create and add the grid panel
        gridPanel = new GridPanel();
        this.add(gridPanel, BorderLayout.CENTER);


       this.setVisible(true);
    }



    public GridPanel getGridPanel()
    {
        return gridPanel;
    }

    public InputPanel getInputPanel()
    {
        return inputPanel;
    }

}
