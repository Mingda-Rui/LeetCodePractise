package pers.mingda.leetcode;

public class AHY0206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode();
        while (head.next != null) {
            ListNode currentNext = head.next;
            if (newHead.next != null) {
                head.next = newHead.next;
                newHead.next = head;
            } else {
                newHead.next = head;
                head.next = null;
            }
            head = currentNext;
        }
        head.next = newHead.next;
        newHead.next = head;


        return newHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
