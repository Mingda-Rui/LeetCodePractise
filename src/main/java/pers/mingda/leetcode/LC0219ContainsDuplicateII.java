package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0219ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - j > k) {
                int count = map.getOrDefault(nums[j], 0);
                map.put(nums[j], count - 1);
                j++;
            }
            int num = nums[i];
            if (map.getOrDefault(num, 0) != 0) {
                return true;
            }
            map.put(num, 1);
        }
        return false;

    }
}
