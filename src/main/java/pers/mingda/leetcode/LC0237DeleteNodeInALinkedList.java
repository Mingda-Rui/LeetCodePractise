package pers.mingda.leetcode;

public class LC0237DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        while (node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}
