package pers.mingda.leetcode;

public class LC1275FindWinnerOnATicTacToeGame {}

class LC1275Solution {
    public String tictactoe(int[][] moves) {
        // 0 - 2 row
        // 3 - 5 column
        // 6 \
        // 7 /
        int[] record = new int[8];
        for (int i = 0; i < moves.length; i++) {
            int[] move = moves[i];
            int player = i % 2 == 0 ? 1 : -1;
            if (placeMove(record, move, player)) return player == 1 ? "A" : "B";
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    private boolean placeMove(int[] record, int[] move, int player) {
        int rowIndex = move[0];
        int columnIndex = move[1] + 3;
        record[rowIndex] += player;
        record[columnIndex] += player;
        if (move[0] == move[1]) record[6] += player;
        if (move[0] + move[1] == 2) record[7] += player;
        if (Math.abs(record[rowIndex]) == 3
                || Math.abs(record[columnIndex]) == 3
                || Math.abs(record[6]) == 3
                || Math.abs(record[7]) == 3) return true;
        return false;
    }
}