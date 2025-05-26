package pers.mingda.cracking_the_coding_interview.chapter2_linked_lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 2.2. Return Kth to Last: Implement an algorithm to find the kth to last element of a singly
 * linked list.
 */
public class _2_2ReturnKthToLast {

  public static LinkedListNode kthToLast(LinkedListNode head, int k) {
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
    return kthToLast;
  }

  public static LinkedListNode kthToLastRecursive(LinkedListNode head, int k) {
    List<LinkedListNode> kthNode = new ArrayList<>();

    int headToLast = kthToLastRecursive(head, k, kthNode);
    checkSize(headToLast, k);
    return kthNode.get(0);
  }

  private static int kthToLastRecursive(LinkedListNode head, int k, List<LinkedListNode> kthNode) {
    if (head == null) {
      return 0;
    }
    int currentLoc = kthToLastRecursive(head.next, k, kthNode) + 1;
    if (currentLoc == k) {
      kthNode.add(head);
    }
    return currentLoc;
  }

  private static void checkSize(int size, int k) {
    if (size < k)
      throw new IllegalArgumentException(
          "The size of the list is " + size + ", which is less than " + k);
  }
}
