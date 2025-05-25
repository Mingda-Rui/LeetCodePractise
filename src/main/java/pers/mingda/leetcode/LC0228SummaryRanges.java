package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC0228SummaryRanges {
}

class LC0228Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int len = nums.length;
        int head = 0;
        final String arrow = "->";
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                String rangeBody = head == i - 1 ? "" :  arrow + nums[i - 1];
                result.add(nums[head] + rangeBody);
                head = i;
            }
        }
        String rangeBody = (len < 2 || head == len - 1) ? "" :  arrow + nums[len - 1];
        result.add(nums[head] + rangeBody);

        return result;
    }
}