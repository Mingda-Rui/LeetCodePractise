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
    int mCount = m;
    int nCount = n;
    while (pointer != null) {
      while (mCount > 1 && pointer != null) {
        pointer = pointer.next;
        mCount--;
      }
      if (pointer == null) {
        break;
      }
      ListNode prev = pointer;
      pointer = pointer.next;
      mCount = m;
      while (nCount != 0 && pointer != null) {
        pointer = pointer.next;
        nCount--;
      }
      nCount = n;
      prev.next = pointer;
    }
    return head;
  }
}
