package pers.mingda.leetcode;

public class LC0201BitwiseAndOfNumbersRange {}

class LC0201Solution {

  public int rangeBitwiseAnd(int left, int right) {
    int count = 0;
    while (left != right) {
      left >>= 1;
      right >>= 1;
      count++;
    }
    return left << count;
  }
}
