package pers.mingda.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC0136SingleNumber {

}

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num))
                set.remove(num);
            else
                set.add(num);
        }
        return set.stream().findAny().get();
    }
}
