package pers.mingda.leetcode;

public class LC1228MissingNumberInArithmeticProgression {}

class LC1228Solution {

  public int missingNumber(int[] arr) {
    int len = arr.length;
    int diff = (arr[len - 1] - arr[0]) / len;
    for (int i = 1; i < len; i++) {
      if (arr[i] - arr[i - 1] != diff) {
        return arr[i] - diff;
      }
    }
    return arr[0];
  }
}
