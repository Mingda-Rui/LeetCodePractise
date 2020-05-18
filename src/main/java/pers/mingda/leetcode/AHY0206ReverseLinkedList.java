package pers.mingda.leetcode;

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
        while (head.next != null) {
            ListNode currentNext = head.next;
            head.next = tempHead.next;
            tempHead.next = head;
            head = currentNext;
        }
        head.next = tempHead.next;
        tempHead.next = head;
        newTail.next = null;
        return tempHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
