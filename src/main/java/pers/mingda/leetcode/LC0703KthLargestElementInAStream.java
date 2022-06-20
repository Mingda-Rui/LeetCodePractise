package pers.mingda.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class LC0703KthLargestElementInAStream {

}

class KthLargest {

    Queue<Integer> queue;
    int kth;

    public KthLargest(int k, int[] nums) {
        this.kth = k;
        this.queue = new PriorityQueue<>();
        IntStream.of(nums).forEach(queue::add);
        while (queue.size() > k)
            queue.remove();
    }

    public int add(int val) {
        queue.add(val);
        while (queue.size() > kth)
            queue.remove();
        return queue.element();
    }
}
