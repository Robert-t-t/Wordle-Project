import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class GameFrame extends JFrame {
    private GridPanel gridPanel;
    private InputPanel inputPanel;

    private GameLogic gameLogic;
    private int currentRow = 0;

    public GameFrame() {
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

        // create and addd the input panel
        inputPanel = new InputPanel();
        inputPanel.setBackground(new Color(73, 73, 73));
        this.add(inputPanel, BorderLayout.SOUTH);

        // Create and add the grid panel
        gridPanel = new GridPanel();
        this.add(gridPanel, BorderLayout.CENTER);

        // Initialize Game Logic
        gameLogic = new GameLogic();

        // 🎯 **Add Button Action Listener Here** 🎯
        inputPanel.getButton().addActionListener(e -> {

            String guess = inputPanel.getInput();

            // Validate Guess

            if (!gameLogic.isValid(guess)) {
                JOptionPane.showMessageDialog(this, "Invalid guess! Must be 5 letter.");
                return;
            }

            // Check the guess and update the grid

            Color[] feedback = gameLogic.checkGuess(guess);

            for (int col = 0; col < 5; col++) {
                gridPanel.updateCell(currentRow, col, String.valueOf(guess.charAt(col)), feedback[col]);
            }

            // Check if guess is corret

            if (gameLogic.isCorrentGuess(guess)) {
                JOptionPane.showMessageDialog(this, "You Win!");
                return;
            } else if (currentRow == 5) {
                JOptionPane.showMessageDialog(this, "Game Over! The word was: " + gameLogic.GetTargetWord());
            }

            currentRow++;
        });

        // 🎯 End of Button Listener 🎯

        this.setVisible(true);
    }

    public GridPanel getGridPanel() {
        return gridPanel;
    }

    public InputPanel getInputPanel() {
        return inputPanel;
    }

}
