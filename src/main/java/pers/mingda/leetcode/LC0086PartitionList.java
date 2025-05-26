package pers.mingda.leetcode;

public class LC0086PartitionList {
  public ListNode partition(ListNode head, int x) {
    ListNode dummyHead = new ListNode(-1, head);
    head = dummyHead;
    while (head.next != null && head.next.val < x) head = head.next;
    ListNode lessThanTail = head;

    while (head.next != null) {
      ListNode next = head.next;
      if (next.val < x) {
        head.next = next.next;
        next.next = lessThanTail.next;
        lessThanTail.next = next;
        lessThanTail = next;
      } else {
        head = head.next;
      }
    }

    return dummyHead.next;
  }
}
