package pers.mingda.leetcode;

public class LC0153FindMinimumInRotatedSortedArray {
    // Time complexity O(n)
    public int findMinBruteForce(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            if (nums[i] < nums[i - 1])
                return nums[i];
        return 0;
    }

    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1])
            return nums[0];
        return findMin(nums, 0, nums.length);
    }

    private int findMin(int[] nums, int start, int end) {
        int index = (start + end) / 2;
        if (nums[index] < nums[index - 1])
            return nums[index];

        boolean greaterThanStart = nums[index] > nums[0];
        int nextStart = greaterThanStart ? index + 1 : start;
        int nextEnd = greaterThanStart ? end : index;

        return findMin(nums, nextStart, nextEnd);
    }
}
