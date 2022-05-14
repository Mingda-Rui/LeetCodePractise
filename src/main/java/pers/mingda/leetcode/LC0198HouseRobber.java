package pers.mingda.leetcode;

public class LC0198HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        sum[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int maxPrev = Math.max(sum[i - 2], i < 3 ? 0 : sum[i - 3]);
            sum[i] = nums[i] + maxPrev;
        }
        return Math.max(sum[nums.length - 1], sum[nums.length - 2]);
    }
}
