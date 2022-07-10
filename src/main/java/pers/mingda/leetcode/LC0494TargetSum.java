package pers.mingda.leetcode;

public class LC0494TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWaysRecur(nums, 0, target, 0, new int[1]);
    }

    private int findTargetSumWaysRecur(int[] nums, int index, int target, int sum, int[] resultHolder) {
        if (index == nums.length)
            return resultHolder[0];
        int val = nums[index];
        boolean isTail = index == nums.length - 1;
        if (isTail && sum - val == target)
            resultHolder[0]++;
        if (isTail && sum + val == target)
            resultHolder[0]++;
        findTargetSumWaysRecur(nums, index + 1, target, sum - val, resultHolder);
        findTargetSumWaysRecur(nums, index + 1, target, sum + val, resultHolder);
        return resultHolder[0];
    }
}
