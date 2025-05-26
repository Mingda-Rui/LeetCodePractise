package pers.mingda.cracking_the_coding_interview.chapter2_linked_lists;

/**
 * 2.4 Partition: Write code to partition a linked list around a value x, such that all nodes less
 * than x come before all nodes greater than or equal to x. If x is contained within the list, the
 * values of x only need to be after the elements less than x (see below). The partition element x
 * can appear anywhere in the "right partition"; it does not need to appear between the left and
 * right partitions. EXAMPLE Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5] Output: 3 -> 1
 * -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class _2_4Partition {
  public static LinkedListNode partition(LinkedListNode node, int x) {
    LinkedListNode left = new LinkedListNode(null, x - 1);
    LinkedListNode pseudoLeftHead = left;
    node = new LinkedListNode(node, x);
    LinkedListNode pseudoRightHead = node;
    while (node.next != null) {
      if (node.next.data < x) {
        left.next = node.next;
        node.next = node.next.next;
        left = left.next;
        left.next = null;
      } else {
        node = node.next;
      }
    }
    left.next = removePseudoHead(pseudoRightHead);
    return removePseudoHead(pseudoLeftHead);
  }

  public static LinkedListNode partitionAddToHead(LinkedListNode node, int x) {
    LinkedListNode head = node;

    while (node.next != null) {
      if (node.next.data < x) {
        LinkedListNode tmp = node.next;
        node.next = node.next.next;
        tmp.next = head;
        head = tmp;
      } else {
        node = node.next;
      }
    }
    return head;
  }

  public static LinkedListNode partitionAddToHeadAndTail(LinkedListNode node, int x) {
    LinkedListNode head = node;
    LinkedListNode tail = node;

    while (node != null) {
      LinkedListNode next = node.next;
      if (node.data < x) {
        node.next = head;
        head = node;
      } else {
        tail.next = node;
        tail = tail.next;
      }
      node = next;
    }
    tail.next = null;
    return head;
  }

  private static LinkedListNode removePseudoHead(LinkedListNode pseudoHead) {
    LinkedListNode realHead = pseudoHead.next;
    pseudoHead.next = null;
    return realHead;
  }
}
