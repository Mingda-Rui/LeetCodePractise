package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC0116PopulatingNextRightPointersInEachNode {

  public LC0116Node connect(LC0116Node root) {
    if (root == null) return root;
    Queue<LC0116Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        LC0116Node LC0116Node = queue.remove();
        if (i == size - 1) LC0116Node.next = null;
        else LC0116Node.next = queue.element();
        if (LC0116Node.right != null) {
          queue.add(LC0116Node.left);
          queue.add(LC0116Node.right);
        }
      }
    }
    return root;
  }

  public LC0116Node connectIterativeNoStack(LC0116Node root) {
    if (root == null) return root;
    LC0116Node ite = root;
    LC0116Node nextLevel = ite.left;
    while (ite != null) {
      if (ite.left != null) {
        ite.left.next = ite.right;
        if (ite.next != null) ite.right.next = ite.next.left;
      }

      ite = ite.next;
      if (ite == null && nextLevel != null) {
        ite = nextLevel;
        nextLevel = ite.left;
      }
    }
    return root;
  }

  public LC0116Node connectRecursive(LC0116Node root) {
    if (root == null || root.left == null) return root;
    root.left.next = root.right;
    if (root.next != null) root.right.next = root.next.left;
    connectRecursive(root.left);
    connectRecursive(root.right);
    return root;
  }
}

class LC0116Node {

  public int val;
  public LC0116Node left;
  public LC0116Node right;
  public LC0116Node next;

  public LC0116Node() {}

  public LC0116Node(int _val) {
    val = _val;
  }

  public LC0116Node(
    int _val,
    LC0116Node _left,
    LC0116Node _right,
    LC0116Node _next
  ) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
}
