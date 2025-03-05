package pers.mingda.cracking_the_coding_interview.chapter17_hard;

public class _17_24MaxSubMatrix {
    int getMaxMatrix(int[][] matrix) {
        int max = 0;
        for (int len = 1; len <= matrix.length; len++) {
            for (int i = 0; i + len < matrix.length; i++) {
                for (int j = 0; j + len < matrix[0].length; j++) {
                    int sum = calculateSum(matrix, i, j, len);
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    int calculateSum(int[][] matrix, int x, int y, int length) {
        int sum = 0;
        for (int i = x; i + length < matrix.length; i++) {
            for (int j = y; j + length < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
