package pers.mingda.leetcode;

public class LC0023MergeKSortedLists {
    public ListNode mergeKListsBruteForce(ListNode[] lists) {
        ListNode smallest = new ListNode(Integer.MAX_VALUE);
        int index = -1;
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            if (list != null && smallest.val > list.val) {
                index = i;
                smallest = list;
            }
        }
        if (index == -1)
            return null;
        lists[index] = lists[index].next;
        smallest.next = mergeKListsBruteForce(lists);
        return smallest;
    }
}
