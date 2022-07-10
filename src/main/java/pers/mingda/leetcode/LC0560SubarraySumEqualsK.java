package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int counter = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, 1);
        for (int num: nums) {
            sum += num;
            counter += map.getOrDefault(sum - k, 0);
            int val = map.getOrDefault(sum, 0);
            map.put(sum, val + 1);

        }
        return counter;
    }
}
