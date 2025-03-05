package pers.mingda.cracking_the_coding_interview.chapter17_hard;

public class _17_24MaxSubMatrix {
    int getMaxMatrix(int[][] matrix) {
        int max = 0;
        for (int top = 0; top < matrix.length; top++) {
            for (int bottom = top; bottom < matrix.length; bottom++) {
                for (int left = 0; left < matrix[0].length; left++) {
                    for (int right = left; right < matrix[0].length; right++) {
                        int sum = calculateSum(matrix, top, bottom, left, right);
                        max = Math.max(max, sum);
                    }

                }
            }
        }
        return max;
    }

    int calculateSum(int[][] matrix, int top, int bottom, int left, int right) {
        int sum = 0;
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
