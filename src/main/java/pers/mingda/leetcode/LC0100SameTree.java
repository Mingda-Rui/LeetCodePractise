package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC0100SameTree {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;

    boolean isSame = p.val == q.val;
    isSame = isSame && isSameTree(p.left, q.left);
    isSame = isSame && isSameTree(p.right, q.right);
    return isSame;
  }

  public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
    Queue<TreeNode> pQueue = new LinkedList<>();
    Queue<TreeNode> qQueue = new LinkedList<>();
    pQueue.offer(p);
    qQueue.offer(q);
    while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
      p = pQueue.poll();
      q = qQueue.poll();
      if (p != null && q != null) {
        if (p.val != q.val) return false;
        pQueue.add(p.left);
        qQueue.add(q.left);
        pQueue.add(p.right);
        qQueue.add(q.right);
      } else if (p != q) {
        return false;
      }
    }

    return pQueue.isEmpty() && qQueue.isEmpty();
  }
}
