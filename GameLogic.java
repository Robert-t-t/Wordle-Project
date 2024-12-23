import java.awt.Color;

public class GameLogic {

    private String targetWord = "APPLE";

    // Validate the Guess
    public boolean isValid(String guess) {
        return guess.length() == 5 && guess.matches("[A-Z]+");
    }

    public Color[] checkGuess(String guess) {
        Color[] feedback = new Color[5];

        char[] target = targetWord.toCharArray();
        char[] guessArr = guess.toCharArray();

        boolean[] matched = new boolean[5];

        // Step 1 Check for correct letters in the correct position (GREEN)

        for (int i = 0; i < 5; i++) {
            if (guessArr[i] == target[i]) {
                feedback[i] = Color.GREEN;
                matched[i] = true;
            } else {
                feedback[i] = Color.GRAY;
            }
        }

        // Setp 2 Check for correct letters in the wrong position(YELLOW)

        for (int k = 0; k < 5; k++) {
            if (feedback[k] == Color.GREEN) {
                continue;
            }

            for (int j = 0; j < 5; j++) {
                if (!matched[j] && guessArr[k] == target[j]) {
                    feedback[k] = Color.YELLOW;
                    matched[j] = true;
                    break;
                }
            }
        }

        return feedback;
    }

    public boolean isCorrentGuess(String guess) {
        return guess.equals(targetWord);
    }

    public String GetTargetWord() {
        return targetWord;
    }

}
