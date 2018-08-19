package recursion;

import java.util.ArrayList;
import java.util.List;

/** Solves the problem of the 8 (or N queens) */
public class Queens {
    public static void main(String[] args) {
        // All possible ways of arranging N queens
        List<Integer[]> result = solveQueens(16);

        // Every possible combination is printed
        for(Integer[] r:result) {
            for(Integer ri:r) {
                System.out.print(ri);
            }
            System.out.println();
        }
    }

    public static List<Integer[]> solveQueens(int n) {
        // The value of each array member indicates the column of a queen in a row
        // For instance: if positions[2] == 3, indicates that in row 3 the queen will be in column 4

        List<Integer[]> results = new ArrayList<>();

        Integer[] columns = new Integer[n];
        placeQueens(0,columns,results);

        return results;
    }

    public static void placeQueens(int row, Integer[] columns, List<Integer[]> results) {
        if (row == columns.length) {
            results.add(columns.clone());
            return;
        }
        for(int col = 0; col < columns.length; col++) {
            if (checkValid(columns, row, col)) {
                columns[row] = col;
                placeQueens(row + 1, columns, results);
            }
        }
    }

    // Check whether (row1, col1) is a valid position for a queen
    // taking into account the current status of the table
    public static boolean checkValid(Integer[] columns,int row1,int col1) {
        for(int row2 = 0; row2 < row1; row2++) {
            int col2;

            if (columns[row2] != null) {
                col2 = columns[row2];
            }
            else {
                return true;
            }

            if (col2 == col1) {
                return false;
            }

            int rowDistance = row1 - row2;
            int colDistance = Math.abs(col2 - col1);

            if (rowDistance == colDistance) {
                return false;
            }
        }

        return true;
    }
}
