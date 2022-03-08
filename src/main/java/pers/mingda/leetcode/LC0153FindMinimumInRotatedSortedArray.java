package pers.mingda.leetcode;

public class LC0153FindMinimumInRotatedSortedArray {
    // Time complexity O(n)
    public int findMinBruteForce(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            if (nums[i] < nums[i - 1])
                return nums[i];
        return 0;
    }
}
