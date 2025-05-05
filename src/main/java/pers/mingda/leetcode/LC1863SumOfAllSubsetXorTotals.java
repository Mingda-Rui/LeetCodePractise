package pers.mingda.leetcode;

public class LC1863SumOfAllSubsetXorTotals {
    public int subsetXORSum(int[] nums) {
        return sumXor(nums, 0, 0);
    }

    private int sumXor(int[] nums, int index, int xor) {
        if (index == nums.length) {
            return xor;
        }

        int currNum = nums[index];
        int withCurr = sumXor(nums, index + 1, xor ^ currNum);
        int withoutCurr = sumXor(nums, index + 1, xor);
        return withCurr + withoutCurr;
    }
}
