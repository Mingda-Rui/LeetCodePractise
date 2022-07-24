package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0016ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 0;
        boolean initialized = false;
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int val = nums[i] + nums[start] + nums[end];
                if (!initialized || Math.abs(val - target) < Math.abs(closest - target)) {
                    initialized = true;
                    closest = val;
                }
                if (val < target)
                    start++;
                else if (val > target)
                    end--;
                else
                    start = end;
            }
        }

        return closest;
    }
}

