package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC0128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], i);
        }

        int[] record = new int[nums.length];
        int counter = 0;
        int maxCount = counter;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            while (map.containsKey(current) && record[map.get(current)] == 0) {
                // int curIndex = map.get(current);
                // counter += visited[curIndex] == 0 ? 1 : visited[curIndex];
                record[map.get(current)] = 1;
                counter++;
                current--;
            }
            if (map.containsKey(current)) counter += record[map.get(current)];
            record[i] = counter;
            maxCount = Math.max(maxCount, counter);
            counter = 0;
        }
        return maxCount;
    }

    public int longestConsecutiveSet(int[] nums) {
        int maxCount = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int counter = 0;
        for (int num : nums) {
            if (set.remove(num)) {
                counter++;
                counter += consecutives(set, num + 1, 1);
                counter += consecutives(set, num - 1, -1);
                maxCount = Math.max(maxCount, counter);
                counter = 0;
            }
        }

        return maxCount;
    }

    private int consecutives(Set<Integer> set, int start, int offset) {
        int counter = 0;
        while (set.remove(start)) {
            counter++;
            start += offset;
        }
        return counter;
    }
}
