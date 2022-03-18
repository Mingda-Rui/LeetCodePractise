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

    public ListNode removeNthFromEndRecursive(ListNode head, int n) {
        ListNode pseudoHead = new ListNode(-1, head);
        removeNthFromEndHelper(pseudoHead, n);
        return pseudoHead.next;
    }

    private int removeNthFromEndHelper(ListNode head, int n) {
        if (head == null)
            return 0;
        int count = removeNthFromEndHelper(head.next, n);
        if (count == n)
            head.next = head.next.next;
        return count + 1;
    }
}
