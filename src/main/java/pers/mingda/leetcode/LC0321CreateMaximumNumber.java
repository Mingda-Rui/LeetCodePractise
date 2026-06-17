package pers.mingda.leetcode;

public class LC0321CreateMaximumNumber {

  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int[] result = new int[k];
    int resultInt = 0;
    int pointer1 = 0;
    int pointer2 = 0;

    while (pointer1 < nums1.length || pointer2 < nums2.length) {
      int max = Integer.MIN_VALUE;
      if (pointer1 >= nums1.length) {
        max = nums2[pointer2];
        pointer2++;
      } else if (pointer2 >= nums2.length) {
        max = nums1[pointer1];
        pointer1++;
      } else if (nums1[pointer1] > nums2[pointer2]) {
        max = nums1[pointer1];
        pointer1++;
      } else {
        max = nums2[pointer2];
        pointer2++;
      }
    }
    return result;
  }
}
