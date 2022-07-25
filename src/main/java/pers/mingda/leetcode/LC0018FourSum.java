package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC0018FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        for (int outerL = 0; outerL < sorted.length; outerL++) {
            if (outerL != 0 && sorted[outerL] == sorted[outerL - 1])
                continue;
            for (int outerR = sorted.length - 1; outerR > outerL; outerR--) {
                if (outerR != sorted.length - 1 && sorted[outerR] == sorted[outerR + 1])
                    continue;
                int innerL = outerL + 1;
                int innerR = outerR - 1;
                while (innerL < innerR) {
                    long val = sorted[outerL];
                    val += sorted[innerL];
                    val += sorted[innerR];
                    val += sorted[outerR];
                    if (val == target) {
                        List<Integer> list = Arrays.asList(sorted[outerL], sorted[innerL], sorted[innerR], sorted[outerR]);
                        result.add(list);
                    }

                    if (val <= target) {
                        innerL++;
                        while (innerL < innerR && sorted[innerL] == sorted[innerL - 1])
                            innerL++;
                    } else {
                        innerR--;
                        while (innerR > innerL && sorted[innerR] == sorted[innerR + 1])
                            innerR--;
                    }
                }
            }
        }
        return result;
    }
}
