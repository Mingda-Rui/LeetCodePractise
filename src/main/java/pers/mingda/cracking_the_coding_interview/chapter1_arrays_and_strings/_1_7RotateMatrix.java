package pers.mingda.cracking_the_coding_interview.chapter1_arrays_and_strings;

/**
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */

public class _1_7RotateMatrix {
    public static void rotate(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows / 2; i++) {
            for (int j = 0; j < (columns + 1) / 2; j++) {
                rotatePoint(matrix, i, j);
            }
        }
    }

    private static void rotatePoint(int[][] matrix, int x, int y) {
        int cache = matrix[x][y];
        for (int i = 0; i < 4; i++) {
            int nextX = y;
            int nextY = matrix[0].length - 1 - x;

            int tmp = matrix[nextX][nextY];
            matrix[nextX][nextY] = cache;
            cache = tmp;

            x = nextX;
            y = nextY;
        }
        
    }

    public static void rotateByLayer(int[][] matrix) {
        for (int layer = 0; layer < matrix.length / 2; layer++) {
            for (int i = layer; i < matrix.length - layer - 1; i++) {
                rotatePoint(matrix, layer, i);
            }
        }
    }
}
