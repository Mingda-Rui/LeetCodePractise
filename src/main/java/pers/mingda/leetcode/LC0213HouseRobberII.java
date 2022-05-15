package pers.mingda.leetcode;

public class LC0213HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length < 2)
            return nums[0];
        int max1 = rob(nums, 0, nums.length - 1);
        int max2 = rob(nums, 1, nums.length);
        return Math.max(max1, max2);
    }

    private int rob(int[] nums, int start, int finish) {
        int beforePrev = nums[start];
        int prev = start + 1 < finish ? nums[start + 1] : 0;
        prev = Math.max(beforePrev, prev);
        for (int i = start + 2; i < finish; i++) {
            int val = nums[i] + beforePrev;
            beforePrev = prev;
            prev = Math.max(prev, val);
        }
        return prev;
    }
}
