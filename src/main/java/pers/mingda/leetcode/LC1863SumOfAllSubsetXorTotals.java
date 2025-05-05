package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC1863SumOfAllSubsetXorTotals {
    public int subsetXORSum(int[] nums) {
        int sum = 0;
        for (int len = 1; len <= nums.length; len++) {
            for (int head = 0; head + len <= nums.length; head++) {
                sum += subsetXorSum(nums, head, len).stream().mapToInt(Integer::intValue).sum();
            }
        }
        return sum;
    }

    private List<Integer> subsetXorSum(int[] nums, int index, int len) {
        if (index == nums.length || len == 0) {
            return List.of();
        }
        if (len == 1) {
            return List.of(nums[index]);
        }
        int current = nums[index];
        List<Integer> result = new ArrayList<>();
        for (int i = index + 1; i + len - 1 <= nums.length; i++) {
            subsetXorSum(nums, i, len - 1).stream().map(num -> num ^ current).forEach(result::add);
        }

        return result;
    }
}
