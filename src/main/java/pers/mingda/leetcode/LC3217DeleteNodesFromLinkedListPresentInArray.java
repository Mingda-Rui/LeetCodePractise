package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LC3217DeleteNodesFromLinkedListPresentInArray {
}

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
  public ListNode modifiedList(int[] nums, ListNode head) {
    Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    ListNode prev = new ListNode();
    prev.next = head;
    head = prev;
    while (prev.next != null) {
      ListNode curr = prev.next;
      if (!set.contains(curr.val)) {
        prev = prev.next;
      } else {
        prev.next = curr.next;
      }
    }
    return head.next;
  }
}