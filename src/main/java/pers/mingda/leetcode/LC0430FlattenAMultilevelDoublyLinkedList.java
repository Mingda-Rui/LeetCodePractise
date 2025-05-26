package pers.mingda.leetcode;

import java.util.Stack;

public class LC0430FlattenAMultilevelDoublyLinkedList {

  public LC0430Node flatten(LC0430Node head) {
    flattenRecursive(head);
    return head;
  }

  public LC0430Node flattenRecursive(LC0430Node head) {
    while (head != null) {
      if (head.child != null) {
        LC0430Node tail = flattenRecursive(head.child);

        if (head.next != null) {
          tail.next = head.next;
          head.next.prev = tail;
        }

        head.next = head.child;
        head.child.prev = head;
        head.child = null;
      }
      if (head.next == null) return head;
      head = head.next;
    }
    return head;
  }

  public LC0430Node flattenIterative(LC0430Node head) {
    Stack<LC0430Node> nextLC0430Node = new Stack<>();
    LC0430Node ite = head;
    while (ite != null) {
      if (ite.child != null) {
        if (ite.next != null) nextLC0430Node.push(ite.next);
        LC0430Node child = ite.child;
        ite.next = child;
        ite.child = null;
        child.prev = ite;
      }

      if (ite.next == null && !nextLC0430Node.isEmpty()) {
        LC0430Node next = nextLC0430Node.pop();
        ite.next = next;
        next.prev = ite;
      }
      ite = ite.next;
    }

    return head;
  }
}

class LC0430Node {

  public int val;
  public LC0430Node prev;
  public LC0430Node next;
  public LC0430Node child;
}
