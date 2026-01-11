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
class LC0144Solution {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;

    while (node != null || !stack.empty()) {
      if (node == null) {
        node = stack.pop();
      }

      while (node.left != null) {
        result.add(node.val);
        if (node.right != null) {
          stack.push(node.right);
        }
        node = node.left;
      }

      result.add(node.val);
      node = node.right;
    }

    return result;
  }
}
