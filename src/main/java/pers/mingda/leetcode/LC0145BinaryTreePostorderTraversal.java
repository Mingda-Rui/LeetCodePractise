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

class LC0145MorrisSolution {

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    TreeNode node = root;
    while (node != null) {
      if (node.right != null) {
        TreeNode leftMostPred = findLeftMostPred(node);
        if (leftMostPred.left == node) {
          leftMostPred.left = null;
          node = node.left;
        } else {
          result.addFirst(node.val);
          leftMostPred.left = node;
          node = node.right;
        }
      } else {
        result.addFirst(node.val);
        node = node.left;
      }
    }
    return result;
  }

  private TreeNode findLeftMostPred(TreeNode root) {
    // can always check root.right == null
    TreeNode node = root.right;
    while (node.left != null && node.left != root) {
      node = node.left;
    }
    return node;
  }
}
