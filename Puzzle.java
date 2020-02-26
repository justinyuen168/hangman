import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Puzzle {
    private String word;
    private String guesses;
    private final int words = 45402;
    public Puzzle() {
         try {
            File file = new File("words.txt");
            Scanner scanner = new Scanner(file);
            int i = 0;
            int x = (int)(Math.random()*words);
            String line = "";
            while (i < x) {
                line = scanner.next();
                i++;
            }
            scanner.close();
            word = line.toUpperCase();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        guesses = "";
    }

    public boolean isUnsolved() {
           for (int i = 0; i < word.length(); i++) {
            if (!guesses.contains(""+word.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public void show() {
        int i = 0;
        System.out.print("Puzzle: ");
        while (i < word.length()) {
            if (guesses.contains(""+word.charAt(i))) {
                System.out.print(word.charAt(i) + " ");
            } else {
                System.out.print("_ ");
            }
            i++;
        }

        System.out.print("Guesses: ");
        int j = 0;
        while (j < guesses.length()) {
            System.out.print(guesses.charAt(j));
            j++;
            if (j != guesses.length()) {
                System.out.print(", ");
            }
        }
    }

    public boolean makeGuess(String letter) {
         letter = letter.toUpperCase();
        guesses += letter;
        return word.contains(letter);
    }

    public String getWord() {
        return word;
    }
}
