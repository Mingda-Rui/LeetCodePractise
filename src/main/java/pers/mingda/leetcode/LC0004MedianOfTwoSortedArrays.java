package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0004MedianOfTwoSortedArrays {}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Queue<Integer> lowerQueue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> higherQueue = new PriorityQueue<>();
        enqueue(nums1, lowerQueue, higherQueue);
        enqueue(nums2, lowerQueue, higherQueue);
        if (lowerQueue.size() == higherQueue.size()) {
            return ((double) lowerQueue.poll() + (double) higherQueue.poll()) / 2;
        }
        return (double) lowerQueue.poll();
    }

    private void enqueue(int[] nums, Queue<Integer> lowerQueue, Queue<Integer> higherQueue) {
        for (int num : nums) {
            if (lowerQueue.size() == higherQueue.size()) {
                higherQueue.offer(num);
                int tmp = higherQueue.poll();
                lowerQueue.offer(tmp);
            } else {
                lowerQueue.offer(num);
                int tmp = lowerQueue.poll();
                higherQueue.offer(tmp);
            }
        }
    }
}