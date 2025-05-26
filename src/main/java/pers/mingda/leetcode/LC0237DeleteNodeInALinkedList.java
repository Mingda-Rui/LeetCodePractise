package pers.mingda.leetcode;

public class LC0237DeleteNodeInALinkedList {

  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    ListNode next = node.next;
    node.next = next.next;
    next.next = null;
  }
}
