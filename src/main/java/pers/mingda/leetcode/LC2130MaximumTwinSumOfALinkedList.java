package pers.mingda.leetcode;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class LC2130MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        int max = 0;
        while (slow != null) {
            int sum = slow.val + stack.pop();
            max = Math.max(max, sum);
            slow = slow.next;
        }
        return max;
    }
}
