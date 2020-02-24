import java.util.*;

public class HangmanGame {
    
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangingMan hangingMan = new HangingMan();
        Puzzle puzzle = new Puzzle();
        //CheatPuzzle puzzle = new CheatPuzzle();
        
        while (puzzle.isUnsolved() && hangingMan.isntDead()) {
            hangingMan.show();
            puzzle.show();
            System.out.print("\nMake a guess: ");
            String guess = scanner.nextLine();
            if (!puzzle.makeGuess(guess)) {
                hangingMan.dieSomeMore();
            }
            clearScreen();
        }
        
        if (hangingMan.isntDead()) {
            System.out.println("You win! The word was " + puzzle.getWord());
        } else {
            System.out.println("You lose! The word was " + puzzle.getWord());
        }
    }
    
    public static void clearScreen() {
        System.out.println("\f");
    }
}

