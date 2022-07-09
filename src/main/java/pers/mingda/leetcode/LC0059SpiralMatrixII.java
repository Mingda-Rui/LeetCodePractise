package pers.mingda.leetcode;

public class LC0059SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int numOfLayers = (n + 1) / 2;
        for (int i = 0; i < numOfLayers; i++)
            generateMatrixByLayer(matrix, i);
        return matrix;
    }

    private int[][] generateMatrixByLayer(int[][] matrix, int layer) {
        int x = layer;
        int y = layer;
        int num = calcStartNum(matrix, layer);
        int[][] iteArr = generateIteArr(matrix, layer);
        for (int[] offset: iteArr) {
            matrix[x][y] = num;
            x += offset[0];
            y += offset[1];
            num++;
        }
        return matrix;
    }

    private int calcStartNum(int[][] matrix, int layer) {
        int num = 0;
        for (int i = 0; i < layer; i++) {
            int length = matrix.length - 1 - i * 2;
            num += length * 4;
        }
        num++;
        return num;
    }

    private int[][] generateIteArr(int[][] matrix, int layer) {
        int length = matrix.length - 1 - layer * 2;
        int total = Math.max(1, length * 4);
        int[][] iteArr = new int[total][2];
        for (int i = 0; i < total; i++) {
            int partition = length == 0 ? 0 : i / length;
            switch (partition) {
                case 0 -> {
                    iteArr[i][0] = 0;
                    iteArr[i][1] = 1;
                }
                case 1 -> {
                    iteArr[i][0] = 1;
                    iteArr[i][1] = 0;
                }
                case 2 -> {
                    iteArr[i][0] = 0;
                    iteArr[i][1] = -1;
                }
                case 3 -> {
                    iteArr[i][0] = -1;
                    iteArr[i][1] = 0;
                }
            }
        }

        return iteArr;
    }
}