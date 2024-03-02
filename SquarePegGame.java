package peggame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The SquarePegGame class represents a peg game played on a square board.
 * It is used to manage the state of the game and calculate possible moves.
 */

public class SquarePegGame implements PegGame {
    
    char[][] board;
    private GameState gameState;

    // Initializing the board 

    /**
     * Constructs a new SquarePegGame with the specified number of rows and columns.
     *
     * @param rows The number of rows in the board.
     * @param cols The number of columns in the board.
     */

    public SquarePegGame(int rows, int col){
        this.board = new char[rows][col];
        for(int x = 0; x < rows; x++){
            for(int y = 0; y < col; y++){
                board[x][y] = 'o';     
            }
        }
        board[rows/2][col/2] = '-';                 
        this.gameState = GameState.NOT_STARTED;
    }

    // Implementing methods from the interface 

    /**
     * @return A collection of possible moves for this SquarePegGame.
     */

    @Override
    public Collection<Move> getPossibleMoves(){
        List<Move> possibleMoves = new ArrayList<>(); 
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'o') {
                    // Check all possible moves from this peg
                    if (i - 2 >= 0 && board[i - 1][j] == 'o' && board[i - 2][j] == '-') {
                        possibleMoves.add(new Move(new Location(i, j), new Location(i - 2, j))); // Above
                    }
                    if (i + 2 < rows && board[i + 1][j] == 'o' && board[i + 2][j] == '-') {
                        possibleMoves.add(new Move(new Location(i, j), new Location(i + 2, j))); // Below
                    }
                    if (j - 2 >= 0 && board[i][j - 1] == 'o' && board[i][j - 2] == '-') {
                        possibleMoves.add(new Move(new Location(i, j), new Location(i, j - 2))); // Left
                    }
                    if (j + 2 < cols && board[i][j + 1] == 'o' && board[i][j + 2] == '-') {
                        possibleMoves.add(new Move(new Location(i, j), new Location(i, j + 2))); // Right
                    }
                }
            }
        }
        return possibleMoves;
    }

    /**
     * @return The current GameState of this SquarePegGame.
     */

    @Override
    public GameState getGameState(){
        return gameState;
    }

    /**
     * @param move The move to be made.
     * @throws PegGameException If the move is not valid or if an error occurs while making the move.
     */

    @Override
    public void makeMove(Move move) throws PegGameException {
        Location from = move.getFrom();
        Location to = move.getTo();

        int startRow = from.getRow();
        int startCol = from.getCol();
        int endRow = to.getRow();
        int endCol = to.getCol();

        // Check if the move is valid
        if (Math.abs(startRow - endRow) == 2 && startCol == endCol) { // Vertical move
            if (board[(startRow + endRow) / 2][startCol] == '-') {
                // Move is valid, update the board
                board[startRow][startCol] = '-';
                board[(startRow + endRow) / 2][startCol] = '-';
                board[endRow][endCol] = 'o';
                return;
            }
        } else if (startRow == endRow && Math.abs(startCol - endCol) == 2) { // Horizontal move
            if (board[startRow][(startCol + endCol) / 2] == '-') {
                // Move is valid, update the board
                board[startRow][startCol] = '-';
                board[startRow][(startCol + endCol) / 2] = '-';
                board[endRow][endCol] = 'o';
                return;
            }
        }

        // If the move is invalid
        throw new PegGameException("Invalid move --> The move is not diagonal or there is no peg to jump over");
    }

    /**
     * @return A string representation of this SquarePegGame.
     */

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                s.append(board[i][j]);
            }
            s.append("\n");
        }
        return s.toString();
    }

    /** 
     * @param obj The object to be compared for equality with this SquarePegGame
     * @return true if the specified object is equal to this SquarePegGame, otherwise false
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    SquarePegGame pok = (SquarePegGame) obj;
    if (board.length != pok.board.length) {
        return false;
    }
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] != pok.board[i][j]) {
                return false;
            }
        }
    }
    return gameState == pok.gameState;
    }
}

