package pers.mingda.leetcode;

public class LC0704BinarySearch {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length;
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            int val = nums[mid];
            if (val == target) return mid;
            else if (val < target) start = mid + 1;
            else if (val > target) end = mid;
        }
        return -1;
    }
}
