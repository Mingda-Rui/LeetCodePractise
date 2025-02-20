package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

public class _16_4TicTacWin {

    TicTacWinPiece[] winnerHashtable;

    TicTacWinPiece hasWon(int board) {
        return winnerHashtable[board];
    }

    int convertBoardToInt(TicTacWinPiece[][] board) {
        int sum = 0;
        for (TicTacWinPiece[] ticTacWinPieces : board) {
            for (TicTacWinPiece ticTacWinPiece : ticTacWinPieces) {
                /* Each value in enum has an integer associated with it. We
                 * can just use that. */
                int value = ticTacWinPiece.ordinal();
                sum = sum * 3 + value;
            }
        }
        return sum;
    }
}

enum TicTacWinPiece {
    Empty, Red, Blue
}
