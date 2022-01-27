package pers.mingda.crackingcodinginterview.chapter2linkedlists;

/**
 *  2.6 Palindrome: Implement a function to check if a linked list is a palindrome 
 */

public class _2_6Palindrome {
    public static boolean isPalindrome(LinkedListNode node) {
        LinkedListNode reversed = reverse(node);
        while (node != null) {
            if (node.data != reversed.data)
                return false;
            node = node.next;
            reversed = reversed.next;
        }
        return true;
    }

    private static LinkedListNode reverse(LinkedListNode node) {
        LinkedListNode reversed = null;
        while (node != null) {
            LinkedListNode head = new LinkedListNode(reversed, node.data);            
            reversed = head;
            node = node.next;
        }
        return reversed;
    }

    public static boolean isPalindromeRecursion(LinkedListNode node) {
        int size = getSize(node);
        return isPalindromeRecursion(node, null, size);
    }

    private static boolean isPalindromeRecursion(LinkedListNode node, LinkedListNode copied, int remainSize) {
        if (node == null) 
            return true;
        if (remainSize < 1 && node.data != copied.data) 
            return false;
            
        if (remainSize > 1) {
            LinkedListNode head = new LinkedListNode(copied, node.data);
            copied = head;            
        } else if (remainSize < 1) {
            copied = copied.next;            
        }
        return isPalindromeRecursion(node.next, copied, remainSize - 2);
    }

    private static int getSize(LinkedListNode node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }
}
