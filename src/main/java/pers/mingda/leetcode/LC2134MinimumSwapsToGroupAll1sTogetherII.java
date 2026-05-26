package pers.mingda.leetcode;

public class LC2134MinimumSwapsToGroupAll1sTogetherII {
}

class LC2134Solution {
  public int minSwaps(int[] nums) {
    return Math.min(minSwaps(nums, 0), minSwaps(nums, 1));
  }

  private int minSwaps(int[] nums, int target) {
    int len = nums.length;
    int[] prefixCount = new int[len];
    for (int i = 0; i < len; i++) {
      if (nums[i] == target) {
        prefixCount[i] = i == 0 ? 1 : prefixCount[i - 1] + 1;
      } else {
        prefixCount[i] = i == 0 ? 0 : prefixCount[i - 1];
      }
    }

    int totalTarget = prefixCount[len - 1];
    if (totalTarget == 0) {
      return len;
    }

    int minSwap = totalTarget - prefixCount[totalTarget - 1];
    for (int i = 0; i <= len - totalTarget; i++) {
      int head = i - 1;
      int tail = i + totalTarget - 1;
      int targets = prefixCount[tail] - (head < 0 ? 0 : prefixCount[head]);
      minSwap = Math.min(minSwap, totalTarget - targets);
    }
    return minSwap;
  }
}

class LC2134SlidingWindowSolution {
  public int minSwaps(int[] nums) {
    return Math.min(minSwaps(nums, 0), minSwaps(nums, 1));
  }

  private int minSwaps(int[] nums, int target) {
    int totalTarget = 0;
    for (int num : nums) {
      if (num == target) {
        totalTarget++;
      }
    }

    int head = 0;
    int tail = 0;
    int targetCount = 0;
    int minSwap = totalTarget;
    while (tail < nums.length) {
      if (tail - head == totalTarget) {
        if (nums[head] == target) {
          targetCount--;
        }
        head++;
      }

      if (nums[tail] == target) {
        targetCount++;
      }
      tail++;

      if (tail - head == totalTarget) {
        minSwap = Math.min(minSwap, totalTarget - targetCount);
      }
    }
    return minSwap;
  }
}