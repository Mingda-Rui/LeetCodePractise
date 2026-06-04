package pers.mingda.leetcode;

public class LC0944DeleteColumnsToMakeSorted {
}

class LC0944Solution {
  public int minDeletionSize(String[] strs) {
    int rows = strs.length;
    int cols = strs[0].length();
    int deleteCount = 0;
    for (int i = 0; i < cols; i++) {
      for (int j = 0; j < rows - 1; j++) {
        if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
          deleteCount++;
          break;
        }
      }
    }
    return deleteCount;
  }
}