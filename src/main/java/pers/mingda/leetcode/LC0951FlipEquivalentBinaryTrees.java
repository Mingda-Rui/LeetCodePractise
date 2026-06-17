package pers.mingda.leetcode;

import java.util.Stack;

public class LC0951FlipEquivalentBinaryTrees {}

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class LC0951Solution {
  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    if ((root1 == null) ^ (root2 == null)) {
      return false;
    }
    if (root1 == null) { // root2 much be null if root1 is null
      return true;
    }

    if (root1.val != root2.val) {
      return false;
    }
    return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
        || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
  }
}

class LC0951StackSolution {
  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();

    stack1.push(root1);
    stack2.push(root2);
    while (!stack1.isEmpty()) {
      TreeNode node1 = stack1.pop();
      TreeNode node2 = stack2.pop();
      if (!isEqual(node1, node2)) {
        return false;
      }
      if (node1 == null) {
        continue;
      }

      if (isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right)) {
        stack1.push(node1.left);
        stack2.push(node2.left);
        stack1.push(node1.right);
        stack2.push(node2.right);
      } else if (isEqual(node1.left, node2.right) && isEqual(node1.right, node2.left)) {
        stack1.push(node1.left);
        stack2.push(node2.right);
        stack1.push(node1.right);
        stack2.push(node2.left);
      } else {
        return false;
      }
    }
    return true;
  }

  private boolean isEqual(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) {
      return true;
    }

    if (node1 == null || node2 == null) {
      return false;
    }

    return node1.val == node2.val;
  }
}
