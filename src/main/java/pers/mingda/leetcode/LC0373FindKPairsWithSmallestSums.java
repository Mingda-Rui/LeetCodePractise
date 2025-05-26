package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0373FindKPairsWithSmallestSums {}

class LC0373Solution {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    Comparator<List<Integer>> comparator =
        Comparator.comparingInt(point -> nums1[point.get(0)] + nums2[point.get(1)]);
    Queue<List<Integer>> queue = new PriorityQueue<>(comparator);

    for (int i = 0; i < nums1.length && i < k; i++) {
      List<Integer> point = Arrays.asList(i, 0);
      queue.offer(point);
    }

    List<List<Integer>> result = new LinkedList<>();
    while (result.size() < k && !queue.isEmpty()) {
      List<Integer> prevPointer = queue.poll();
      int num1Index = prevPointer.get(0);
      int num2Index = prevPointer.get(1);
      List<Integer> pair = Arrays.asList(nums1[num1Index], nums2[num2Index]);
      result.add(pair);
      if (num2Index + 1 < nums2.length) {
        List<Integer> point = Arrays.asList(num1Index, num2Index + 1);
        queue.offer(point);
      }
    }
    return result;
  }
}
