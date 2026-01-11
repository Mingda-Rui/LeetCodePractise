package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC0145BinaryTreePostorderTraversal {}

class LC0145IterativeSolution {

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();

    TreeNode node = root;

    while (node != null || !stack.empty()) {
      while (node != null) {
        stack.push(node);
        result.addFirst(node.val);
        node = node.right;
      }
      node = stack.pop();
      node = node.left;
    }

    return result;
  }
}

class LC0145IterativeNaturalOrderSolution {

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();

    TreeNode prev = null;
    TreeNode node = root;

    while (node != null || !stack.empty()) {
      if (node != null) {
        stack.push(node);
        node = node.left;
      } else {
        node = stack.peek();
        if (node.right == null || node.right == prev) {
          result.add(node.val);
          prev = node;
          stack.pop();
          node = null;
        } else {
          node = node.right;
        }
      }
    }

    return result;
  }
}
