package pers.mingda.leetcode;

public class LC0059SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int numOfLayers = (n + 1) / 2;
        for (int i = 0; i < numOfLayers; i++) {
            int startNum = i == 0 ? 1 : result[i][i - 1] + 1;
            result[i][i] = startNum;
            int length = n - i * 2;
            int boundary = n - i - 1;
            for (int j = 1; j < length; j++)
                result[i][i + j] = result[i][i + j - 1] + 1;
            for (int j = 1; j < length; j++)
                result[i + j][boundary] = result[i + j - 1][boundary] + 1;
            for (int j = 1; j < length; j++)
                result[boundary][boundary - j] = result[boundary][boundary - j + 1] + 1;
            for (int j = 1; j < length - 1; j++) {
                result[boundary - j][i] = result[boundary - j + 1][i] + 1;
            }
        }
        return result;
    }


    public int[][] generateMatrixCalcNum(int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = calcNum(result ,i, j);
            }
        }
        return result;
    }

    private int calcNum(int[][] matrix, int x, int y) {

        int n = matrix.length;
        int numOfLayers = (n + 1) / 2;
        int mid = matrix.length / 2;
        if (n % 2 == 0 && x >= mid && y >= mid)
            mid--;
        int xOffSet = Math.abs(x - mid);
        int yOffSet = Math.abs(y - mid);
        int layer = numOfLayers - Math.max(xOffSet, yOffSet);

        int startNumOfTheLayer = 0;
        for (int i = 0; i < layer; i++) {
            int length = n - 1 - i * 2;
            startNumOfTheLayer += length * 4;
        }
        startNumOfTheLayer++;
        if (x == y && x == layer)
            return startNumOfTheLayer;
        if (x <= y)
            return startNumOfTheLayer + (x - layer) + (y - layer);
        int length = n - 1 - layer * 2;
        if (x == n - layer * 2)
            return startNumOfTheLayer + length * 2 + (length - y);
        else
            return startNumOfTheLayer + length * 3 + (length - x);
    }
}