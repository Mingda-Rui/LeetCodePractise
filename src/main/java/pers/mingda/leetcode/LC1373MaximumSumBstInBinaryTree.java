package pers.mingda.leetcode;

public class LC1373MaximumSumBstInBinaryTree {}

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class LC1373Solution {

  int max = 0;

  public int maxSumBST(TreeNode root) {
    maxSumBSTHelper(root);
    return max;
  }

  public Result maxSumBSTHelper(TreeNode root) {
    if (root == null) return new Result(
      Integer.MAX_VALUE,
      Integer.MIN_VALUE,
      0
    );

    Result lResult = maxSumBSTHelper(root.left);
    Result rResult = maxSumBSTHelper(root.right);

    if (lResult == null || lResult.large >= root.val) return null;
    if (rResult == null || rResult.small <= root.val) return null;

    int small = Math.min(root.val, lResult.small);
    int larget = Math.max(root.val, rResult.large);
    int sum = lResult.sum + rResult.sum + root.val;
    max = Math.max(max, sum);
    return new Result(small, larget, sum);
  }
}

class Result {

  int small;
  int large;
  int sum;

  public Result(int small, int large, int sum) {
    this.small = small;
    this.large = large;
    this.sum = sum;
  }
}
