package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC0144BinaryTreePreorderTraversal {}

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
class LC0144SingleWhileLoopSolution {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.empty()) {
      TreeNode node = stack.pop();
      result.add(node.val);

      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }

    return result;
  }
}

class LC0144Solution {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();

    TreeNode node = root;

    while (node != null || !stack.empty()) {
      while (node != null) {
        result.add(node.val);
        stack.push(node);
        node = node.left;
      }

      node = stack.pop();
      node = node.right;
    }

    return result;
  }
}

class LC0144MorrisAlgorithmSolution {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    TreeNode node = root;
    while (node != null) {
      if (node.left == null) {
        result.add(node.val);
        node = node.right;
      } else {
        TreeNode predecessor = findRightMostPredecessor(node);
        if (predecessor.right == null) {
          result.add(node.val);
          predecessor.right = node;
          node = node.left;
        } else {
          predecessor.right = null;
          node = node.right;
        }
      }
    }

    return result;
  }

  private TreeNode findRightMostPredecessor(TreeNode node) {
    TreeNode predecessor = node.left;
    while (predecessor.right != null && predecessor.right != node) {
      predecessor = predecessor.right;
    }
    return predecessor;
  }
}
