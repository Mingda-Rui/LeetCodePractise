package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0873LengthOfLongestFibonacciSubsequence {
}

class LC0873Solution {
  public int lenLongestFibSubsequence(int[] arr) {

    Map<Integer, Integer> valToIdx = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      valToIdx.put(arr[i], i);
    }
    int longest = 0;

    int[][] dp = new int[arr.length][arr.length];

    for (int curr = 0; curr < arr.length; curr++) {
      int currVal = arr[curr];
      for (int next = curr + 1; next < arr.length; next++) {
        int nextVal = arr[next];
        int prevVal = nextVal - currVal;
        if (prevVal >= currVal || !valToIdx.containsKey(prevVal)) {
          dp[curr][next] = 2;
        } else {
          int prev = valToIdx.get(prevVal);
          dp[curr][next] = dp[prev][curr] + 1;
        }
        longest = Math.max(longest, dp[curr][next]);
      }
    }

    return longest > 2 ? longest : 0;
  }
}
