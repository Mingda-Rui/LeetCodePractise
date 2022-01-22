package pers.mingda.crackingcodinginterview.chapter2linkedlists;

import java.util.List;

public class LinkedListBuilder {
    public LinkedListNode build(List<Integer> nodeValues) {
        if (nodeValues.isEmpty()) {
            throw new IllegalArgumentException("Failed to crate linked list, no valid data provided");
        }
        LinkedListNode node = new LinkedListNode(null, nodeValues.get(0));        
        for (int i = 1; i < nodeValues.size(); i++) {
            node.next = new LinkedListNode(null, i);
        }
        return node;
    }
}
