package pers.mingda.leetcode;

public class LC0143ReorderList {
    public void reorderListRecursive(ListNode head) {
        reorderListRecursive(head, new ListNode[1], 0, new int[1]);
    }

    public ListNode reorderListRecursive(ListNode head, ListNode[] tailHolder, int index, int[] length) {
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

    public ListNode reorderListReverseAndMerge(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reversedSecondHalf = reverseListNode(slow.next, null);
        slow.next = null;
        return merge(head, reversedSecondHalf);
    }

    private ListNode reverseListNode(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode node = head.next;
        head.next = newHead;
        return reverseListNode(node, head);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        l1.next = merge(l2, l1.next);
        return l1;
    }
}
