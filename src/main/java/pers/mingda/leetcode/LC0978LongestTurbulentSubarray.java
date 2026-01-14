package pers.mingda.leetcode;

public class LC0978LongestTurbulentSubarray {}

class LC0978Solution {

  public int maxTurbulenceSize(int[] arr) {
    int max = 1;
    int head = 0;

    for (int tail = 1; tail < arr.length; tail++) {
      int c = Integer.compare(arr[tail - 1], arr[tail]);
      if (c == 0) {
        head = tail;
      } else if (tail == arr.length - 1 || c * Integer.compare(arr[tail], arr[tail + 1]) != -1) {
        max = Math.max(max, tail - head + 1);
        head = tail;
      }
    }
    return max;
  }
}
