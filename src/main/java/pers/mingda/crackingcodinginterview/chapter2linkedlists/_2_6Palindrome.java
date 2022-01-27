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
}
