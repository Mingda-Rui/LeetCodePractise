package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0295FindMedianFromDataStream {

}

class MedianFinder {
    private Queue<Integer> smallQueue;
    private Queue<Integer> bigQueue;

    public MedianFinder() {
        smallQueue = new PriorityQueue<>(Comparator.reverseOrder());
        bigQueue = new PriorityQueue<>(Comparator.naturalOrder());
    }

    public void addNum(int num) {
        if (bigQueue.isEmpty() || num < bigQueue.peek())
            smallQueue.offer(num);
        else
            bigQueue.offer(num);
        rebalance();
    }

    public double findMedian() {
        if (smallQueue.size() == bigQueue.size()) {
            double sum = smallQueue.peek() + bigQueue.peek();
            return sum / 2;
        }
        return smallQueue.peek();
    }

    private void rebalance() {
        int sizeDiff = smallQueue.size() - bigQueue.size();
        while (sizeDiff != 0 && sizeDiff != 1) {
            Queue<Integer> longer = sizeDiff > 0 ? smallQueue : bigQueue;
            Queue<Integer> shorter = sizeDiff > 0 ? bigQueue : smallQueue;
            int num = longer.poll();
            shorter.offer(num);
            sizeDiff = smallQueue.size() - bigQueue.size();
        }
    }
}
