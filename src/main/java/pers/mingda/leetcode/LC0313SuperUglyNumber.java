package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0313SuperUglyNumber {
}

class Solution {
  // Change val to long to handle overflow cleanly
  record UglyNumber(int val, int prime, int index) {}

  public int nthSuperUglyNumber(int n, int[] primes) {
    // Sort based on the long value safely
    Queue<UglyNumber> queue = new PriorityQueue<>(Comparator.comparingInt(UglyNumber::val));

    for (int prime : primes) {
      queue.add(new UglyNumber(prime, prime, 0));
    }

    int[] nums = new int[n];
    nums[0] = 1;
    int counter = 1;

    while (counter < n) {
      UglyNumber un = queue.remove();

      // Cast un.val() to int for comparison since nums holds ints
      if ((int)un.val() != nums[counter - 1]) {
        nums[counter] = un.val();
        counter++;
      }

      // Use long multiplication to prevent overflow from corrupting the heap sorting
      long nextVal = (long) nums[un.index() + 1] * un.prime();

      // Only push back if it hasn't overflowed past Integer.MAX_VALUE
      if (nextVal <= Integer.MAX_VALUE) {
        queue.add(new UglyNumber((int)nextVal, un.prime(), un.index() + 1));
      }
    }
    return nums[n - 1];
  }
}