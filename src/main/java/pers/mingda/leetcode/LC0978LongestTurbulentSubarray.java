package pers.mingda.leetcode;

public class LC0978LongestTurbulentSubarray {}

class LC0978Solution {

  public int maxTurbulenceSize(int[] arr) {
    int max = 1;
    int head = 0;
    int tail = 1;
    int isGreater = 0;
    while (tail < arr.length) {
      if (head == tail - 1) {
        if (arr[head] == arr[tail]) {
          head++;
        } else {
          isGreater = arr[head] > arr[tail] ? 1 : -1;
        }
        tail++;
      } else if (
        (isGreater == 1 && arr[tail - 1] < arr[tail]) ||
        (isGreater == -1 && arr[tail - 1] > arr[tail])
      ) {
        tail++;
        isGreater *= -1;
      } else {
        head = tail - 1;
      }
      max = Math.max(max, tail - head);
    }
    return max;
  }
}
