package pers.mingda.leetcode;

public class LC0270ClosestBinarySearchTreeValue {}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class LC0270Solution {

  public int closestValue(TreeNode root, double target) {
    int cloestValue = root.val;
    while (root != null) {
      int val = root.val;
      double valDiff = Math.abs(val - target);
      double cloestDiff = Math.abs(cloestValue - target);
      if (valDiff < cloestDiff) {
        cloestValue = val;
      } else if (valDiff == cloestDiff) {
        cloestValue = Math.min(cloestValue, val);
      }

      if (val > target) {
        root = root.left;
      } else if (val < target) {
        root = root.right;
      } else {
        return val;
      }
    }
    return cloestValue;
  }
}
