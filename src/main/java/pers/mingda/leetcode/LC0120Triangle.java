package pers.mingda.leetcode;

import java.util.List;

public class LC0120Triangle {}

class LC0120Solution {

  public int minimumTotal(List<List<Integer>> triangle) {
    int[] memo = new int[triangle.size()];
    return minimumTotal(triangle, 0, 0, memo);
  }

  private int minimumTotal(List<List<Integer>> triangle, int row, int index, int[] memo) {
    int val = getVal(triangle, row, index);
    if (isBottomRow(triangle, row)) {
      memo[row] = val;
      return val;
    }

    int leftMin = isLeftEdge(index) ? minimumTotal(triangle, row + 1, index, memo) : memo[row + 1];
    int rightMin = minimumTotal(triangle, row + 1, index + 1, memo);

    int min = val + Math.min(leftMin, rightMin);
    memo[row] = min;
    return min;
  }

  private boolean isBottomRow(List<List<Integer>> triangle, int row) {
    return triangle.size() == row + 1;
  }

  private int getVal(List<List<Integer>> triangle, int row, int index) {
    return triangle.get(row).get(index);
  }

  private boolean isLeftEdge(int index) {
    return index == 0;
  }
}
