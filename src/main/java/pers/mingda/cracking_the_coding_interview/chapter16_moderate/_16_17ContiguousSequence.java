package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

public class _16_17ContiguousSequence {
  int getMaxSum(int[] a) {
    int sum = 0;
    int maxSum = 0;
    for (int num : a) {
      sum += num;
      if (sum < 0) {
        sum = 0;
      } else {
        maxSum = Math.max(maxSum, sum);
      }
    }
    return maxSum;
  }
}
