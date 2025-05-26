package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC0226InvertBinaryTree {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
  }

  public TreeNode invertTreeIterative(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node != null) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        queue.offer(node.left);
        queue.offer(node.right);
      }
    }
    return root;
  }
}
