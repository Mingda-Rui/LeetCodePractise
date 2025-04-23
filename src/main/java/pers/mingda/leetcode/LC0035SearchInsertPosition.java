package pers.mingda.leetcode;

public class LC0035SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            int current = nums[mid];

            if (current == target) return mid;
            else if (current > target) end = mid;
            else if (current < target) start = mid + 1;
        }

        return start;
    }
}
