package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LC0001TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.containsKey(target - nums[i]))
                return IntStream.of(record.get(target - nums[i]), i).toArray();
            record.put(nums[i], i);
        }
        return null;
    }
}
