package pers.mingda.leetcode;

public class LC1863SumOfAllSubsetXorTotals {

  public int subsetXORSum(int[] nums) {
    return sumXor(nums, 0, 0);
  }

  private int sumXor(int[] nums, int index, int xor) {
    if (index == nums.length) {
      return xor;
    }

    int currNum = nums[index];
    int withCurr = sumXor(nums, index + 1, xor ^ currNum);
    int withoutCurr = sumXor(nums, index + 1, xor);
    return withCurr + withoutCurr;
  }

  public int subsetXORSumBitManipulation(int[] nums) {
    int result = 0;
    // Capture each bit that is set in any of the elements
    for (int num : nums) {
      result |= num;
    }
    // Multiply by the number of subset XOR totals that will have each bit set
    return result << (nums.length - 1);
  }
}
