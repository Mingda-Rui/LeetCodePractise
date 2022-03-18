package pers.mingda.leetcode;

public class LC0019RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode OneBeforeHead = new ListNode();
        OneBeforeHead.next = head;
        ListNode fast = head;
        ListNode slow = OneBeforeHead;

        for (int i = 0; i < n; i++)
            fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return OneBeforeHead.next;
    }
}
