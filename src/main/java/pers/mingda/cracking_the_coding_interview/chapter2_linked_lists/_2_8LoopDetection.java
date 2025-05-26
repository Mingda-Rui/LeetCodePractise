package pers.mingda.cracking_the_coding_interview.chapter2_linked_lists;

/**
 * 2.8 Loop Detection: Given a circular linked list, implement an algorithm that returns the node at
 * the beginning of the leep. DEFINITION Circular linked list: A (corrupt) linked list in which a
 * node's next pointer points to an earlier node, so as to make a loop in the linked list. EXAMPLE
 * Input: A -> B -> C -> D -> E -> C [the smae C as earlier] Output: C
 */
public class _2_8LoopDetection {

  public static LinkedListNode findBeginning(LinkedListNode head) {
    LinkedListNode fast = head;
    LinkedListNode slow1 = head;
    boolean meet = false;
    while (fast != null && fast.next != null && !meet) {
      fast = fast.next.next;
      slow1 = slow1.next;
      if (fast == slow1) meet = true;
      ;
    }
    if (!meet) return null;

    LinkedListNode slow2 = head;
    while (slow1 != slow2) {
      slow1 = slow1.next;
      slow2 = slow2.next;
    }
    return slow1;
  }
}
