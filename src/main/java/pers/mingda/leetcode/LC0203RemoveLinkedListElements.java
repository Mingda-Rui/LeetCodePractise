package pers.mingda.leetcode;

public class LC0203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        ListNode newHead = head;
        while (head != null && head.next != null) {
            if (head.val == val) {
                ListNode tmp = head;
                head = head.next;
                tmp.next = null;
                newHead = head;
            } else if (head.next.val == val) {
                ListNode tmp = head.next;
                head.next = tmp.next;
                tmp.next = null;
            } else {
                head = head.next;
            }
        }
        return newHead.val == val ? null : newHead;
    }

    public ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null)
            return null;
        if (head.val == val)
            return removeElementsRecursive(head.next, val);
        head.next = removeElementsRecursive(head.next, val);
        return head;
    }
}
