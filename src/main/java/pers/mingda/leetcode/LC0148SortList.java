package pers.mingda.leetcode;

public class LC0148SortList {}

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
class Solution {

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode mid = cutHalf(head);
    return merge(sortList(head), sortList(mid));
  }

  private ListNode cutHalf(ListNode head) {
    ListNode slow = null;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow == null ? head : slow.next;
      fast = fast.next.next;
    }

    ListNode mid = slow.next;
    slow.next = null;
    return mid;
  }

  private ListNode merge(ListNode list1, ListNode list2) {
    ListNode dummyHead = new ListNode();
    ListNode result = dummyHead;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        result.next = list1;
        list1 = list1.next;
      } else {
        result.next = list2;
        list2 = list2.next;
      }
      result = result.next;
    }
    result.next = list1 != null ? list1 : list2;
    ListNode merged = dummyHead.next;
    dummyHead.next = null;
    return merged;
  }
}
