package pers.mingda.leetcode;

public class LC0048RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int rowBoundary = (n + 1) / 2;
        int columnBoundary = matrix[0].length / 2;
        for (int i = 0; i < rowBoundary; i++) {
            for (int j = 0; j < columnBoundary; j++) {
                int prev = matrix[n - 1 - j][i];
                int x = i;
                int y = j;
                for (int counter = 0; counter < 4; counter++) {
                    int tmp = matrix[x][y];
                    matrix[x][y] = prev;
                    prev = tmp;
                    int nextX = y;
                    int nextY = n - 1 - x;
                    x = nextX;
                    y = nextY;
                }
            }
        }
    }
}
