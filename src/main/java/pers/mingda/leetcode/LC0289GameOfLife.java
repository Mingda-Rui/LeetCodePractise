package pers.mingda.leetcode;

public class LC0289GameOfLife {}

class LC0289Solution {

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
    if ((neighborsSum == 2 && currentState == 1) || neighborsSum == 3) {
      // next: live
      return currentState == 1 ? 1 : 2;
    }
    return currentState == 0 ? 0 : -1;
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
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
      return 0;
    }

    int state = board[row][col];
    return state == 1 || state == -1 ? 1 : 0;
  }

  private int decodeState(int row, int col, int[][] board) {
    // dead -> live : 2
    // live -> live : 1
    // dead -> dead : 0
    // live -> dead : -1
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
      return 0;
    }
    int state = board[row][col];
    return state > 0 ? 1 : 0;
  }
}
