package pers.mingda.leetcode;

public class LC0143ReorderList {
    public void reorderListRecursive(ListNode head) {
        reorderListRecursive(head, new ListNode[1], 0, new int[1]);
    }

    private ListNode reorderListRecursive(ListNode head, ListNode[] tailHolder, int index, int[] length) {
        if (head == null) {
            length[0] = index - 1;
            return head;
        }
        head.next = reorderListRecursive(head.next, tailHolder, index + 1, length);
        if (index == 0)
            return head;
        int mid = length[0] / 2;
        if (mid < index) {
            tailHolder[0] = head.next;
            return head;
        } else if (mid == index && length[0] % 2 == 0) {
            ListNode newHead = head.next;
            head.next = null;
            newHead.next = head;
            return newHead;
        } else {
            if (mid == index)
                head.next.next = null;
            ListNode newHead = tailHolder[0];
            tailHolder[0] = tailHolder[0].next;
            newHead.next = head;
            return newHead;
        }
    }
}
