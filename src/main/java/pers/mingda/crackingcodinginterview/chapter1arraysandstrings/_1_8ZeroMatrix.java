package pers.mingda.crackingcodinginterview.chapter1arraysandstrings;

/**
 *  1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 *  column are set to 0. 
 */

public class _1_8ZeroMatrix {
    
    public static void setZeros(int[][] matrix) {
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroColumns = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroColumns[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (zeroRows[i] || zeroColumns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
