package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0138CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummyHead = new Node(-1);
        Node copy = copyByNext(head, dummyHead, map);

        while (head != null) {
            Node random = head.random;
            if (random != null) {
                copy.random = map.get(random);
            }
            head = head.next;
            copy = copy.next;
        }
        copy = dummyHead.next;
        dummyHead.next = null;
        return copy;

    }

    private Node copyByNext(Node origin, Node copy, Map<Node, Node> map) {
        if (origin == null)
            return origin;
        Node next = new Node(origin.val);
        map.put(origin, next);
        copy.next = next;
        copyByNext(origin.next, next, map);
        return next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
