package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import org.apache.commons.math3.util.Pair;

public class LC2542MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        Queue<Pair<Integer, Integer>> minNums2 = new PriorityQueue<>(Comparator.<Pair<Integer, Integer>>comparingInt(Pair::getSecond).reversed());
        for (int i = 0; i < nums1.length; i++) {
            minNums2.add(new Pair<>(nums1[i], nums2[i]));
        }
        Queue<Integer> maxNum1 = new PriorityQueue<>(k, Comparator.reverseOrder());
        long currentSum = 0;
        long max = 0;
        for (int i = 0; i < nums2.length; i++) {
            Pair<Integer, Integer> next = minNums2.remove();
            int num1 = next.getFirst();
            int num2 = next.getSecond();
            if (maxNum1.size() == k) {
                currentSum -= maxNum1.remove();
            }
            currentSum += num1;
            maxNum1.add(num1);
            if (maxNum1.size() == k) {
                max = Math.max(max, currentSum * num2);
            }
        }

        return max;
    }
}
