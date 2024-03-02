package peggame;
import java.io.IOException;

/**The peg game is a puzzle game typically played on a board with holes or pegs. The objective is to remove pegs from the board by 
 * jumping over them with other pegs, similar to checkers. The goal is to remove as many pegs as possible, 
 * ideally leaving only one peg on the board. 
 * 
 * The program is seperated into 10 different java class files
 * -----------------------------------------------------------------------------------------
 * 1) Location: Represents a position on the board. It has 'row' and 'col' attributes to represent the row and column.
 * 2) Move: Represents a move from one location to another. It has 'from; and 'to' attributes to represent the starting and ending locations of the move.
 * 3) GameState: An enum representing the possible states of the game: 'NOT_STARTED', 'IN_PROGRESS', 'STALEMATE', and 'WON'.
 * 4) PegGame: An interface defining the methods that a peg game must implement, including getPossibleMoves(), getGameState(), and makeMove().
 * 5) PegGameException: A custom exception class for handling errors in the peg game.
 * 6) SquarePegGame: A class that implements the PegGame interface. It represents a peg game played on a square board. 
 *                   It has methods for getting possible moves, getting the game state, and making a move.
 * 7) FileReading: A utility class for reading the game board from a file. It has a read() method that takes a filename as input and returns a SquarePegGame object.
 * 8) CommandLineInterface: A class that provides a command-line interface for playing the peg game. 
 *              It has a playGame() method that takes a PegGame object and allows the user to play the game by entering moves via the command line.
 * 9) JunitTesting: A class which uses the junit libraries to test all classes except CommandLineInterface and Project1Main.
 * 10) Project1Main: The main class for running the peg game project. It has a 'main()' method that reads the game board from a file, 
 *                   creates a 'SquarePegGame' object, and starts the game with the 'CommandLineInterface'.
 * -----------------------------------------------------------------------------------------
 * @author Muhammed Waleed and Hashim Hyder
 * @since 01/03/2024
*/

public class Project1Main {
    public static void main(String[] args) {
        String filename = "a.txt"; 
        
        try {
            PegGame pegGame = FileReading.read(filename);
            CommandLineInterface.playGame(pegGame);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}