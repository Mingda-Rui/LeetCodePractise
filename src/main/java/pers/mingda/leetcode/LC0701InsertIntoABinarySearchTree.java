package pers.mingda.leetcode;

public class LC0701InsertIntoABinarySearchTree {}

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
class LC0701Solution {

  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    if (root.val < val) {
      root.right = insertIntoBST(root.right, val);
    } else {
      root.left = insertIntoBST(root.left, val);
    }
    return root;
  }
}

class LC0701IterativeSolution {

  public TreeNode insertIntoBST(TreeNode root, int val) {
    TreeNode node = root;

    // TODO: revisit the exist logic
    while (node != null) {
      if (node.val > val) {
        if (node.left == null) {
          node.left = new TreeNode(val);
          return root;
        }
        node = node.left;
      } else {
        if (node.right == null) {
          node.right = new TreeNode(val);
          return root;
        }
        node = node.right;
      }
    }
    return new TreeNode(val);
  }
}
