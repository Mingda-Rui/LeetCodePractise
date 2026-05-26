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