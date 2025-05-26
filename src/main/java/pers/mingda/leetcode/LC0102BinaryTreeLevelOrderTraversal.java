package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0102BinaryTreeLevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      List<Integer> list = new LinkedList<>();
      int currentSize = queue.size();
      while (currentSize > 0) {
        TreeNode node = queue.poll();
        if (node != null) {
          list.add(node.val);
          queue.add(node.left);
          queue.add(node.right);
        }
        currentSize--;
      }
      if (!list.isEmpty()) result.add(list);
    }
    return result;
  }

  public List<List<Integer>> levelOrderRecursive(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();
    levelOrderRecursiveRecursive(root, result, 1);
    return result;
  }

  private void levelOrderRecursiveRecursive(
    TreeNode root,
    List<List<Integer>> result,
    int level
  ) {
    if (root != null) {
      if (result.size() < level) result.add(new LinkedList<>());
      List<Integer> current = result.get(level - 1);
      current.add(root.val);
      levelOrderRecursiveRecursive(root.left, result, level + 1);
      levelOrderRecursiveRecursive(root.right, result, level + 1);
    }
  }
}
