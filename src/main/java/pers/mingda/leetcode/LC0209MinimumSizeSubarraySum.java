package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0209MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int minimal = -1;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current > target)
                return 1;
            sum += current;
            int offset = sum - target;

            if (nums[0] < offset) {
                for (int j = offset; j >= nums[0]; j--) {
                    if (map.containsKey(j)) {
                        int distance = i - map.get(j);
                        minimal = minimal < 0 ? distance : Math.min(minimal, i - map.get(j));
                        break;
                    }
                }
            } else if (nums[0] == offset) {
                minimal = minimal < 0 ? i: Math.min(minimal, i);
            } else if (sum >= target) {
                minimal = minimal < 0 ? i + 1 : Math.min(minimal, i + 1);
            }

            map.put(sum, i);
        }
        return Math.max(minimal, 0);
    }
}
