package pers.mingda.leetcode;

public class LC0025ReverseNodesInKGroup {
    public ListNode reverseKGroupIterative(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prev = dummyHead;
        int counter = 1;
        while (head != null) {
            if (counter == k) {
                ListNode next = head.next;
                ListNode newTail = prev.next;
                head.next = null;
                reverse(prev, newTail);
                newTail.next = next;
                prev = newTail;
                head = next;
                counter = 1;
            } else {
                counter++;
                head = head.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode reverseKGroupRecursive(ListNode head, int k) {
        int counter = 1;
        ListNode h1 = head;
        ListNode t1 = head;

        while (counter < k && t1 != null) {
            t1 = t1.next;
            counter++;
        }

        if (counter < k || t1 == null)
            return h1;

        ListNode h2 = t1.next;
        t1.next = null;

        reverse(h1);
        h1.next = reverseKGroupRecursive(h2, k);
        return t1;
    }

    private ListNode reverse(ListNode parent, ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode oldHead = head;
            head = head.next;
            oldHead.next = newHead;
            newHead = oldHead;
        }
        if (parent != null)
            parent.next = newHead;
        return newHead;
    }

    private void reverse(ListNode head) {
        reverse(null, head);
    }
}
