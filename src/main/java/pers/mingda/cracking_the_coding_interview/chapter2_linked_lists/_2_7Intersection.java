package pers.mingda.cracking_the_coding_interview.chapter2_linked_lists;

/**
 * 2.7 Intersection: Given two (singly) linked lists, determine if the two list intersect. Return
 * the intersecting node. Note that the intersection is defined based on reference, not value. That
 * is, if the kth node of the first linked list is the exact same node (by reference) as the jth
 * node of the second linked list, then they are intersecting.
 */
public class _2_7Intersection {

  public static LinkedListNode findIntersection(
    LinkedListNode list1,
    LinkedListNode list2
  ) {
    LinkedListNode pointer1 = list1;
    LinkedListNode pointer2 = list2;
    boolean pointer1Flipped = false;
    boolean pointer2Flipped = false;
    while (pointer1 != null && pointer2 != null) {
      if (pointer1 == pointer2) return pointer1;

      pointer1 = pointer1.next;
      pointer2 = pointer2.next;
      if (pointer1 == null && !pointer1Flipped) {
        pointer1 = list2;
        pointer1Flipped = true;
      }
      if (pointer2 == null && !pointer2Flipped) {
        pointer2 = list1;
        pointer2Flipped = true;
      }
    }

    return null;
  }

  public static LinkedListNode findIntersectionChopOff(
    LinkedListNode list1,
    LinkedListNode list2
  ) {
    int l1Size = getSize(list1);
    int l2Size = getSize(list2);

    list1 = (l1Size > l2Size) ? getKthNode(list1, l1Size - l2Size) : list1;
    list2 = (l2Size > l1Size) ? getKthNode(list2, l2Size - l1Size) : list2;

    while (list1 != list2) {
      list1 = list1.next;
      list2 = list2.next;
    }
    return list1;
  }

  private static int getSize(LinkedListNode node) {
    int size = 0;
    while (node != null) {
      size++;
      node = node.next;
    }
    return size;
  }

  private static LinkedListNode getKthNode(LinkedListNode node, int k) {
    LinkedListNode kth = node;
    while (k > 0) {
      kth = kth.next;
      k--;
    }
    return kth;
  }
}
