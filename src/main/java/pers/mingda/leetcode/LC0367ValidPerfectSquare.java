package pers.mingda.leetcode;

public class LC0367ValidPerfectSquare {
  public boolean isPerfectSquare(int num) {
    int sqrt = (int) Math.sqrt(num);
    return sqrt * sqrt == num;
  }

  public boolean isPerfectSquareBinarySearch(int num) {
    int start = 1;
    int end = num + 1;
    int limit = (int) Math.sqrt(Integer.MAX_VALUE);
    while (start < end) {
      int mid = start + (end - start) / 2;
      int square = mid * mid;

      if (square == num) return true;
      else if (square > num || mid > limit) end = mid;
      else start = mid + 1;
    }
    return false;
  }
}
