package pers.mingda.leetcode;

public class LC0718MaximumLengthOfRepeatedSubarray {
    public boolean search(int[] nums, int target) {
        int head = nums[0];
        int start = 0;;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int val = nums[mid];

            if (val == target)
                return true;

            boolean midOnLeft = val > head;
            boolean targetOnLeft = target >= head;
            boolean midTargetSameSide = (midOnLeft && targetOnLeft) || (!midOnLeft && !targetOnLeft);

            if (nums[start] == val)
                start++;
            else if ((midTargetSameSide && val < target) || (!midTargetSameSide && midOnLeft))
                start = mid + 1;
            else
                end = mid;
        }

        return false;
    }
}
