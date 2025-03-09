package pers.mingda.leetcode;

import java.util.Arrays;

public class L0416PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int totalSum = sum(nums);
        if (totalSum % 2 != 0) {
            return false;
        }
        int half = totalSum / 2;
        int[][] memo = new int[nums.length][half + 1];
        return dfs(nums, 0, half, memo);
    }

    private int sum(int[] nums) {
        return Arrays.stream(nums).sum();
    }

    private boolean dfs(int[] nums, int index, int remain, int[][] memo) {
        if (remain == 0) {
            return true;
        }
        if (index == nums.length || remain < 0) {
            return false;
        }
        if (memo[index][remain] == 1) {
            return true;
        }
        if (memo[index][remain] == 2) {
            return false;
        }

        int current = nums[index];
        boolean result = dfs(nums, index + 1, remain, memo) || dfs(nums, index + 1, remain - current, memo);
        memo[index][remain] = result ? 1 : 2;
        return result;
    }

    public boolean canPartitionTabulation(int[] nums) {
        int totalSum = sum(nums);
        if (totalSum % 2 != 0) {
            return false;
        }
        int half = totalSum / 2;
        return calcMemo(nums, half);
    }

    private boolean calcMemo(int[] nums, int target) {
        int col = target + 1;
        boolean[][] memo = new boolean[nums.length + 1][col];
        memo[0][0] = true;
        for (int i = 1; i < memo.length; i++) {
            int curr = nums[i - 1];
            for (int sum = 0; sum < col; sum++) {
                int prevCol = i - 1;
                int prevSum = sum - curr;
                memo[i][sum] = memo[prevCol][sum] || (prevSum >= 0 && memo[prevCol][prevSum]);
                if (sum == target && memo[i][sum]) {
                    return true;
                }
            }
        }
        return false;
    }
}
