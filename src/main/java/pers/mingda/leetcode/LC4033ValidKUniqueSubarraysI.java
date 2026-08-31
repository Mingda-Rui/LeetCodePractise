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

class LC4033MoAlgorithmSolution {
  public boolean[] validSubarrays(int[] nums, int k, int[][] queries) {
    int qLen = queries.length;
    int[][] iQueries = new int[qLen][3];
    for (int i = 0; i < qLen; i++) {
      int[] query = queries[i];
      iQueries[i][0] = query[0];
      iQueries[i][1] = query[1];
      iQueries[i][2] = i;
    }
    int blockSize = Math.max(1, (int) Math.sqrt(nums.length));
    Arrays.sort(
        iQueries,
        (q1, q2) -> {
          int block1 = q1[0] / blockSize;
          int block2 = q2[0] / blockSize;
          if (block1 == block2) {
            return block1 % 2 == 0 ? Integer.compare(q1[1], q2[1]) : Integer.compare(q2[1], q1[1]);
          }
          return Integer.compare(block1, block2);
        });

    Map<Integer, Integer> numCounter = new HashMap<>();
    boolean[] result = new boolean[qLen];

    int lPointer = 0;
    int rPointer = -1;
    int odds = 0;
    for (int[] query : iQueries) {
      int l = query[0];
      int r = query[1];
      if (lPointer > l) {
        while (lPointer != l) {
          lPointer--;
          int count = numCounter.getOrDefault(nums[lPointer], 0);
          numCounter.put(nums[lPointer], count + 1);
          odds += ((count + 1) % 2 == 0 ? -1 : 1);
        }
      }

      if (rPointer < r) {
        while (rPointer != r) {
          rPointer++;
          int count = numCounter.getOrDefault(nums[rPointer], 0);
          numCounter.put(nums[rPointer], count + 1);
          odds += ((count + 1) % 2 == 0 ? -1 : 1);
        }
      }

      if (lPointer < l) {
        while (lPointer != l) {
          int count = numCounter.get(nums[lPointer]);
          if (count == 1) {
            numCounter.remove(nums[lPointer]);
          } else {
            numCounter.put(nums[lPointer], count - 1);
          }
          odds += ((count - 1) % 2 == 0 ? -1 : 1);
          lPointer++;
        }
      }

      if (rPointer > r) {
        while (rPointer != r) {
          int count = numCounter.get(nums[rPointer]);
          if (count == 1) {
            numCounter.remove(nums[rPointer]);
          } else {
            numCounter.put(nums[rPointer], count - 1);
          }
          odds += ((count - 1) % 2 == 0 ? -1 : 1);
          rPointer--;
        }
      }

      int index = query[2];
      result[index] = numCounter.size() == k && odds == 0;
    }

    return result;
  }
}
