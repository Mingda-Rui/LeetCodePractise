package pers.mingda.leetcode;

public class LC0238ProductOfArrayExceptSelf {

  public int[] productExceptSelf(int[] nums) {
    return productExceptSelfTraverse(nums);
  }

  private int[] productExceptSelfTraverse(int[] nums) {
    int[] result = new int[nums.length];

    int productOfPrevious = 1;
    for (int i = 0; i < nums.length; i++) {
      result[i] = productOfPrevious;
      productOfPrevious *= nums[i];
    }

    int productOfAfter = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      result[i] *= productOfAfter;
      productOfAfter *= nums[i];
    }

    return result;
  }
}
