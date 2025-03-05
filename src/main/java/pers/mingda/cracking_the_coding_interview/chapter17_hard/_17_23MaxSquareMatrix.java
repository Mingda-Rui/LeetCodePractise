package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static pers.mingda.cracking_the_coding_interview.chapter17_hard._17_23MaxSquareMatrix.BLACK;

public class _17_23MaxSquareMatrix {
    public static final int BLACK = 0;
    public static final int WHITE = 1;
    MaxSquareMatrixSquare findSquare(int[][] matrix) {
        for (int n = matrix.length - 1; n >= 0; n--) {
            Optional<MaxSquareMatrixSquare> square = findSquares(matrix, n).stream().filter(s -> s.isBlackBordered(matrix)).findFirst();
            if (square.isPresent()) {
                return square.get();
            }
        }
        return null;
    }

    List<MaxSquareMatrixSquare> findSquares(int[][] matrix, int len) {
        List<MaxSquareMatrixSquare> squares = new ArrayList<>();
        for (int i = 0; i + len - 1 < matrix.length; i++) {
            for (int j = 0; j + len - 1 < matrix.length; j++) {
                squares.add(new MaxSquareMatrixSquare(i, j, len));
            }
        }
        return squares;
    }
}

record MaxSquareMatrixSquare(int x, int y , int n) {
    public boolean isValid(int[][] matrix) {
        return x >= 0
                && x + n - 1 < matrix.length
                && y >= 0
                && y + n - 1 < matrix[0].length;
    }

    public boolean isBlackBordered(int[][] matrix) {
        for (int i = x; i < x + n; i++) {
            if (matrix[i][y] != BLACK || matrix[i][y + n - 1] != BLACK) {
                return false;
            }
        }

        for (int j = y; j < y + n; j++) {
            if (matrix[x][j] != BLACK || matrix[x + n - 1][y] != BLACK) {
                return false;
            }
        }
        return true;
    }
}
