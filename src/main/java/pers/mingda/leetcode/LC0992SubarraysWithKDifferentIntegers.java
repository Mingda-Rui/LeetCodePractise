package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0992SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int fast = 0;
        int slow = -1;
        int count = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (slow < fast) {
            if (count <= k) {
                fast++;
                int val = nums[fast];
                count += map.containsKey(val) ? 0 : 1;
                int countOfVal = map.getOrDefault(val, 0);
                map.put(val, countOfVal + 1);
            } else {
                slow++;
                int val = nums[slow];
                count -= map.get(val) == 1 ? 1 : 0;
                int countOfVal = map.get(val);
                map.put(val, countOfVal - 1);
            }
            if (count == k)
                result++;
        }
        return result;
    }
}
