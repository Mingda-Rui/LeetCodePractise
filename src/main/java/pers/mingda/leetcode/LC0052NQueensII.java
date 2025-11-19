package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0052NQueensII {}

class LC0052Solution {

  public int totalNQueens(int n) {
    int[] colHistory = new int[n];
    Arrays.fill(colHistory, -1);
    return placeQueen(0, colHistory);
  }

  private int placeQueen(int atRow, int[] colHistory) {
    int n = colHistory.length;
    if (atRow == n) {
      return 1;
    }
    int count = 0;
    for (int j = 0; j < n; j++) {
      boolean canFit = fitQueen(atRow, j, colHistory);
      if (canFit) {
        colHistory[atRow] = j;
        count += placeQueen(atRow + 1, colHistory);
        colHistory[atRow] = -1;
      }
    }

    return count;
  }

  private boolean fitQueen(int x, int y, int[] colHistory) {
    int n = colHistory.length;
    for (int i = 0; i < n; i++) {
      if (i < x && colHistory[i] == y) {
        return false;
      }
      int offset = Math.abs(x - i);
      if (offset == 0) {
        continue;
      }
      if (y - offset >= 0 && colHistory[i] == y - offset) {
        return false;
      }
      if (y + offset < n && colHistory[i] == y + offset) {
        return false;
      }
    }
    return true;
  }
}
