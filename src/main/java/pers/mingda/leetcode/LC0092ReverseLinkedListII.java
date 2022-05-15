package pers.mingda.leetcode;

import java.util.Stack;

public class LC0092ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        Stack<Integer> stack = new Stack<>();
        ListNode headPointer = head;
        ListNode leftNode = head;
        int counter = 1;

        while (head != null && counter <= right) {
            if (counter == left)
                leftNode = head;
            if (counter >= left)
                stack.push(head.val);
            head = head.next;
            counter++;
        }

        while (!stack.isEmpty()) {
            int val = stack.pop();
            leftNode.val = val;
            leftNode = leftNode.next;
        }

        return headPointer;
    }
}
