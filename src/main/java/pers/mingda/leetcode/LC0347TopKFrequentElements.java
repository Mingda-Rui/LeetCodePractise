package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0347TopKFrequentElements {

  public int[] topKFrequent(int[] nums, int k) {
    int[] result = new int[k];
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      int val = map.getOrDefault(num, 0);
      map.put(num, val + 1);
    }
    Comparator<Map.Entry<Integer, Integer>> comparator =
        Comparator.comparingInt(Map.Entry::getValue);
    Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(comparator);
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      queue.offer(entry);
      if (queue.size() > k) queue.poll();
    }

    for (int i = 0; i < k; i++) result[i] = queue.poll().getKey();

    return result;
  }

  public int[] topKFrequentBucketSortWithPojo(int[] nums, int k) {
    List<Integer> result = new LinkedList<>();
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      min = Math.min(min, num);
      max = Math.max(max, num);
    }

    int[] offsetNumCounts = new int[max - min + 1];
    int mostCounts = 0;
    for (int num : nums) {
      int offsetNum = num - min;
      offsetNumCounts[offsetNum]++;
      mostCounts = Math.max(mostCounts, offsetNumCounts[offsetNum]);
    }

    List<List<Integer>> bucket = new ArrayList<>();
    for (int i = 0; i < mostCounts + 1; i++) bucket.add(null);

    for (int offsetNum = 0; offsetNum < offsetNumCounts.length; offsetNum++) {
      int count = offsetNumCounts[offsetNum];
      if (count != 0) {
        if (bucket.get(count) == null) bucket.set(count, new LinkedList<>());
        int num = offsetNum + min;
        bucket.get(count).add(num);
      }
    }

    for (int count = bucket.size() - 1; count >= 0 && result.size() < k; count--) {
      List<Integer> bigNums = bucket.get(count);
      if (bigNums != null) result.addAll(bigNums);
    }

    return result.stream().mapToInt(i -> i).toArray();
  }
}

class LC0347TopKFrequentElementsQuickSelectSolution {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
      int count = freq.getOrDefault(num, 0) + 1;
      freq.put(num, count);
    }

    int[] uniqueNums = freq.keySet().stream().mapToInt(Integer::intValue).toArray();
    return findTopFreq(uniqueNums, freq, 0, uniqueNums.length, k);
  }

  private int[] findTopFreq(int[] nums, Map<Integer, Integer> freq, int start, int end, int k) {
    int pivot = nums[end - 1];
    int boundary = start;
    for (int i = start; i < end - 1; i++) {
      if (freq.get(pivot) > freq.get(nums[i])) {
        swap(nums, boundary, i);
        boundary++;
      }
    }
    if (freq.get(pivot) <= freq.get(nums[boundary])) {
      swap(nums, boundary, end - 1);
    }
    if (nums.length - boundary == k) {
      return Arrays.copyOfRange(nums, boundary, nums.length);
    } else if (nums.length - boundary > k) {
      return findTopFreq(nums, freq, boundary + 1, end, k);
    } else {
      return findTopFreq(nums, freq, start, boundary, k);
    }
  }

  private void swap(int[] nums, int index1, int index2) {
    int tmp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = tmp;
  }
}