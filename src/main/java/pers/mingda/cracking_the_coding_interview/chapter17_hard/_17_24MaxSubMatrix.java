package pers.mingda.cracking_the_coding_interview.chapter17_hard;

public class _17_24MaxSubMatrix {
    int getMaxMatrix(int[][] matrix) {
        int[][] preComputedSum = preComputedSum(matrix);
        int max = 0;
        for (int top = 0; top < matrix.length; top++) {
            for (int bottom = top; bottom < matrix.length; bottom++) {
                for (int left = 0; left < matrix[0].length; left++) {
                    for (int right = left; right < matrix[0].length; right++) {
                        int total = preComputedSum[bottom][right];
                        int topSum = preComputedSum[top][right];
                        int leftSum = preComputedSum[bottom][left];
                        int topLeftSum = preComputedSum[top][left];
                        int sum = total - topSum - leftSum + topLeftSum;
                        max = Math.max(max, sum);
                    }
                }
            }
        }
        return max;
    }

    int[][] preComputedSum(int[][] matrix) {
        int[][] preComputedSum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                preComputedSum[i][j] = calculateSum(matrix, preComputedSum, i, j);
            }
        }
        return preComputedSum;
    }

    int calculateSum(int[][] matrix, int[][] preComputedSum, int row, int col) {
        int leftSum = col - 1 < 0 ? 0 : preComputedSum[row][col - 1];
        int topSum = row - 1 < 0 ? 0 : preComputedSum[row - 1][col];
        int topLeftSum = col - 1 < 0 || row - 1 < 0 ? 0 : preComputedSum[row - 1][col - 1];
        return leftSum + topSum - topLeftSum + matrix[row][col];
    }

    int getMaxMatrixOptimal(int[][] matrix) {
        int max = 0;
        for (int top = 0; top < matrix.length; top++) {
            int[] colSums = new int[matrix[0].length];
            for (int bottom = top; bottom < matrix.length; bottom++) {
                for (int c = 0; c < colSums.length; c++) {
                    colSums[c] += matrix[bottom][c];
                }
                int currentMax = maxSubArray(colSums);
                max = Math.max(max, currentMax);
            }
        }
        return max;
    }

    int maxSubArray(int[] array) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            max = Math.max(max, sum);
            if (sum <= 0) {
                sum = 0;
            }
        }

        return max;
    }
}
