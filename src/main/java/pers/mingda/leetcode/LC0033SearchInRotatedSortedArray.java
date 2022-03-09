package pers.mingda.leetcode;

public class LC0033SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;

        int greatest = findStartIndex(nums, 0, nums.length);
        int smallest = (greatest + 1) % nums.length;
        if (target < nums[smallest] || target > nums[greatest])
            return -1;

        if (target >= nums[0])
            return binarySearch(nums, 0, greatest + 1, target);
        else
            return binarySearch(nums, smallest, nums.length, target);

    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start == end - 1)
            return target == nums[start] ? start : -1;
        int mid = (start + end) / 2;
        int current = nums[mid];

        if (current > target)
            return binarySearch(nums, start, mid, target);
        else if (current < target)
            return binarySearch(nums, mid, end, target);
        else
            return mid;
    }

    private int findStartIndex(int[] nums, int start, int end) {
        if (start == end)
            return start;
        int mid = (start + end) / 2;
        boolean greaterThanStart = nums[mid] > nums[start];
        start = greaterThanStart ? mid : start;
        end = greaterThanStart ? end : mid;
        return findStartIndex(nums, start, end);
    }
}
