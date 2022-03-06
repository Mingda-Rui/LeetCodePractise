package pers.mingda.leetcode;

public class AJE0238ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        return productExceptSelfTraverse(nums);
    }

    private int[] productExceptSelfTraverse(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = result.length - 1; i >= 0; i--) {
            int previous = i == result.length - 1 ? 1: result[i + 1];
            result[i] = previous * nums[i];
        }

        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            int after = i == nums.length - 1 ? 1 : result[i + 1];
            result[i] = after * product;
            product = nums[i] * product;
        }

        return result;
    }
}
