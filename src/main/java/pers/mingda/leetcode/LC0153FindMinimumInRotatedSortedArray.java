package pers.mingda.leetcode;

public class LC0153FindMinimumInRotatedSortedArray {

  // Time complexity O(n)
  public int findMinBruteForce(int[] nums) {
    for (int i = 1; i < nums.length; i++) if (
      nums[i] < nums[i - 1]
    ) return nums[i];
    return 0;
  }

  public int findMinBinarySearchRecursive(int[] nums) {
    int index = findMinBinarySearchRecursive(nums, 0, nums.length);
    int nextRotatedIndex = (index + 1) % nums.length;
    return nums[nextRotatedIndex];
  }

  private int findMinBinarySearchRecursive(int[] nums, int start, int end) {
    if (start == end) return start;

    int index = (start + end) / 2;
    boolean greaterThanStart = nums[index] > nums[start];
    int nextStart = greaterThanStart ? index : start;
    int nextEnd = greaterThanStart ? end : index;

    return findMinBinarySearchRecursive(nums, nextStart, nextEnd);
  }

  public int findMin(int[] nums) {
    int start = 0;
    int end = nums.length;
    while (start < end) {
      int mid = (start + end) / 2;
      boolean greaterThanStart = nums[mid] > nums[start];
      start = greaterThanStart ? mid : start;
      end = greaterThanStart ? end : mid;
    }

    int nextRotatedIndex = (start + 1) % nums.length;
    return nums[nextRotatedIndex];
  }
}
