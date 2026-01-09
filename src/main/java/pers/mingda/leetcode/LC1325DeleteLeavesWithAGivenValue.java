package pers.mingda.leetcode;

public class LC1325DeleteLeavesWithAGivenValue {}

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
class LC1325Solution {

  public TreeNode removeLeafNodes(TreeNode root, int target) {
    if (root == null || shouldRemove(root, target)) {
      return null;
    }
    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);
    return shouldRemove(root, target) ? null : root;
  }

  private boolean shouldRemove(TreeNode node, int target) {
    return isLeaf(node) && node.val == target;
  }

  private boolean isLeaf(TreeNode node) {
    return node != null && node.left == null && node.right == null;
  }
}
