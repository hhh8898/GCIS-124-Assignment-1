package peggame;

/**
 * The GameState enum represents the possible states of the peg game.
 * It is used to indicate whether the game has not started, is in progress, has reached a stalemate, or has been won.
 */

public enum GameState {
    NOT_STARTED,        // Represents game has not started
    IN_PROGRESS,        // Represents game is in progress
    STALEMATE,          // Represents game in Stalemate or Draw
    WON;                // Represents game as Won.
}
