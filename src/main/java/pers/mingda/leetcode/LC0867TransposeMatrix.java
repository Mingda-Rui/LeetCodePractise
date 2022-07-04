package pers.mingda.leetcode;

public class LC0867TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        if (matrix.length == matrix[0].length)
            return inPlaceTranspose(matrix);
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    private int[][] inPlaceTranspose(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        return matrix;
    }
}
