package pers.mingda.leetcode;

import java.util.Stack;

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
    if (root == null) {
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

class LC1325IterativeSolution {

  public TreeNode removeLeafNodes(TreeNode root, int target) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    TreeNode prev = null;

    while (node != null || !stack.empty()) {
      if (node != null) {
        stack.push(node);
        node = node.left;
      } else {
        node = stack.peek();
        if (node.right == null || node.right == prev) {
          stack.pop();

          if (isLeaf(node) && node.val == target) {
            if (stack.empty()) {
              return null;
            }
            TreeNode parent = stack.peek();
            if (parent.left == node) {
              parent.left = null;
            } else {
              parent.right = null;
            }
          }

          prev = node;
          node = null;
        } else {
          node = node.right;
        }
      }
    }

    return root;
  }

  private boolean isLeaf(TreeNode node) {
    return node != null && node.left == null && node.right == null;
  }
}
