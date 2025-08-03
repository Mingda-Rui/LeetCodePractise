package pers.mingda.leetcode;

public class LC0148SortList {}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode mid = cutHalf(head);
    return merge(sortList(head), sortList(mid));
  }

  private ListNode cutHalf(ListNode head) {
    ListNode slow = null;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow == null ? head : slow.next;
      fast = fast.next.next;
    }

    ListNode mid = slow.next;
    slow.next = null;
    return mid;
  }

  private ListNode merge(ListNode list1, ListNode list2) {
    ListNode dummyHead = new ListNode();
    ListNode result = dummyHead;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        result.next = list1;
        list1 = list1.next;
      } else {
        result.next = list2;
        list2 = list2.next;
      }
      result = result.next;
    }
    result.next = list1 != null ? list1 : list2;
    ListNode merged = dummyHead.next;
    dummyHead.next = null;
    return merged;
  }
}

class InPlaceSortingSolution {

  public ListNode sortList(ListNode head) {
    int totalLen = countNodes(head);
    ListNode newHead = head;
    for (int currentLen = 1; currentLen < totalLen; currentLen *= 2) {
      ListNode prev = null;
      ListNode pointer = newHead;
      while (pointer != null) {
        ListNode result = sortTwoSubList(prev, pointer, currentLen);
        if (prev == null) {
          newHead = result;
          prev = jumpTo(newHead, currentLen * 2 - 1);
        } else {
          prev = jumpTo(prev, currentLen * 2);
        }
        pointer = prev == null ? null : prev.next;
      }
    }
    return newHead;
  }

  private ListNode sortTwoSubList(ListNode prev, ListNode head, int len) {
    ListNode rightHead = head;

    int leftLen = 0;
    while (leftLen != len && rightHead != null) {
      leftLen++;
      rightHead = rightHead.next;
    }

    int rightLen = 0;
    ListNode pointer = rightHead;
    while (rightLen != len && pointer != null) {
      rightLen++;
      pointer = pointer.next;
    }

    return merge(prev, head, rightHead, leftLen, rightLen);
  }

  private ListNode merge(
    ListNode prevTail,
    ListNode leftHead,
    ListNode rightHead,
    int leftLen,
    int rightLen
  ) {
    if (rightLen == 0) {
      return leftHead;
    }
    ListNode sorted = null;
    ListNode remainHead = jumpTo(rightHead, rightLen);
    int totalLen = leftLen + rightLen;
    while (leftLen != 0 && rightLen != 0) {
      ListNode next = leftHead.val < rightHead.val ? leftHead : rightHead;
      if (totalLen == leftLen + rightLen) {
        sorted = next;
      }
      if (prevTail != null) {
        prevTail.next = next;
      }
      prevTail = next;
      if (leftHead.val < rightHead.val) {
        leftLen--;
        leftHead = leftHead.next;
      } else {
        rightLen--;
        rightHead = rightHead.next;
      }
    }

    ListNode next = leftLen == 0 ? rightHead : leftHead;
    int nextLen = leftLen == 0 ? rightLen : leftLen;
    while (nextLen != 0) {
      prevTail.next = next;
      prevTail = next;
      nextLen--;
      if (nextLen == 0) {
        next.next = remainHead;
      } else {
        next = next.next;
      }
    }

    return sorted;
  }

  private ListNode jumpTo(ListNode start, int distance) {
    while (distance != 0 && start != null) {
      start = start.next;
      distance--;
    }
    return start;
  }

  private int countNodes(ListNode head) {
    int count = 0;
    while (head != null) {
      count++;
      head = head.next;
    }
    return count;
  }
}
