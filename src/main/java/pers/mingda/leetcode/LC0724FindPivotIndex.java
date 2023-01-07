package pers.mingda.leetcode;

public class LC0724FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] leftSums = new int[nums.length];
        int[] rightSums = new int[nums.length];

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            leftSums[i] = leftSum;
        }

        int rightSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightSum += nums[i];
            rightSums[i] = rightSum;
        }

        for (int i = 0; i < nums.length; i++) {
            int lSum = i == 0 ? 0 : leftSums[i - 1];
            int rSum = i == nums.length - 1 ? 0 : rightSums[i + 1];
            if (lSum == rSum)
                return i;
        }
        return -1;
    }
}
