package pers.mingda.leetcode;

public class LC4013CountSubarraysWithEvenOddRatioII {}

class LC4013Solution {
  public long countRatioSubarrays(int[] nums, int a, int b) {
    // xEven / yOdd <= a / b
    // xEven * b <= yOdd * a
    // yOdd * a - xEven * b >= 0
    // prefixSum[j] - prefixSum[i] >= 0

    long[] prefixSum = new long[nums.length];
    for (int i = 0; i < nums.length; i++) {
      long delta = (nums[i] % 2 == 0 ? -b : a);
      long sum = (i == 0 ? 0 : prefixSum[i - 1]) + delta;
      prefixSum[i] = sum;
    }
    return mergeSortAndCount(prefixSum, 0, prefixSum.length);
  }

  private long mergeSortAndCount(long[] prefixSum, int start, int end) {
    if (start + 1 >= end) {
      return prefixSum[start] >= 0 ? 1 : 0;
    }

    int mid = start + (end - start) / 2;

    long count = mergeSortAndCount(prefixSum, start, mid) + mergeSortAndCount(prefixSum, mid, end);

    count += countValidSubarray(prefixSum, start, mid, end);

    inPlaceMerge(prefixSum, start, mid, end);

    return count;
  }

  private long countValidSubarray(long[] prefixSum, int start, int split, int end) {
    long count = 0;
    int i = start;
    for (int j = split; j < end; j++) {
      while (i < split && prefixSum[i] <= prefixSum[j]) {
        i++;
      }
      count += (i - start);
    }
    return count;
  }

  private void inPlaceMerge(long[] arr, int first, int second, int end) {
    int start = first;
    int mid = second;
    long[] temp = new long[end - start];

    int index = 0;
    while (first < mid || second < end) {
      boolean isBothNonExhausted = first < mid && second < end;
      if ((isBothNonExhausted && arr[first] < arr[second]) || (first < mid && second == end)) {
        temp[index] = arr[first];
        first++;
      } else {
        temp[index] = arr[second];
        second++;
      }
      index++;
    }
    System.arraycopy(temp, 0, arr, start, temp.length);
  }
}
