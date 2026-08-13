package pers.mingda.leetcode;

public class LC4015WeightedSumOfATree {}

class LC4015DpSolution {
  public long weightedSum(int[] parent, int[] nums) {
    int[] depths = new int[parent.length];
    int height = 0;
    for (int i = 0; i < parent.length; i++) {
      depths[i] = getDepth(parent, depths, i);
      height = Math.max(height, depths[i]);
    }

    long result = 0;
    for (int i = 0; i < nums.length; i++) {
      result += (long) nums[i] * (height - depths[i] + 1);
    }
    return result;
  }

  private int getDepth(int[] parent, int[] depths, int index) {
    if (depths[index] != 0) {
      return depths[index];
    }

    if (index == 0) {
      return 1;
    }

    int depth = getDepth(parent, depths, parent[index]) + 1;
    depths[index] = depth;
    return depth;
  }
}
