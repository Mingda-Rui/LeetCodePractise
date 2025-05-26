package pers.mingda.leetcode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class LC2095DeleteTheMiddleNodeOfALinkedList {

  public ListNode deleteMiddle(ListNode head) {
    if (head.next == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head.next.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode toDelete = slow.next;
    slow.next = toDelete.next;
    toDelete.next = null;

    return head;
  }
}
