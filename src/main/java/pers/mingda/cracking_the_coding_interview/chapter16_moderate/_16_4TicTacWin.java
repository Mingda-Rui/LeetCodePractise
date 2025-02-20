package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

public class _16_4TicTacWin {
    TicTacWinPiece hasWon(TicTacWinPiece[][]board, int row, int column) {
        for (int i = 0; i < board.length; i++) {
            /* Check Rows */
            if (hasWinner(board[i][0], board[i][1], board[i][2])) {
                return board[i][0];
            }

            /* Check Columns */
            if (hasWinner(board[0][i], board[1][i], board[2][i])) {
                return board[0][i];
            }
        }

        /* Check Diagonal */
        if (hasWinner(board[0][0], board[1][1], board[2][2])) {
            return board[0][0];
        }

        if (hasWinner(board[0][2], board[1][1], board[2][0])) {
            return board[0][2];
        }

        return TicTacWinPiece.Empty;
    }

    boolean hasWinner(TicTacWinPiece p1, TicTacWinPiece p2, TicTacWinPiece p3) {
        if (p1 == TicTacWinPiece.Empty) {
            return false;
        }
        return p1 == p2 && p2 == p3;
    }
}

enum TicTacWinPiece {
    Empty, Red, Blue
}
