package trig3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TriangleBoard {
    private final int size;
    private final List<List<Integer>> board;

    public static final int EMPTY = 0;
    private final Random random = new Random();

    public TriangleBoard(int size) {
        this.size = size;
        board = new ArrayList<>();
        int current = 0;
        int prev = -1;
        while (current != size) {
            List<Integer> row = new ArrayList<>();
            prev += 2;
            System.out.println(prev);
            for (int c = 0; c < prev; c++) {
                row.add(EMPTY);
            }
            current = prev;
            board.add(row);

        }

    }

    public boolean spawnTrig() {
        // go over each row
        List<int[]> spawnPoints = new ArrayList<>();
        for (int row = 0; row < board.size(); row++) {
            List<Integer> rowList = board.get(row);
            for (int column = 0; column < rowList.size(); column++) {
                // if cell empty add index to a list
                if (rowList.get(column) == EMPTY) {
                    spawnPoints.add(new int[] { row, column });
                }

            }

        }
        // if empty array then return false
        if (spawnPoints.size() == 0)
            return false;
        // pick random in list
        int[] spawnLocation = spawnPoints.get(random.nextInt(spawnPoints.size()));

        // add randomly 3 or 9 at the index
        int toAdd = random.nextInt(2);
        if (toAdd == 0)
            toAdd = 3;
        else
            toAdd = 9;
        // return true
        int spawnRow = spawnLocation[0];
        int spawnCol = spawnLocation[1];
        board.get(spawnRow).set(spawnCol, toAdd);
        return true;
    }

    public void printBoard() {
        System.out.println();
        for (int r = 0; r < board.size(); r++) {
            List<Integer> row = board.get(r);

            // Pad left with spaces for triangle shape
            int padding = (size - r + 2) * 2;
            System.out.print(" ".repeat(padding));

            for (Integer val : row) {
                if (val == EMPTY) {
                    System.out.print(" 0 ");
                } else {
                    System.out.printf("%2d ", val);
                }
            }
            System.out.println();
        }
    }

    // Getter for raw board access if needed
    public List<List<Integer>> getBoard() {
        return board;
    }
}
