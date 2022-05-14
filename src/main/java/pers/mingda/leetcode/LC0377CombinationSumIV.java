package pers.mingda.leetcode;

public class LC0377CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] record = new int[target + 1];
        record[0] = 1;
        for (int i = 1; i < target + 1; i++)
            for (int num: nums)
                if (i - num >= 0)
                    record[i] += record[i - num];
        return record[target];
    }
}
