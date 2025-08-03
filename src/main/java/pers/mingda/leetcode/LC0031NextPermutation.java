package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0031NextPermutation {}

class LC0031Solution {

  public void nextPermutation(int[] nums) {
    Map<Integer, Integer> positions = new HashMap<>();
    Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = nums.length - 1; i >= 0; i--) {
      if (!queue.isEmpty() && nums[i] < queue.peek()) {
        int swapIndex = -1;
        while (!queue.isEmpty() && nums[i] < queue.peek()) {
          int max = queue.remove();
          swapIndex = positions.get(max);
        }
        swap(nums, i, swapIndex);
        Arrays.sort(nums, i + 1, nums.length);
        return;
      } else if (!positions.containsKey(nums[i])) {
        positions.put(nums[i], i);
        queue.add(nums[i]);
      }
    }
    Arrays.sort(nums);
  }

  private void swap(int[] nums, int index1, int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }
}

class LC0031BinarySearchSolution {

  public void nextPermutation(int[] nums) {
    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] >= nums[i + 1]) {
        continue;
      }

      // Returns the index of the element immediately greater than num
      int swapIndex = binarySearch(nums, i + 1, nums.length, nums[i]);
      swap(nums, i, swapIndex);
      reverse(nums, i + 1);
      return;
    }

    Arrays.sort(nums);
  }

  private int binarySearch(int[] nums, int start, int end, int target) {
    if (start == end - 1) {
      return target >= nums[start] ? start - 1 : start;
    }
    int mid = (start + end) / 2;
    if (target >= nums[mid]) {
      end = mid;
    } else {
      start = mid;
    }
    return binarySearch(nums, start, end, target);
  }

  private void swap(int[] nums, int index1, int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }

  private void reverse(int[] nums, int start) {
    int end = nums.length - 1;
    while (start < end) {
      swap(nums, start, end);
      start++;
      end--;
    }
  }
}
