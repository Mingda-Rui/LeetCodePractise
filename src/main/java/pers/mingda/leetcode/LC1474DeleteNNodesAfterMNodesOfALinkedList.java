package pers.mingda.leetcode;

public class LC1474DeleteNNodesAfterMNodesOfALinkedList {}

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
class LC1474Solution {

  public ListNode deleteNodes(ListNode head, int m, int n) {
    ListNode pointer = head;
    ListNode prevTail = head;
    int mCount = m;
    int nCount = n;
    while (pointer != null) {
      while (mCount != 0 && pointer != null) {
        prevTail = pointer;
        pointer = pointer.next;
        mCount--;
      }
      mCount = m;
      while (nCount != 0 && pointer != null) {
        pointer = pointer.next;
        nCount--;
      }
      nCount = n;
      prevTail.next = pointer;
    }
    return head;
  }
}
