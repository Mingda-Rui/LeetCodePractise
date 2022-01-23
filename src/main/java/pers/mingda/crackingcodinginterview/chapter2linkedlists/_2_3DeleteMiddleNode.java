package pers.mingda.crackingcodinginterview.chapter2linkedlists;

/**
 * 2.3 Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
 * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
 * that node.
 * EXAMPLE
 * Input: the node c from the linked list a -> b -> c -> d -> e -> f
 * Result: nothing is returned, but the new linked list look like a -> b -> d -> e -> f
 */

public class _2_3DeleteMiddleNode {
    
    public static boolean deleteNode(LinkedListNode n) {
        if (n == null || n.next == null)
            return false;
        n.data = n.next.data;
        n.next = n.next.next;        
        return true;
    }
}
