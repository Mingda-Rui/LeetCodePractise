package pers.mingda.cracking_the_coding_interview.chapter2_linked_lists;

import java.util.Stack;

/**
 * 2.5 Sum Lists: You have two numbers represented by a linked list, where each node contains a
 * single digit. THe digits are stored in reverse order, such that the 1's digit is at the head of
 * the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE: Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295. Output: 2 -> 1 -> 9. That is,
 * 912. FOLLOW UP Suppose the digits are stored in forward order. Repeat the above problem. Input:
 * (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295. Output: 9 -> 1 -> 2. That is, 912.
 */
public class _2_5SumLists {

  public static LinkedListNode addLists(
    LinkedListNode l1,
    LinkedListNode l2,
    int carry
  ) {
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

  public static LinkedListNode sumListsRecursive(
    LinkedListNode l1,
    LinkedListNode l2
  ) {
    return sumListsRecursive(l1, l2, 0);
  }

  public static LinkedListNode sumListsRecursive(
    LinkedListNode l1,
    LinkedListNode l2,
    int carry
  ) {
    if (l1 == null && l2 == null && carry == 0) return null;
    int l1Data = (l1 == null) ? 0 : l1.data;
    int l2Data = (l2 == null) ? 0 : l2.data;
    int currentSum = l1Data + l2Data + carry;
    LinkedListNode result = new LinkedListNode(null, currentSum % 10);
    LinkedListNode l1Next = (l1 == null) ? null : l1.next;
    LinkedListNode l2Next = (l2 == null) ? null : l2.next;
    result.next = sumListsRecursive(l1Next, l2Next, currentSum / 10);

    return result;
  }

  public static LinkedListNode sumListsFollowUpReverse(
    LinkedListNode l1,
    LinkedListNode l2
  ) {
    LinkedListNode reversedL1 = reverse(l1);
    LinkedListNode reversedL2 = reverse(l2);
    LinkedListNode result = sumLists(reversedL1, reversedL2);
    return reverse(result);
  }

  private static LinkedListNode reverse(LinkedListNode list) {
    return reverse(list, null);
  }

  private static LinkedListNode reverse(
    LinkedListNode list,
    LinkedListNode previous
  ) {
    if (list == null) {
      return previous;
    }
    LinkedListNode next = list.next;
    list.next = previous;
    return reverse(next, list);
  }

  public static LinkedListNode sumListsFollowUp(
    LinkedListNode l1,
    LinkedListNode l2
  ) {
    Stack<Integer> l1Stack = convertToStack(l1);
    Stack<Integer> l2Stack = convertToStack(l2);

    int carry = 0;
    LinkedListNode list = new LinkedListNode(null, carry);
    while (!l1Stack.empty() || !l2Stack.empty()) {
      int data1 = l1Stack.empty() ? 0 : l1Stack.pop();
      int data2 = l2Stack.empty() ? 0 : l2Stack.pop();
      int sum = data1 + data2 + carry;
      list.data = sum % 10;
      carry = sum / 10;
      if (!l1Stack.empty() || !l2Stack.empty() || carry != 0) {
        LinkedListNode head = new LinkedListNode(list, carry);
        list = head;
      }
    }

    return list;
  }

  private static Stack<Integer> convertToStack(LinkedListNode list) {
    Stack<Integer> stack = new Stack<>();
    pushStack(stack, list);
    return stack;
  }

  private static void pushStack(Stack<Integer> stack, LinkedListNode list) {
    while (list != null) {
      stack.push(list.data);
      list = list.next;
    }
  }

  public static LinkedListNode sumListsFollowUpRecursion(
    LinkedListNode l1,
    LinkedListNode l2
  ) {
    int l1Size = getListSize(l1);
    int l2Size = getListSize(l2);

    LinkedListNode list = sumListsFollowUpRecursion(l1, l1Size, l2, l2Size);
    if (list.data >= 10) {
      LinkedListNode head = new LinkedListNode(list, list.data / 10);
      list.data = list.data % 10;
      list = head;
    }

    return list;
  }

  public static LinkedListNode sumListsFollowUpRecursion(
    LinkedListNode l1,
    int l1Size,
    LinkedListNode l2,
    int l2Size
  ) {
    // termination condition
    if (l1.next == null && l2.next == null) {
      return new LinkedListNode(null, l1.data + l2.data);
    }

    // recursion body
    LinkedListNode l1Next = (l1Size >= l2Size) ? l1.next : l1;
    int l1NextSize = (l1Size >= l2Size) ? l1Size - 1 : l1Size;
    LinkedListNode l2Next = (l2Size >= l1Size) ? l2.next : l1;
    int l2NextSize = (l2Size >= l1Size) ? l2Size - 1 : l2Size;

    LinkedListNode previous = sumListsFollowUpRecursion(
      l1Next,
      l1NextSize,
      l2Next,
      l2NextSize
    );

    int l1CurrentData = (l1Size >= l2Size) ? l1.data : 0;
    int l2CurrentData = (l2Size >= l1Size) ? l2.data : 0;
    LinkedListNode current = new LinkedListNode(
      previous,
      l1CurrentData + l2CurrentData + previous.data / 10
    );
    previous.data = previous.data % 10;

    // return
    return current;
  }

  private static int getListSize(LinkedListNode list) {
    int size = 0;
    while (list != null) {
      list = list.next;
      size++;
    }
    return size;
  }
}
