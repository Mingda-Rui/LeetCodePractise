package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC0228SummaryRanges {
}

class LC0228Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        final String arrow = "->";
        for (int i = 0; i < nums.length; i++) {
            int head = i;
            while(i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            String range = head == i ? String.valueOf(nums[head]) : nums[head] + arrow + nums[i];
            result.add(range);
        }
        return result;
    }
}