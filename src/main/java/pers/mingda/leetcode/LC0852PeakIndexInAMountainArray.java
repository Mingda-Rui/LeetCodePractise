package pers.mingda.leetcode;

public class LC0852PeakIndexInAMountainArray {}

class LC0852Solution {

  public int peakIndexInMountainArray(int[] arr) {
    return findPeak(arr);
  }

  private int findPeak(int[] arr) {
    int head = 0;
    int tail = arr.length;

    while (head + 1 < tail) {
      int mid = (head + tail) / 2;
      int height = arr[mid];
      int preHeight = arr[mid - 1];
      if (height > preHeight) {
        head = mid;
      } else {
        tail = mid;
      }
    }

    return head;
  }
}
