package pers.mingda.leetcode;

import java.util.Stack;

public class LC0230KthSmallestElementInABst {
  public int kthSmallest(TreeNode root, int k) {
    int[] resultHolder = new int[] {-1};
    kthSmallestRecursive(root, k, resultHolder);
    return resultHolder[0];
  }

  private int kthSmallestRecursive(TreeNode root, int k, int[] resultHolder) {
    if (root == null || k == 0) return k;
    k = kthSmallestRecursive(root.left, k, resultHolder);
    if (k == 1) resultHolder[0] = root.val;
    return kthSmallestRecursive(root.right, k - 1, resultHolder);
  }

  public int KthSmallestIterative(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        k--;
        if (k == 0) return root.val;
        root = root.right;
      }
    }
    return -1;
  }
}
