package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LC0054SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        return spiralOrderIterative(matrix);
    }

    public List<Integer> spiralOrderIterative(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        int rowL = matrix.length;
        int columnL = matrix[0].length;
        int[] coord = new int[]{0, 0};
        while(rowL > 0 && columnL > 0) {
            if (rowL == 1) {
                fastForwardLine(matrix, coord, result, 0, 1, columnL);
            } else if (columnL == 1) {
                fastForwardLine(matrix, coord, result, 1, 0, rowL);
            } else {
                fastForwardCircle(matrix, coord, result, rowL, columnL);
            }

            coord[0]++;
            coord[1]++;
            rowL -= 2;
            columnL -= 2;
        }

        return result;
    }

    private void fastForwardCircle(int[][] matrix, int[] coord, List<Integer> result, int rowL, int columnL) {
        fastForwardLine(matrix, coord, result, 0, 1, columnL - 1);
        fastForwardLine(matrix, coord, result, 1, 0, rowL - 1);
        fastForwardLine(matrix, coord, result, 0, -1, columnL - 1);
        fastForwardLine(matrix, coord, result, -1, 0, rowL - 1);
    }

    private void fastForwardLine(int[][] matrix, int[] coord, List<Integer> result, int xOffset, int yOffset, int length) {
        for (int i = 0; i < length; i++) {
            int val = getVal(matrix, coord);
            result.add(val);
            coord[0] += xOffset;
            coord[1] += yOffset;
        }
    }

    private int getVal(int[][] matrix, int[] coord) {
        int x = coord[0];
        int y = coord[1];
        return matrix[x][y];
    }

}