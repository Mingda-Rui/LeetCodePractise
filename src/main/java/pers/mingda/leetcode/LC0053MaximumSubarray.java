package pers.mingda.leetcode;

public class LC0053MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int min = 0;
        int currentMax = nums[0];
        int sum = 0;
        for (int num: nums) {
            sum += num;
            currentMax = Math.max(currentMax, sum - min);
            min = Math.min(min, sum);
        }
        return currentMax;
    }
}
