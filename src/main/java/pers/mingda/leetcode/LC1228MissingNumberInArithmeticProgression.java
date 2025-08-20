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

class LC1228BinarySearchSolution {

  public int missingNumber(int[] arr) {
    int len = arr.length;
    int diff = (arr[len - 1] - arr[0]) / len;
    return binarySearch(arr, 0, len, diff);
  }

  private int binarySearch(int[] arr, int start, int end, int diff) {
    if (start == end - 1) {
      return arr[0] + diff * end;
    }
    int mid = (start + end) / 2;
    int midVal = arr[mid];
    int expectedVal = arr[0] + mid * diff;
    if (midVal == expectedVal) {
      return binarySearch(arr, mid, end, diff);
    } else {
      return binarySearch(arr, start, mid, diff);
    }
  }
}
