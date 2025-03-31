package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0312BurstBalloons {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[][] memo = new int[len][len];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return maxCoinsSegement(nums, 0, len - 1, memo);
    }

    private int maxCoinsSegement(int[] nums, int left, int right, int[][] memo) {
        if (left > right) {
            return 0;
        }

        if (memo[left][right] != -1) {
            return memo[left][right];
        }

        if (left == right) {
            int max = calc(nums, left, right, left);
            memo[left][right] = max;
            return max;
        }

        if (isSameNumSubArray(nums, left, right)) {
            int num = nums[left];
            int len = right - left + 1;
            int max = len * num * num * num;
            memo[left][right] = max;
            return max;
        }

        int max = 0;
        for (int i = left; i <= right; i++) {
            int sum = 0;
            sum += maxCoinsSegement(nums, left, i - 1, memo);
            sum += maxCoinsSegement(nums, i + 1, right, memo);
            sum += calc(nums, left, right, i);

            max = Math.max(max, sum);
        }
        memo[left][right] = max;
        return max;
    }

    private boolean isSameNumSubArray(int[] nums, int left, int right) {
        int first = nums[left];
        int start = Math.max(left - 1, 0);
        int end = Math.min(right + 1, nums.length - 1);
        for (int i = start; i <= end; i++) {
            if (nums[i] != first) {
                return false;
            }
        }
        return true;
    }

    private int calc(int[] nums, int left, int right, int index) {
        int leftMost = left - 1 >= 0 ? nums[left - 1] : 1;
        int rightMost = right + 1 < nums.length ? nums[right + 1] : 1;
        return leftMost * nums[index] * rightMost;
    }
}


