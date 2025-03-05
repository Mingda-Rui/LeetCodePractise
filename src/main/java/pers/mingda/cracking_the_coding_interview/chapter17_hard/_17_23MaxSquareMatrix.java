package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class _17_23MaxSquareMatrix {
    public static final int BLACK = 0;
    public static final int WHITE = 1;
    MaxSquareMatrixSquare findSquare(int[][] matrix) {
        MaxSquareMatrixSquareCell[][] preComputed = preComputeMatrix(matrix);
        for (int n = matrix.length - 1; n >= 0; n--) {
            Optional<MaxSquareMatrixSquare> square = findSquares(matrix, n)
                    .stream()
                    .filter(s -> s.isBlackBordered(preComputed))
                    .findFirst();
            if (square.isPresent()) {
                return square.get();
            }
        }
        return null;
    }

    MaxSquareMatrixSquareCell[][] preComputeMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        MaxSquareMatrixSquareCell[][] result = new MaxSquareMatrixSquareCell[row][col];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (matrix[i][j] == WHITE) {
                    result[i][j] = new MaxSquareMatrixSquareCell(0, 0);
                } else {
                    int x = j + 1 < col ? result[i][j + 1].blacksRight() + 1 : 1;
                    int y = i + 1 < row ? result[i + 1][j].blacksBelow() + 1 : 1;
                    result[i][j] = new MaxSquareMatrixSquareCell(x, y);
                }
            }
        }
        return result;
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

record MaxSquareMatrixSquareCell(int blacksRight, int blacksBelow) {}

record MaxSquareMatrixSquare(int x, int y , int n) {
    public boolean isValid(int[][] matrix) {
        return x >= 0
                && x + n - 1 < matrix.length
                && y >= 0
                && y + n - 1 < matrix[0].length;
    }

    public boolean isBlackBordered(MaxSquareMatrixSquareCell[][] preComputed) {
        MaxSquareMatrixSquareCell topLeft = preComputed[x][y];
        if (topLeft.blacksBelow() < n && topLeft.blacksRight() < n) {
            return false;
        }

        MaxSquareMatrixSquareCell topRight = preComputed[x][y + n - 1];
        if (topRight.blacksBelow() < n) {
            return false;
        }

        MaxSquareMatrixSquareCell bottomLeft = preComputed[x + n - 1][y];
        if (bottomLeft.blacksRight() < n) {
            return false;
        }

        return true;
    }
}
