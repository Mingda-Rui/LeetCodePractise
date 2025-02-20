package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

public class _16_4TicTacWin {
    TicTacWinPiece hasWon(TicTacWinPiece[][]board, int row, int column) {
        if (board.length != board[0].length) return TicTacWinPiece.Empty;

        TicTacWinPiece piece = board[row][column];

        if (piece == TicTacWinPiece.Empty) {
            return TicTacWinPiece.Empty;
        }

        if (hasWonRow(board, row) || hasWonColumn(board, column)) {
            return piece;
        }

        if (row == column && hasWonDiagonal(board, 1)) {
            return piece;
        }

        if (row == (board.length - column - 1) && hasWonDiagonal(board, -1)) {
            return piece;
        }

        return TicTacWinPiece.Empty;
    }

    boolean hasWonRow(TicTacWinPiece[][] board, int row) {
        for (int c = 1; c < board[row].length; c++) {
            if (board[row][c] != board[row][0]) {
                return false;
            }
        }
        return true;
    }

    boolean hasWonColumn(TicTacWinPiece[][] board, int column) {
        for (int r = 1; r < board.length; r++) {
            if (board[r][column] != board[0][column]) {
                return false;
            }
        }
        return true;
    }

    boolean hasWonDiagonal(TicTacWinPiece[][] board, int direction) {
        int row = 0;
        int column = direction == 1 ? 0 : board.length - 1;
        TicTacWinPiece first = board[row][column];
        for (int i = 0; i < board.length; i++) {
            if (board[row][column] != first) {
                return false;
            }
            row += 1;
            column += direction;
        }
        return true;
    }
}

enum TicTacWinPiece {
    Empty, Red, Blue
}
