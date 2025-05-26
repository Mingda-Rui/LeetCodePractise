package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class LC0124BinaryTreeMaximumPathSum {
  public int maxPathSum(TreeNode root) {
    int[] maxHolder = new int[] {Integer.MIN_VALUE};
    maxPathSumRecursive(root, maxHolder);
    return maxHolder[0];
  }

  private int maxPathSumRecursive(TreeNode root, int[] maxHolder) {
    if (root == null) return 0;
    int left = maxPathSumRecursive(root.left, maxHolder);
    left = Math.max(left, 0);
    int right = maxPathSumRecursive(root.right, maxHolder);
    right = Math.max(right, 0);
    int sum = left + root.val + right;
    maxHolder[0] = Math.max(maxHolder[0], sum);
    return Math.max(left, right) + root.val;
  }

  public int maxPathSumIterative(TreeNode root) {
    int max = Integer.MIN_VALUE;
    Map<TreeNode, Integer> map = new HashMap<>();
    Stack<TreeNode> stack = new Stack<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node != null) {
        stack.push(node);
        queue.offer(node.left);
        queue.offer(node.right);
      }
    }

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      int left = node.left == null ? 0 : map.get(node.left);
      int right = node.right == null ? 0 : map.get(node.right);
      int currentSum = Math.max(left, right) + node.val;
      map.put(node, Math.max(currentSum, 0));
      max = Math.max(max, left + right + node.val);
    }

    return max;
  }
}
