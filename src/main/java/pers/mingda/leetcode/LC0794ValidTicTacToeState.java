package pers.mingda.leetcode;

public class LC0794ValidTicTacToeState {

}

class Solution {
    public boolean validTicTacToe(String[] board) {
        int playerX = 1;
        int playerO = -1;
        int[] record = new int[8];

        for (int x = 0; x < board.length; x++) {
            String row = board[x];
            for (int y = 0; y < row.length(); y++) {
                char move = row.charAt(y);
                if (move != ' ') {
                    int player = move == 'X' ? playerX : playerO;
                    placeMove(record, x, y, player);
                }
            }
        }
        return checkMoves(record);

    }

    private void placeMove(int[] record, int x, int y, int player) {
        record[x] += player;
        record[y + 3] += player;
        if (x == y)
            record[6] += player;
        if (x + y == 2)
            record[7] += player;
    }

    private boolean checkMoves(int[] record) {
        int winsForX = 0;
        int winsForO = 0;
        int difference = 0;
        for (int i = 0; i < record.length; i++) {
            int num = record[i];
            if (num == 3)
                winsForX++;
            else if (num == -3)
                winsForO++;
            if (i < 3)
                difference += num;
        }
        if (winsForO >= 1 && winsForX >= 1)
            return false;
        if (winsForO == 1)
            return difference == 0;
        if (winsForX >= 1)
            return difference == 1;
        return difference == 1 || difference == 0;
    }
}