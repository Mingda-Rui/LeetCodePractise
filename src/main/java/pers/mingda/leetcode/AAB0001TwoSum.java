package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AAB0001TwoSum {

    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException("No solution found!");
    }

    public int[] twoSumSorting(int[] nums, int target) {
        int[] coyied = Arrays.copyOf(nums, nums.length);
        int[] twoNums = getNums(coyied, target);
        int first = -1;
        int second = -1;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == twoNums[0] || nums[i] == twoNums[1]) {
                first = first == -1 ? i : first;
                second = first == -1 ? second : i;
            }

        return new int[]{first, second};
    }

    private int[] getNums(int[] nums, int target) {
        Arrays.sort(nums);
        int first = 0;
        int second = nums.length - 1;
        while (first < second) {
            int sum = nums[first] + nums[second];
            if (sum == target)
                return new int[]{nums[first], nums[second]};
            first = sum < target ? first + 1 : first;
            second = sum > target ? second - 1 : second;
        }
        throw new RuntimeException("No solution found!");
    }

    public int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int expect = target - current;
            if (record.containsKey(expect))
                return new int[]{record.get(expect), i};
            record.put(current, i);
        }
        throw new RuntimeException("No solution found!");
    }
}
