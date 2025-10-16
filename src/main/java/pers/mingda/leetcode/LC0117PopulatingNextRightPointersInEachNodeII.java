package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC0117PopulatingNextRightPointersInEachNodeII {}

class LC0117Solution {

  public LC0117Node connect(LC0117Node root) {
    if (root == null) {
      return null;
    }
    Queue<LC0117Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      LC0117Node currNode = queue.remove();
      enqueueChildren(currNode, queue);
      for (int i = 1; i < size; i++) {
        LC0117Node nextNode = queue.remove();
        enqueueChildren(nextNode, queue);
        currNode.next = nextNode;
        currNode = nextNode;
      }
    }
    return root;
  }

  private void enqueueChildren(LC0117Node node, Queue<LC0117Node> queue) {
    if (node.left != null) {
      queue.add(node.left);
    }
    if (node.right != null) {
      queue.add(node.right);
    }
  }
}

class LC0117Node {

  public int val;
  public LC0117Node left;
  public LC0117Node right;
  public LC0117Node next;

  public LC0117Node() {}

  public LC0117Node(int _val) {
    val = _val;
  }

  public LC0117Node(int _val, LC0117Node _left, LC0117Node _right, LC0117Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
}
