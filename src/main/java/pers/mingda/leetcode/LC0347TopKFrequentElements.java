package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0347TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            int val = map.getOrDefault(num, 0);
            map.put(num, val + 1);
        }
        Comparator<Map.Entry<Integer, Integer>> comparator = (o1, o2) -> o2.getValue() - o1.getValue();
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(comparator);
        for (Map.Entry<Integer, Integer> entry: map.entrySet())
            queue.offer(entry);
        for (int i = 0; i < k; i++)
            result[i] = queue.poll().getKey();

        return result;
    }
}