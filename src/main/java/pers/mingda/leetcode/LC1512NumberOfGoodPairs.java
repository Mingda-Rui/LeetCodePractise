package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1512NumberOfGoodPairs {

}

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        for (int num: nums) {
            int count = map.getOrDefault(num, 0);
            counter += count;
            map.put(num, count + 1);
        }
        return counter;
    }
}