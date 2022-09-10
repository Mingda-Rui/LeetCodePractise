package pers.mingda.leetcode;

public class LC0348DesignTicTacToe {

}

class TicTacToe {

    int n;
    int[] rowRecord;
    int[] columnRecord;
    int diagRecord;
    int antiDiagRecord;

    public TicTacToe(int n) {
        this.n = n;
        this.rowRecord = new int[n];
        this.columnRecord = new int[n];
        this.diagRecord = 0;
        this.antiDiagRecord = 0;
    }

    public int move(int row, int col, int player) {
        int playerCode = getPlayCode(player);
        rowRecord[row] += playerCode;
        columnRecord[col] += playerCode;
        if (row == col)
            diagRecord += playerCode;
        if (row + col == n - 1)
            antiDiagRecord += playerCode;
        if (Math.abs(rowRecord[row]) == n || Math.abs(columnRecord[col]) == n || Math.abs(diagRecord) == n || Math.abs(antiDiagRecord) == n)
            return player;
        return 0;
    }

    private int getPlayCode(int play) {
        if (play == 1)
            return 1;
        else
            return -1;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
