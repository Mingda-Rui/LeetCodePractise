package pers.mingda.leetcode;

import java.util.Stack;

public class LC2487RemoveNodesFromLinkedList {
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LC2487Solution {
  public ListNode removeNodes(ListNode head) {
    ListNode reversed = reverse(head);
    ListNode pointer = reversed;
    int max = reversed.val;
    while (pointer.next != null) {
      int val = pointer.next.val;
      if (val < max) {
        ListNode next = pointer.next;
        pointer.next = next.next;
        next.next = null;
      } else {
        max = val;
        pointer = pointer.next;
      }
    }
    return reverse(reversed);
  }

  private ListNode reverse(ListNode head) {
    ListNode node = new ListNode();
    while (head != null) {
      ListNode next = head.next;
      head.next = node.next;
      node.next = head;
      head = next;
    }
    head = node.next;
    node.next = null;
    return head;
  }
}

class LC2487MonotonicStackSolution {
  public ListNode removeNodes(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    ListNode pointer = head;
    while (pointer != null) {
      if (!stack.isEmpty() && stack.peek().val < pointer.val) {
        stack.pop();
      } else {
        stack.add(pointer);
        pointer = pointer.next;
      }
    }
    head = stack.pop();
    head.next = null;
    while (!stack.isEmpty()) {
      pointer = stack.pop();
      pointer.next = head;
      head = pointer;
    }
    return head;
  }
}

class LC2487StackSolution {
  public ListNode removeNodes(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    while (head != null) {
      stack.push(head);
      head = head.next;
    }

    head = stack.pop();
    head.next = null;
    int max = head.val;
    while (!stack.isEmpty()) {
      ListNode node = stack.pop();
      if (node.val >= max) {
        node.next = head;
        head = node;
        max = node.val;
      }
    }
    return head;
  }
}