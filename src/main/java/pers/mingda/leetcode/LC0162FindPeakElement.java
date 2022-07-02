package pers.mingda.leetcode;

public class LC0162FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int val = nums[mid];
            boolean greaterThanLeft = mid == 0 || nums[mid - 1] < val;
            boolean greaterThanRight = mid == nums.length - 1 || nums[mid + 1] < val;
            if (greaterThanLeft && greaterThanRight)
                return mid;
            else if (!greaterThanRight)
                start = mid + 1;
            else
                end = mid;
        }

        return -1;
    }
}