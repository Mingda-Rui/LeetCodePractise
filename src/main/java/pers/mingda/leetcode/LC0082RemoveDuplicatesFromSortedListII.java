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
        if (head == null)
            return head;
        return deleteDuplicates(head, head.next);

    }

    private ListNode deleteDuplicates(ListNode parent, ListNode head) {
        if (head == null)
            return parent;
        if (parent.val == head.val) {
            if (head.next == null)
                return deleteDuplicates(head.next, null);
            else if (head.next.val == head.val) {
                return deleteDuplicates(parent, head.next);
            } else {
                return deleteDuplicates(head.next, head.next.next);
            }
        } else {
            parent.next = deleteDuplicates(head, head.next);
            return parent;
        }
    }
}
