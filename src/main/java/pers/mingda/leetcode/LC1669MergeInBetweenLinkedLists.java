package pers.mingda.leetcode;

public class LC1669MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode beforeANode = list1;
        for (int i = 0; i < a - 1; i++)
            beforeANode = beforeANode.next;

        ListNode bNode = beforeANode;
        for (int i = a - 1; i < b; i++)
            bNode = bNode.next;

        beforeANode.next = list2;
        while (list2.next != null)
            list2 = list2.next;
        list2.next = bNode.next;
        bNode.next = null;
        return list1;
    }
}
