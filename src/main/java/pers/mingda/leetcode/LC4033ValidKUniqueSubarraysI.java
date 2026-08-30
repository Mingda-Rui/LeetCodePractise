package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.random.RandomGenerator;

public class LC4033ValidKUniqueSubarraysI {}

class LC4033Solution {
  public boolean[] validSubarrays(int[] nums, int k, int[][] queries) {
    int[] leftMostKDist = getLeftMostDist(nums, k);
    int[] leftMostKMinusOneDist = getLeftMostDist(nums, k - 1);

    RandomGenerator generator = RandomGenerator.getDefault();
    Map<Integer, Long> randomNums = new HashMap<>();

    long[] preXor = new long[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (!randomNums.containsKey(num)) {
        long random = generator.nextLong();
        randomNums.put(num, random);
      }

      long prevXor = i == 0 ? 0 : preXor[i - 1];
      preXor[i] = prevXor ^ randomNums.get(num);
    }

    boolean[] result = new boolean[queries.length];
    for (int i = 0; i < result.length; i++) {
      int l = queries[i][0];
      int r = queries[i][1];
      boolean xorCheck = ((l == 0 ? 0 : preXor[l - 1]) ^ preXor[r]) == 0;
      result[i] = xorCheck && l >= leftMostKDist[r] && l < leftMostKMinusOneDist[r];
    }
    return result;
  }

  private int[] getLeftMostDist(int[] nums, int k) {
    Map<Integer, Integer> numCount = new HashMap<>();
    int[] leftMostDist = new int[nums.length];
    if (k == 0) {
      Arrays.fill(leftMostDist, Integer.MAX_VALUE);
      return leftMostDist;
    }
    int l = 0;
    int r = 0;
    while (r < nums.length) {

      int prevDist = numCount.size();
      int prevCount = numCount.getOrDefault(nums[r], 0);
      int newDist = prevDist + (prevCount == 0 ? 1 : 0);

      if (newDist <= k) {
        numCount.put(nums[r], prevCount + 1);
        leftMostDist[r] = numCount.size() == k ? l : Integer.MAX_VALUE;
        r++;
      } else {
        int count = numCount.get(nums[l]);
        if (count == 1) {
          numCount.remove(nums[l]);
        } else {
          numCount.put(nums[l], count - 1);
        }
        l++;
      }
    }

    return leftMostDist;
  }
}
