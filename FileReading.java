package peggame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads a peg game from a file and constructs a SquarePegGame object based on the contents of the file.
 *
 * @param filename The name of the file to be read.
 * @return The SquarePegGame object constructed from the file.
 * @throws IOException If an I/O error occurs while reading the file.
 */

public class FileReading{
    public static SquarePegGame read(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        int rows = Integer.parseInt(br.readLine());
        String row = br.readLine(); // Read the first row
        int cols = row.length(); // Get the length of the first row
        SquarePegGame game = new SquarePegGame(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (row.charAt(j) == '.') {
                    game.board[i][j] = '-';
                } else if (row.charAt(j) == 'o') {
                    game.board[i][j] = 'o';
                }
            }
            if (i < rows - 1) { // Read the next row if there are more rows
                row = br.readLine();
            }
        }

        br.close();
        return game;
    }
}
