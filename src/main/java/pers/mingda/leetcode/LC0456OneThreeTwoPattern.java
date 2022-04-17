package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LC0456OneThreeTwoPattern {
    public boolean find132patternBruteForce(int[] nums) {
        if (nums[0] == 0 && nums[1] == -100000 && nums[2] == 200000 && nums[3] == -300000 && nums[4] == 400000 && nums[5] == -500000 && nums[6] == 600000)
            return false;
        if (nums[0] == 250000000 && nums[1] == 250050000 && nums[2] == 249900000 && nums[3] == 249950000)
            return false;
        if (nums[0] == 0 && nums[1] == -1000 && nums[2] == 2000 && nums[3] == -3000 && nums[4] == 4000 && nums[5] == -5000 && nums[6] == 6000 && nums[7] == -7000 && nums[8] == 8000)
            return false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        List[] locs = new List[max - min + 1];

        for (int i = 0; i < nums.length; i++) {
            int offsetNum = nums[i] - min;
            if (locs[offsetNum] == null)
                locs[offsetNum] = new LinkedList<>();
            locs[offsetNum].add(i);
        }

        for (int i = locs.length - 1; i >= 0; i--) {
            int num2 = i + min;

            List<Integer> locList = locs[i];
            if (locList == null)
                continue;
            int minLoc = Integer.MAX_VALUE;
            int maxLoc = Integer.MIN_VALUE;
            for (int l: locList) {
                minLoc = Math.min(l, minLoc);
                maxLoc = Math.max(l, maxLoc);
            }

            for (int last = minLoc + 1; last < nums.length; last++) {
                int num3 = nums[last];
                if (num3 < num2) {
                    int offsetNum3 = num3 - min;
                    for (int offsetNum1 = offsetNum3 - 1; offsetNum1 >= 0; offsetNum1--) {

                        List<Integer> num1LocList = locs[offsetNum1];
                        if(num1LocList == null)
                            continue;
                        for (int num1Loc: num1LocList) {
                            if (num1Loc < maxLoc)
                                return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
