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

    public int search2(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int mid = (start + end) / 2;
            System.out.println("nums[" + start + "] = " + nums[start] + " nums[" + (end - 1) + "] = " + nums[end - 1]);

            int current = nums[mid];
            System.out.println("nums[" + mid + "] = " + current);
            if (current == target)
                return mid;
            else if (nums[start] == target)
                return start;
            else if (nums[end - 1] == target)
                return end - 1;
            if (current < nums[start]) {
                if (target < nums[start] && current < target)
                    start = mid;
                else if (target > nums[end - 1] || target < nums[start] && current > target)
                    end = mid;
            } else if (current > nums[end - 1]) {
                if (target < nums[start] || target > nums[end - 1] && current < target)
                    start = mid;
                else if (target > nums[end - 1] && current > target)
                    end = mid;
            } else if (target > nums[start] && target < nums[end - 1]) {
                if (target > current)
                    start = mid;
                else if (target < current)
                    end = mid;
            } else
                return -1;
        }

        return -1;
    }

    // 行百里者半九十
}

//[4,5,6,7,8,1,2,3]
// 0,1,2,3,4,5,6,7,8 5
// i = 4 -> 8, 0 - 4
// i = 2 -> 6, 0 - 2
// i = 1 -> 5