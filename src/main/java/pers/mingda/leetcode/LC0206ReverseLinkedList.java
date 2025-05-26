package pers.mingda.leetcode;

public class LC0206ReverseLinkedList {

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode tempHead = new ListNode();
    while (head.next != null) {
      ListNode currentNext = head.next;
      if (tempHead.next != null) {
        head.next = tempHead.next;
        tempHead.next = head;
      } else {
        tempHead.next = head;
        head.next = null;
      }
      head = currentNext;
    }
    head.next = tempHead.next;
    tempHead.next = head;

    return tempHead.next;
  }

  public ListNode reverseList_refactor(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode tempHead = new ListNode(0, head);
    ListNode newTail = head;

    while (head != null) {
      ListNode currentNext = head.next;
      head.next = tempHead.next;
      tempHead.next = head;
      head = currentNext;
    }

    newTail.next = null;
    return tempHead.next;
  }

  public ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    while (null != head.next) {
      ListNode next = head.next;
      head.next = next.next;
      next.next = dummy.next;
      dummy.next = next;
    }
    return dummy.next;
  }

  public ListNode reverseList_refactor_v3(ListNode head) {
    if (head == null || head.next == null) return head;
    int length = 0;
    ListNode newTail = head;
    ListNode newHead = head;
    do {
      newHead = newHead.next;
      length++;
    } while (newHead.next != null);
    newHead.next = head;

    for (int i = 0; i < length; i++) {
      ListNode currentNext = head.next;
      head.next = newHead.next;
      newHead.next = head;
      head = currentNext;
    }
    newTail.next = null;
    return newHead;
  }

  public ListNode reverseList_recursive(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode next = head.next;
    ListNode newHead = reverseList_recursive(next);
    next.next = head;
    head.next = null;
    return newHead;
  }

  public static void main(String... args) {
    LC0206ReverseLinkedList test = new LC0206ReverseLinkedList();
    ListNode five = new ListNode(5);
    ListNode four = new ListNode(4, five);
    ListNode three = new ListNode(3, four);
    ListNode two = new ListNode(2, three);
    ListNode one = new ListNode(1, two);
    test.reverseList_recursive(one);
  }

  public ListNode reverseListLatest(ListNode head) {
    ListNode pseudoHead = new ListNode();
    ListNode tail = reverseListRecursive(head, pseudoHead);
    tail.next = null;
    ListNode newHead = pseudoHead.next;
    pseudoHead.next = null;
    return newHead;
  }

  private ListNode reverseListRecursive(ListNode head, ListNode pseudoHead) {
    if (head == null) return pseudoHead;

    ListNode parent = reverseListRecursive(head.next, pseudoHead);
    parent.next = head;
    return head;
  }

  public ListNode reverseListIterative(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode oldHead = head;
    ListNode tail = head;
    while (tail != null) {
      ListNode tmp = tail;
      tail = tail.next;
      tmp.next = head;
      head = tmp;
    }
    oldHead.next = null;
    return head;
  }

  public ListNode reverseListRecursiveNoPseudoHead(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode newHead = reverseListRecursiveNoPseudoHead(head.next);
    ListNode next = head.next;
    next.next = head;
    head.next = null;
    return newHead;
  }

  public ListNode reverseListInPlaceRecursive(ListNode head) {
    return reverseListInPlaceRecursive(head, head);
  }

  private ListNode reverseListInPlaceRecursive(ListNode head, ListNode tail) {
    if (head == null || tail.next == null) return head;
    ListNode next = tail.next;
    tail.next = next.next;
    next.next = head;
    head = next;
    return reverseListInPlaceRecursive(head, tail);
  }

  public ListNode reverseListInPlaceRecursive2(ListNode head) {
    return reverseListInPlaceRecursive2(head, null);
  }

  private ListNode reverseListInPlaceRecursive2(
    ListNode current,
    ListNode newHead
  ) {
    if (current == null) return newHead;
    ListNode next = current.next;
    current.next = newHead;
    return reverseListInPlaceRecursive2(next, current);
  }
}
