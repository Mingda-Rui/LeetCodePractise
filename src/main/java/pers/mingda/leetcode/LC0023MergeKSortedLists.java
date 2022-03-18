package pers.mingda.leetcode;

public class LC0023MergeKSortedLists {
    public ListNode mergeKListsBruteForce(ListNode[] lists) {
        ListNode smallest = null;
        int index = -1;
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            if (list != null && (smallest == null || smallest.val > list.val)) {
                index = i;
                smallest = list;
            }
        }
        if (smallest == null)
            return null;
        lists[index] = lists[index].next;
        smallest.next = mergeKListsBruteForce(lists);
        return smallest;
    }

    public ListNode mergeTwoLists(ListNode[] lists) {
        ListNode sorted = null;
        for (ListNode list: lists)
            sorted = mergeTwoLists(sorted, list);

        return sorted;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode small = list1.val < list2.val ? list1 : list2;
        ListNode larget = list1.val < list2.val ? list2 : list1;
        small.next = mergeTwoLists(small.next, larget);
        return small;
    }
}
