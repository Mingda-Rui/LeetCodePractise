package pers.mingda.leetcode;

public class LC0430FlattenAMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        flattenRecursive(head);
        return head;
    }

    public Node flattenRecursive(Node head) {
        while (head != null) {
            if (head.child != null) {
                Node tail = flattenRecursive(head.child);

                if (head.next != null) {
                    tail.next = head.next;
                    head.next.prev = tail;
                }

                head.next = head.child;
                head.child.prev = head;
                head.child = null;
            }
            if (head.next == null)
                return head;
            head = head.next;
        }
        return head;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};