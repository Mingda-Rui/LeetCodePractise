package pers.mingda.leetcode;

import java.util.HashSet;
import java.util.Set;

public class AIJ0217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> duplication = new HashSet<>();
        for (int num: nums) {
            if (!duplication.add(num))
                return true;
        }
        return false;
    }
}
