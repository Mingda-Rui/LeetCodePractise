package pers.mingda.leetcode;

public class LC0019RemoveNthNodeFromEndOfList {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode OneBeforeHead = new ListNode();
    OneBeforeHead.next = head;
    ListNode fast = head;
    ListNode slow = OneBeforeHead;

    for (int i = 0; i < n; i++) fast = fast.next;
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return OneBeforeHead.next;
  }

  public ListNode removeNthFromEndIterativeNoPseudoHead(ListNode head, int n) {
    ListNode fast = head;
    ListNode slow = head;

    for (int i = 0; i < n; i++) fast = fast.next;
    // when fast is null, meaning we need to remove the first node
    if (fast == null) return head.next;
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return head;
  }

  public ListNode removeNthFromEndRecursive(ListNode head, int n) {
    int count = removeNthFromEndHelper(head, n);
    head = count == n ? head.next : head;
    return head;
  }

  private int removeNthFromEndHelper(ListNode head, int n) {
    if (head == null) return 0;
    int count = removeNthFromEndHelper(head.next, n);
    if (count == n) head.next = head.next.next;
    return count + 1;
  }
}
