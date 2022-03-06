package pers.mingda.leetcode;

public class AJE0238ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = result.length - 1; i >= 0; i--) {
            int previous = i == result.length - 1 ? 1: result[i + 1];
            result[i] = previous * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int previous = i == 0 ? 1 : nums[i - 1];
            nums[i] = previous * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int previous = i == 0 ? 1 : nums[i - 1];
            int after = i == nums.length - 1 ? 1 : result[i + 1];
            result[i] = previous * after;
        }

        return result;
    }
}
