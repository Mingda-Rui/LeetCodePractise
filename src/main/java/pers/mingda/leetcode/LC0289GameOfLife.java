package pers.mingda.leetcode;

public class LC0289GameOfLife {}

class LC0289Solution {

  private static final int DEAD = 0;
  private static final int LIVE = 1;

  private static final int DEAD_TO_LIVE = 2;
  private static final int LIVE_TO_LIVE = LIVE;
  private static final int DEAD_TO_DEAD = DEAD;
  private static final int LIVE_TO_DEAD = -1;

  public void gameOfLife(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        board[i][j] = nextEncodedState(i, j, board);
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        board[i][j] = decodeState(i, j, board);
      }
    }
  }

  private int nextEncodedState(int row, int col, int[][] board) {
    int currentState = decodeState(row, col, board);
    int neighborsSum = getNeighborsSum(row, col, board);
    if ((neighborsSum == 2 && currentState == LIVE) || neighborsSum == 3) {
      // next: live
      return currentState == LIVE ? LIVE_TO_LIVE : DEAD_TO_LIVE;
    }
    // next: dead
    return currentState == DEAD ? DEAD_TO_DEAD : LIVE_TO_DEAD;
  }

  private int getNeighborsSum(int row, int col, int[][] board) {
    int neighborsSum = 0;
    for (int i = row - 1; i <= row + 1; i++) {
      for (int j = col - 1; j <= col + 1; j++) {
        if (i == row && j == col) {
          continue;
        }
        neighborsSum += decodePrevState(i, j, board);
      }
    }
    return neighborsSum;
  }

  private int decodePrevState(int row, int col, int[][] board) {
    if (outOfBounds(row, col, board)) {
      return DEAD;
    }

    int state = board[row][col];
    return state == LIVE_TO_LIVE || state == LIVE_TO_DEAD ? LIVE : DEAD;
  }

  private int decodeState(int row, int col, int[][] board) {
    if (outOfBounds(row, col, board)) {
      return DEAD;
    }
    int state = board[row][col];
    return state == LIVE_TO_LIVE || state == DEAD_TO_LIVE ? LIVE : DEAD;
  }

  private boolean outOfBounds(int row, int col, int[][] board) {
    return row < 0 || row >= board.length || col < 0 || col >= board[0].length;
  }
}
