package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1679MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = countMap.getOrDefault(k - num, 0);
            if (count > 0) {
                result++;
                countMap.put(k - num, count - 1);
            } else {
                int numCount = countMap.getOrDefault(num, 0);
                countMap.put(num, numCount + 1);
            }
        }
        return result;
    }
}
