package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0169MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            if (count > majority) return num;
            map.put(num, count);
        }
        return 0;
    }
}
