package pers.mingda.crackingcodinginterview.chapter2linkedlists;

/**
 *  2.5 Sum Lists: You have two numbers represented by a linked list, where each node contains a single
 *  digit. THe digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a 
 *  function that adds the two numbers and returns the sum as a linked list.
 *  EXAMPLE:
 *  Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
 *  Output: 2 -> 1 -> 9. That is, 912.
 *  FOLLOW UP
 *  Suppose the digits are stored in forward order. Repeat the above problem.
 *  Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
 *  Output: 9 -> 1 -> 2. That is, 912. 
 */

public class _2_5SumLists {
    public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        
        return null;
    }

    public static LinkedListNode sumLists(LinkedListNode l1, LinkedListNode l2) {        
        int carry = 0;
        LinkedListNode sum = new LinkedListNode(null, carry);
        LinkedListNode sumHead = sum;
        
        while (l1 != null || l2 != null) {

            int l1Data = (l1 == null) ? 0 : l1.data;
            int l2Data = (l2 == null) ? 0 : l2.data;
            carry = (sum.data + l1Data + l2Data) / 10;
            sum.data = (sum.data + l1Data + l2Data) % 10;
            
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;

            if (l1 != null || l2 != null || carry != 0) {
                sum.next = new LinkedListNode(null, carry);
                sum = sum.next;
            }
        }
        
        return sumHead;
    }

    public static LinkedListNode sumListsRecursive(LinkedListNode l1, LinkedListNode l2) {
        return sumListsRecursive(l1, l2, 0);
    }

    public static LinkedListNode sumListsRecursive(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0)
            return null;
        int l1Data = (l1 == null) ? 0 : l1.data;
        int l2Data = (l2 == null) ? 0 : l2.data;        
        int currentSum = l1Data + l2Data + carry;
        LinkedListNode result = new LinkedListNode(null, currentSum % 10);
        LinkedListNode l1Next = (l1 == null) ? null : l1.next;
        LinkedListNode l2Next = (l2 == null) ? null : l2.next;
        result.next = sumListsRecursive(l1Next, l2Next, currentSum / 10);

        return result;
    }
}
