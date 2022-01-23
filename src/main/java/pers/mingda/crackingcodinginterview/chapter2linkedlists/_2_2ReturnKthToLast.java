package pers.mingda.crackingcodinginterview.chapter2linkedlists;

/**
 * 2.2. Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */

public class _2_2ReturnKthToLast {
    
    public static int printKthToLast(LinkedListNode head, int k) {
        int counter = 0;
        LinkedListNode kthToLast = head;
        while (head != null) {
            counter++;
            head = head.next;
            if (counter > k) {
                kthToLast = kthToLast.next;
            }
        }
        if (counter < k)
            throw new IllegalArgumentException("The size of the list is " + counter + ", which is less than " + k);
        return kthToLast.data;
    }
}
