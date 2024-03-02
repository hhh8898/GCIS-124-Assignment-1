package peggame;
import java.util.Collection;

/**
 * The PegGame interface represents the different methods for a peg game
 * It defines the methods that must be implemented by a class that represents a specific peg game
 */

public interface PegGame {

     /**
     * Gets a collection of all possible moves that can be made in the current state of the game
     * @return A collection of all possible moves
     */

    Collection<Move> getPossibleMoves();

     /**
     * @return The current state of the game
     */

    GameState getGameState();

    /**
     * @param move The move to be made.
     * @throws PegGameException If the move is not valid or if an error occurs while making the move
     */

    void makeMove(Move move) throws PegGameException;
}
