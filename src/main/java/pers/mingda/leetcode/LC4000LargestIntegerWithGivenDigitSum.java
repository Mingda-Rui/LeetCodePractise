package pers.mingda.leetcode;

public class LC4000LargestIntegerWithGivenDigitSum {}

class LC4000Solution {
  public int largestInteger(int n, int s) {
    if (n * 9 < s) {
      return -1;
    }
    int result = 0;
    while (n > 0) {
      int digit = Math.min(s, 9);
      s -= digit;
      if (result != 0) {
        result *= 10;
      }
      result += digit;
      n--;
    }
    return result;
  }
}
