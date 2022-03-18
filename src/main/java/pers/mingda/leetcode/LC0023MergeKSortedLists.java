package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

    public ListNode mergeKListsOneByOne(ListNode[] lists) {
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

    public ListNode mergeKListsSortVal(ListNode[] lists) {
        List<Integer> values = new ArrayList<>();
        for (ListNode node: lists) {
            while (node != null) {
                values.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(values);
        return generateListNode(values, 0);
    }

    private ListNode generateListNode(List<Integer> vals, int index) {
        if (vals.size() == index)
            return null;
        ListNode node = new ListNode(vals.get(index));
        node.next = generateListNode(vals, index + 1);
        return node;
    }

    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        Comparator<ListNode> comparator = (o1, o2) -> {return o1.val - o2.val;};
        Queue<ListNode> pQueue = new PriorityQueue<>(comparator);
        for (ListNode node: lists) {
            while (node != null) {
                pQueue.add(node);
                node = node.next;
            }
        }
        return generateListNode(pQueue);
    }

    private ListNode generateListNode(Queue<ListNode> pQueue) {
        if (pQueue.isEmpty())
            return null;
        ListNode node = pQueue.remove();
        node.next =  generateListNode(pQueue);
        return node;
    }
}
