package pers.mingda.leetcode;

import java.util.Stack;

public class LC0092ReverseLinkedListII {

  public ListNode reverseBetween(ListNode head, int left, int right) {
    Stack<Integer> stack = new Stack<>();
    ListNode headPointer = head;
    ListNode leftNode = head;
    int counter = 1;

    while (head != null && counter <= right) {
      if (counter == left) leftNode = head;
      if (counter >= left) stack.push(head.val);
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

  public ListNode reverseBetweenRecursive(ListNode head, int left, int right) {
    return reverse(head, left, right, 1, new ListNode[1]);
  }

  private ListNode reverse(
    ListNode head,
    int left,
    int right,
    int counter,
    ListNode[] tailHolder
  ) {
    if (head == null) return head;
    if (counter < left || counter >= right) {
      head.next = reverse(head.next, left, right, counter + 1, tailHolder);
      tailHolder[0] = head;
    } else if (counter <= right) {
      ListNode newHead = reverse(
        head.next,
        left,
        right,
        counter + 1,
        tailHolder
      );
      ListNode tail = tailHolder[0];

      head.next = tail.next;
      tail.next = head;
      tailHolder[0] = tail.next;
      head = newHead;
    }
    return head;
  }
}
