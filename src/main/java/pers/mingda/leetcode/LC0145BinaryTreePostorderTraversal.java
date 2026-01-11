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
