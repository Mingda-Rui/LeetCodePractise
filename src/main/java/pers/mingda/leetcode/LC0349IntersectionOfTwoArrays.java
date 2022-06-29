package pers.mingda.leetcode;

import java.util.Arrays;
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

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Set<Integer> set = new HashSet<>();
        Set<Integer> bin = new HashSet<>();
        for (int num: nums2) {
            if (set.contains(num) || bin.contains(num))
                continue;
            if (binarySearch(nums1, num))
                set.add(num);
            else
                bin.add(num);
        }
        return set.stream().mapToInt(n -> n).toArray();
    }

    private boolean binarySearch(int[] nums1, int target) {
        int start = 0;
        int end = nums1.length;
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            int current = nums1[mid];
            if (current == target)
                return true;
            else if (current < target)
                start = mid + 1;
            else
                end = mid;
        }
        return false;
    }
}
