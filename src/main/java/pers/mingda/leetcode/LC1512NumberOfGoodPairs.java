package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1512NumberOfGoodPairs {}

class LC1512Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            counter += count;
            map.put(num, count + 1);
        }
        return counter;
    }
}

class LC1512ArraySolution {
    public int numIdenticalPairs(int[] nums) {
        int[] map = new int[101];
        int counter = 0;
        for (int num : nums) {
            counter += map[num];
            map[num]++;
        }
        return counter;
    }
}