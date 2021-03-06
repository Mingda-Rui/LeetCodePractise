package pers.mingda.leetcode;

import java.util.List;

public class AHY0206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tempHead = new ListNode();
        while (head.next != null) {
            ListNode currentNext = head.next;
            if (tempHead.next != null) {
                head.next = tempHead.next;
                tempHead.next = head;
            } else {
                tempHead.next = head;
                head.next = null;
            }
            head = currentNext;
        }
        head.next = tempHead.next;
        tempHead.next = head;

        return tempHead.next;
    }

    public ListNode reverseList_refactor(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tempHead = new ListNode(0, head);
        ListNode newTail = head;

        while (head != null) {
            ListNode currentNext = head.next;
            head.next = tempHead.next;
            tempHead.next = head;
            head = currentNext;
        }

        newTail.next = null;
        return tempHead.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (null != head.next) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        return dummy.next;
    }

    public ListNode reverseList_refactor_v3(ListNode head) {
        if (head == null || head.next == null) return head;
        int length = 0;
        ListNode newTail = head;
        ListNode newHead = head;
        do {
            newHead = newHead.next;
            length++;
        } while (newHead.next != null);
        newHead.next = head;

        for (int i = 0; i < length; i++) {
            ListNode currentNext = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = currentNext;
        }
        newTail.next = null;
        return newHead;
    }

    public ListNode reverseList_recursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newHead = reverseList_recursive(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String ... args) {
        AHY0206ReverseLinkedList test = new AHY0206ReverseLinkedList();
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        test.reverseList_recursive(one);
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
