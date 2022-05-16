package pers.mingda.leetcode;

public class LC0061RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        tail.next = head;
        int rotate = k % length;
        int splitIndex = length - rotate - 1;
        ListNode newTail = head;

        for (int i = 0; i < splitIndex; i++)
            newTail = newTail.next;
        head = newTail.next;
        newTail.next = null;

        return head;
    }
}
