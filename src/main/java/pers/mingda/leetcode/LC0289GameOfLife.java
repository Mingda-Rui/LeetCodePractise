package pers.mingda.leetcode;

public class LC0289GameOfLife {}

class LC0289Solution {

  public void gameOfLife(int[][] board) {
    int[][] currentStates = new int[board.length][board[0].length];
    copy2DArray(board, currentStates);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        board[i][j] = nextState(i, j, currentStates);
      }
    }
  }

  private int nextState(int row, int col, int[][] board) {
    int currentState = getState(row, col, board);
    int neighborsSum = getNeighborsSum(row, col, board);
    if ((neighborsSum == 2 && currentState == 1) || neighborsSum == 3) {
      return 1;
    }
    return 0;
  }

  private int getNeighborsSum(int row, int col, int[][] board) {
    int neighborsSum = 0;
    for (int i = row - 1; i <= row + 1; i++) {
      for (int j = col - 1; j <= col + 1; j++) {
        if (i == row && j == col) {
          continue;
        }
        neighborsSum += getState(i, j, board);
      }
    }
    return neighborsSum;
  }

  private int getState(int row, int col, int[][] board) {
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
      return 0;
    }
    return board[row][col];
  }

  private void copy2DArray(int[][] original, int[][] copied) {
    if (original.length != copied.length || original[0].length != copied[0].length) {
      return;
    }

    for (int i = 0; i < original.length; i++) {
      System.arraycopy(original[i], 0, copied[i], 0, original[0].length);
    }
  }
}
