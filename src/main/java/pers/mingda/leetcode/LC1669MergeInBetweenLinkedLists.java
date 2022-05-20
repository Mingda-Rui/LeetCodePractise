package pers.mingda.leetcode;

public class LC1669MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int counter = 0;
        ListNode ite = list1;
        while (ite != null) {
            if (counter + 1 == a) {
                ListNode aNode = ite.next;
                ite.next = list2;
                ite = aNode;
            } else if (counter == b) {
                while (list2 != null && list2.next != null)
                    list2 = list2.next;
                list2.next = ite.next;
                ite.next = null;
                return list1;
            } else
                ite = ite.next;
            counter++;
        }
        return list1;
    }
}
