package pers.mingda.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC0349IntersectionOfTwoArrays {
    public int[] intersectionSetSolution(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num: nums1)
            set1.add(num);
        for (int num: nums2)
            set2.add(num);
        for (int num: nums1)
            if (!set2.contains(num))
                set1.remove(num);
        return set1.stream().mapToInt(n -> n).toArray();
    }
}
