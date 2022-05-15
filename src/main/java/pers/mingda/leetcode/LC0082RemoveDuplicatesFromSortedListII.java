package pers.mingda.leetcode;

public class LC0082RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prev = dummyHead;
        ListNode pointer = head;
        while (pointer != null) {
            if (pointer.next == null || pointer.val != pointer.next.val) {
                if (prev.next != pointer)
                    prev.next = pointer.next;
                else
                    prev = prev.next;
            }
            pointer = pointer.next;
        }
        return dummyHead.next;
    }

    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if (head == null || head.next == null)
            return head;
        if (head.val == head.next.val) {
            if (head.next.next != null && head.next.next.val == head.val)
                head = deleteDuplicates(head.next);
            else
                head = deleteDuplicates(head.next.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}
