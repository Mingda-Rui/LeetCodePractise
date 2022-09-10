package pers.mingda.leetcode;

public class LC1275FindWinnerOnATicTacToeGame {

}

class Solution {
    public String tictactoe(int[][] moves) {
        // 0 - 2 row
        // 3 - 5 column
        // 6 \
        // 7 /
        int[] recordA = new int[8];
        int[] recordB = new int[8];
        for (int i = 0; i < moves.length; i++) {
            int[] move = moves[i];
            boolean isA = i % 2 == 0;
            int[] record = isA ? recordA : recordB;
            if (placeMove(record, move))
                return isA ? "A" : "B";
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    private boolean placeMove(int[] record, int[] move) {
        int rowIndex = move[0];
        int columnIndex = move[1] + 3;
        record[rowIndex]++;
        record[columnIndex]++;
        if (move[0] == move[1])
            record[6]++;
        if (move[0] + move[1] == 2)
            record[7]++;
        if (record[rowIndex] == 3 || record[columnIndex] == 3 || record[6] == 3 || record[7] == 3)
            return true;
        return false;
    }
}