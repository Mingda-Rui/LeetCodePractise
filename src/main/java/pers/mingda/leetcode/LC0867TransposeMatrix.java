package pers.mingda.leetcode;

public class LC0867TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }
}
