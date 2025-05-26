package pers.mingda.leetcode;

import java.util.Stack;

public class LC0114FlattenBinaryTreeToLinkedList {
  public TreeNode flattenRecursive(TreeNode root) {
    if (root == null || root.left == null && root.right == null) return root;

    TreeNode leftTail = flattenRecursive(root.left);
    TreeNode rightTail = flattenRecursive(root.right);

    if (leftTail != null) leftTail.right = root.right;
    root.right = root.left != null ? root.left : root.right;
    root.left = null;
    return rightTail == null ? leftTail : rightTail;
  }

  public void flattenIterative(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    if (root != null) stack.push(root);
    while (!stack.isEmpty()) {
      root = stack.pop();
      if (root.right != null) stack.push(root.right);
      if (root.left != null) stack.push(root.left);
      root.right = stack.isEmpty() ? null : stack.peek();
      root.left = null;
    }
  }
}
