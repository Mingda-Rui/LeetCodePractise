package pers.mingda.leetcode;

public class LC0718MaximumLengthOfRepeatedSubarray {
  public int findLength(int[] nums1, int[] nums2) {
    int maxLen = 0;
    for (int i = 0; i < nums1.length; i++) {
      int maxInDiagonal = diagnalTraverse(nums1, nums2, i, 0);
      maxLen = Math.max(maxLen, maxInDiagonal);
    }

    for (int j = 1; j < nums2.length; j++) {
      int maxInDiagonal = diagnalTraverse(nums1, nums2, 0, j);
      maxLen = Math.max(maxLen, maxInDiagonal);
    }

    return maxLen;
  }

  private int diagnalTraverse(int[] nums1, int[] nums2, int x, int y) {
    int maxLen = 0;
    int currentLen = 0;
    while (x < nums1.length && y < nums2.length) {
      if (nums1[x] == nums2[y]) {
        currentLen++;
      } else {
        maxLen = Math.max(maxLen, currentLen);
        currentLen = 0;
      }
      x++;
      y++;
    }
    maxLen = Math.max(maxLen, currentLen);
    return maxLen;
  }
}
