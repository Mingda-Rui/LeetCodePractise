package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0023MergeKSortedLists {
    public ListNode mergeKListsBruteForce(ListNode[] lists) {
        int smallest = 0;
        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            if (curr != null && ( lists[smallest] == null || curr.val <= lists[smallest].val) )
                smallest = i;
        }

        if (lists.length == 0 || lists[smallest] == null)
            return null;
        ListNode smallestNode = lists[smallest];
        lists[smallest] = smallestNode.next;
        smallestNode.next = mergeKListsBruteForce(lists);
        return smallestNode;
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
        Comparator<ListNode> comparator = Comparator.comparingInt(o -> o.val);
        Queue<ListNode> pQueue = new PriorityQueue<>(comparator);
        for (ListNode node: lists)
            if (node != null)
                pQueue.add(node);

        return generateListNode(pQueue);
    }

    private ListNode generateListNode(Queue<ListNode> pQueue) {
        if (pQueue.isEmpty())
            return null;
        ListNode node = pQueue.remove();
        if (node.next != null)
            pQueue.add(node.next);
        node.next =  generateListNode(pQueue);
        return node;
    }

    public ListNode mergeKListsDivideAndConquer(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return mergeKListsDivideAndConquer(lists, 0, lists.length);
    }

    private ListNode mergeKListsDivideAndConquer(ListNode[] lists, int start, int end) {
        if (start + 1 == end)
            return lists[start];
        int mid = (start + end) / 2;
        ListNode left = mergeKListsDivideAndConquer(lists, start, mid);
        ListNode right = mergeKListsDivideAndConquer(lists, mid, end);

        return mergeTwoLists(left, right);
    }
}
