package pers.mingda.leetcode;

public class LC0036ValidSudoku {

  public boolean isValidSudoku(char[][] board) {
    boolean[][] row = new boolean[9][9];
    boolean[][] column = new boolean[9][9];
    boolean[][] subBox = new boolean[9][9];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        int subBoxNum = calcSubBoxNum(i, j);
        if (board[i][j] == '.') continue;
        int val = board[i][j] - '1';
        if (
          row[i][val] || column[j][val] || subBox[subBoxNum][val]
        ) return false;

        row[i][val] = true;
        column[j][val] = true;
        subBox[subBoxNum][val] = true;
      }
    }

    return true;
  }

  private int calcSubBoxNum(int x, int y) {
    int row = x / 3;
    int column = y / 3;
    return row * 3 + column;
  }
}
