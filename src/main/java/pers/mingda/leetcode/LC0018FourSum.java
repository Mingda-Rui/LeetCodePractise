package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LC0018FourSum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, 0, target, 4);
  }

  private List<List<Integer>> kSum(int[] nums, int start, long target, int k) {
    if (k == 2) return twoSum(nums, start, target);

    List<List<Integer>> result = new LinkedList<>();
    for (int i = start; i < nums.length; i++) {
      int val = nums[i];
      if (i != start && nums[i] == nums[i - 1]) continue;
      List<List<Integer>> sums = kSum(nums, i + 1, target - val, k - 1);
      for (List<Integer> sum : sums) {
        sum.add(val);
        result.add(sum);
      }
    }

    return result;
  }

  private List<List<Integer>> twoSum(int[] nums, int start, long target) {
    List<List<Integer>> result = new LinkedList<>();
    int end = nums.length - 1;
    Set<Integer> set = new HashSet<>();
    while (start < end) {
      long val = (long) nums[start] + (long) nums[end];
      if (val == target && !set.contains(nums[start])) {
        List<Integer> list = new LinkedList<>();
        list.addAll(Arrays.asList(nums[end], nums[start]));
        result.add(list);
        set.addAll(list);
      }
      if (val <= target) start++;
      else end--;
    }
    return result;
  }
}
