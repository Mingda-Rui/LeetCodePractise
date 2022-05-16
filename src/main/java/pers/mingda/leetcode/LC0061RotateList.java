package pers.mingda.leetcode;

public class LC0061RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;
        int length = getLength(head);
        int rotate = k % length;
        if (rotate == 0)
            return head;
        int startIndex = length - rotate - 1;
        ListNode pointer = head;
        for (int i = 0; i < length; i++) {
            if (i == startIndex) {
                ListNode newHead = pointer.next;
                ListNode tmp = pointer;
                while (pointer.next != null)
                    pointer = pointer.next;
                tmp.next = null;
                pointer.next = head;
                return newHead;
            } else {
                pointer = pointer.next;
            }
        }
        return head;
    }

    private int getLength(ListNode head) {
        int counter = 0;
        while (head != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }
}
