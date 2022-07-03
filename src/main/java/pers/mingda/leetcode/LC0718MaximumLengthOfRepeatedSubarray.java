package pers.mingda.leetcode;

public class LC0718MaximumLengthOfRepeatedSubarray {
    public boolean search(int[] nums, int target) {
        int head = nums[0];
        int start = 0;;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int val = nums[mid];

            int nextIndex = mid + 1;
            int nextVal = nums[nums.length - 1];
            while (nextIndex < nums.length && nums[nextIndex] == val)
                nextIndex++;
            if (nextIndex < nums.length)
                nextVal = nums[nextIndex];

            if (val == target)
                return true;
            boolean midOnLeft = val > nextVal || nextVal > head;
            boolean targetOnLeft = target >= head;
            boolean midTargetSameSide = (midOnLeft && targetOnLeft) || (!midOnLeft && !targetOnLeft);
            if ((midTargetSameSide && val < target) || (!midTargetSameSide && midOnLeft))
                start = mid + 1;
            else
                end = mid;
        }

        return false;
    }
}
