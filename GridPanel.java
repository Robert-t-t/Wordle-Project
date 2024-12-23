
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class GridPanel extends JPanel 
{

    private JTextField[][] gridCells; // 2D arry for grid cells

    public GridPanel()
    {
        this.setLayout(new GridLayout(6, 5, 5, 5));

        gridCells = new JTextField[6][5];

        for(int row = 0; row < 6; row++)
        {

            for(int col = 0; col < 5; col++)
            {
                gridCells[row][col] = new JTextField();
                gridCells[row][col].setHorizontalAlignment(JTextField.CENTER);
                gridCells[row][col].setEditable(false);
                gridCells[row][col].setFont(new Font("Arial", Font.BOLD, 20));
                gridCells[row][col].setBackground(Color.WHITE);
                gridCells[row][col].setForeground(Color.BLACK);
                this.add(gridCells[row][col]);
            }




        }
    }

    public void updateCell(int row, int col, String letter, Color color)
    {
        gridCells[row][col].setText(letter);
        gridCells[row][col].setBackground(color);
    }
}
