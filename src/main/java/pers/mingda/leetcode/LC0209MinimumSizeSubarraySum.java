package pers.mingda.leetcode;

public class LC0209MinimumSizeSubarraySum {
  public int minSubArrayLenBinarySearch(int target, int[] nums) {
    int[] sumRecord = new int[nums.length];
    int sum = 0;
    int minimal = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length; i++) {
      int current = nums[i];
      sum += current;
      sumRecord[i] = sum;
      if (sum >= target) {
        int offset = sum - target;
        int index = binarySearch(offset, sumRecord, i);
        minimal = Math.min(minimal, i - index);
      }
    }
    return minimal == Integer.MAX_VALUE ? 0 : minimal;
  }

  private int binarySearch(int val, int[] nums, int boundary) {
    if (val == 0) return -1;
    int start = 0;
    int end = boundary;
    while (start < end) {
      int mid = start + (end - start) / 2;
      int midVal = nums[mid];
      if (midVal == val) return mid;
      else if (midVal < val) start = mid + 1;
      else end = mid;
    }

    return start - 1;
  }

  public int minSubArrayLenTwoPointers(int target, int[] nums) {
    int fast = 0;
    int slow = 0;
    int minimal = Integer.MAX_VALUE;
    int currentVal = 0;
    while (fast < nums.length || slow < nums.length) {
      if (currentVal < target && fast < nums.length) {
        currentVal += nums[fast];
        fast++;
      } else {
        if (currentVal >= target) minimal = Math.min(minimal, fast - slow);
        currentVal -= nums[slow];
        slow++;
      }
    }
    return minimal == Integer.MAX_VALUE ? 0 : minimal;
  }
}
