package pers.mingda.leetcode;

public class LC0025ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ite = head;
        ListNode prev = null;
        int counter = 1;
        while (ite != null) {
            if (counter == k) {
                ListNode next = ite.next;
                ListNode newTail = prev == null ? head : prev.next;
                ite.next = null;
                ListNode newHead = reverse(prev, newTail);
                head = prev == null ? newHead : head;
                newTail.next = next;
                prev = newTail;
                ite = next;
                counter = 1;
            } else {
                counter++;
                ite = ite.next;
            }
        }

        return head;
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
        h1.next = reverseKGroup(h2, k);
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
