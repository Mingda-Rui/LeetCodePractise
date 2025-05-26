package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC0590NAryTreePostorderTraversal {
  public List<Integer> postorderIterative(LC0590Node root) {
    LinkedList<Integer> result = new LinkedList<>();
    if (root == null) return result;

    Stack<LC0590Node> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      LC0590Node current = stack.pop();
      result.addFirst(current.val);
      for (LC0590Node child : current.children) stack.push(child);
    }
    return result;
  }

  public List<Integer> postorderRecursive(LC0590Node root) {
    List<Integer> result = new LinkedList<>();
    return postorderRecursive(root, result);
  }

  private List<Integer> postorderRecursive(LC0590Node root, List<Integer> result) {
    if (root == null) return result;

    for (LC0590Node child : root.children) postorderRecursive(child, result);
    result.add(root.val);
    return result;
  }
}

class LC0590Node {
  public int val;
  public List<LC0590Node> children;

  public LC0590Node() {}

  public LC0590Node(int _val) {
    val = _val;
  }

  public LC0590Node(int _val, List<LC0590Node> _children) {
    val = _val;
    children = _children;
  }
}
