package pers.mingda.leetcode;

public class LC3133MinimumArrayEnd {
}

class LC3133Solution {
  public long minEnd(int n, int x) {
    long result = x;

    while (n - 1 > 0) {
      result = (result + 1) | x;
      n--;
    }

    return result;
  }
}