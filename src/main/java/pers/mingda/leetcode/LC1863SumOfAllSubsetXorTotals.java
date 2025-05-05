package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC1863SumOfAllSubsetXorTotals {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> allSubsets = generateSubsets(nums, 0, new ArrayList<>());
        int sum = 0;
        for (List<Integer> subset: allSubsets) {
            sum += xor(subset);
        }
        return sum;
    }

    private List<List<Integer>> generateSubsets(int[] nums, int index, List<Integer> currSet) {
        if (index == nums.length) {
            return List.of(new ArrayList<>(currSet));
        }
        int currNum = nums[index];
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> withoutCurr = generateSubsets(nums, index + 1, currSet);
        currSet.add(currNum);
        List<List<Integer>> withCurr = generateSubsets(nums, index + 1, currSet);
        currSet.removeLast();
        result.addAll(withoutCurr);
        result.addAll(withCurr);
        return result;
    }

    private int xor(List<Integer> subset) {
        int result = 0;
        for (int num: subset) {
            result ^= num;
        }
        return result;
    }
}
