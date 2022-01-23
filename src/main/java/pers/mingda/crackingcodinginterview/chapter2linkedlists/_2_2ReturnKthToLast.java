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
        checkSize(counter, k);
        return kthToLast.data;
    }

    public static int printKthToLastRecursive(LinkedListNode head, int k) {
        int[] kthValHolder = new int[1];

        int headToLast = printKthToLastRecursive(head, k, kthValHolder);
        checkSize(headToLast, k);
        return kthValHolder[0];
    }

    private static int printKthToLastRecursive(LinkedListNode head, int k, int[] kthVal) {
        
        if (head == null) {
            return 0;
        }
        int currentLoc = printKthToLastRecursive(head.next, k, kthVal) + 1;
        if (currentLoc == k) {
            kthVal[0] = head.data;
        }
        return currentLoc;
    }

    private static void checkSize(int size, int k) {
        if (size < k)
            throw new IllegalArgumentException("The size of the list is " + size + ", which is less than " + k);
    }
}
