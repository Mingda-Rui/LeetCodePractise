package pers.mingda.leetcode;

public class LC0021MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode();
        ListNode head = list;
        while (list1 != null || list2 != null) {
            if (list1 != null && (list2 == null || list1.val < list2.val)) {
                list.next = list1;
                list1 = list1.next;
            } else if (list2 != null && (list1 == null || list1.val >= list2.val)) {
                list.next = list2;
                list2 = list2.next;
            }
            list = list.next;
        }

        return head.next;
    }
}
