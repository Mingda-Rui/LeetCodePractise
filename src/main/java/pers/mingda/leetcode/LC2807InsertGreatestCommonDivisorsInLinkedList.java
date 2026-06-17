package pers.mingda.leetcode;

public class LC2807InsertGreatestCommonDivisorsInLinkedList {}

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class LC2807Solution {
  public ListNode insertGreatestCommonDivisors(ListNode head) {
    if (head.next == null) {
      return head;
    }
    ListNode next = head.next;
    int gcd = getGcd(head.val, next.val);
    head.next = new ListNode(gcd, next);
    insertGreatestCommonDivisors(next);
    return head;
  }

  private int getGcd(int val1, int val2) {
    while (val1 % val2 != 0) {
      int reminder = val1 % val2;
      val1 = val2;
      val2 = reminder;
    }
    return val2;
  }
}
