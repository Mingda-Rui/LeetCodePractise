package pers.mingda.leetcode;

import java.util.Stack;

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

    public Node flattenIterative(Node head) {
        Stack<Node> nextNode = new Stack<>();
        Node ite = head;
        while (ite != null) {
            if (ite.child != null) {
                if (ite.next != null)
                    nextNode.push(ite.next);
                Node child = ite.child;
                ite.next = child;
                ite.child = null;
                child.prev = ite;
            }

            if (ite.next == null && !nextNode.isEmpty()) {
                Node next = nextNode.pop();
                ite.next = next;
                next.prev = ite;
            }
            ite = ite.next;
        }

        return head;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}