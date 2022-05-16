package pers.mingda.leetcode;

public class LC0061RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;
        int length = getLength(head);
        int rotate = k % length;
        if (rotate == 0)
            return head;
        int splitIndex = length - rotate - 1;
        ListNode newTail = head;

        for (int i = 0; i < splitIndex; i++)
            newTail = newTail.next;
        ListNode newHead = newTail.next;
        newTail.next = null;

        ListNode tail = newHead;
        while (tail.next != null)
            tail = tail.next;

        tail.next = head;
        return newHead;
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
