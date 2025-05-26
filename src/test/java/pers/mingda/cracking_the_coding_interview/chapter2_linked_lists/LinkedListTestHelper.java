package pers.mingda.cracking_the_coding_interview.chapter2_linked_lists;

import java.util.List;

public class LinkedListTestHelper {
  public LinkedListNode buildNodeList(List<Integer> nodeValues) {
    if (nodeValues.isEmpty()) {
      throw new IllegalArgumentException("Failed to crate linked list, no valid data provided");
    }
    LinkedListNode node = new LinkedListNode(null, nodeValues.get(0));
    LinkedListNode headNode = node;
    for (int i = 1; i < nodeValues.size(); i++) {
      node.next = new LinkedListNode(null, nodeValues.get(i));
      node = node.next;
    }
    return headNode;
  }

  public boolean equals(LinkedListNode node1, LinkedListNode node2) {
    while (node1 != null && node2 != null) {
      if (node1.data != node2.data) {
        return false;
      }
      node1 = node1.next;
      node2 = node2.next;
    }

    return node1 == null && node2 == null;
  }

  public int getSize(LinkedListNode node) {
    int size = 0;
    while (node != null) {
      size++;
      node = node.next;
    }
    return size;
  }
}
