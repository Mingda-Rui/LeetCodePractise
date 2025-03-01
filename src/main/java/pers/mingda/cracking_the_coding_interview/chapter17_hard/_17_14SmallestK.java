package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _17_14SmallestK {
    int[] smallestK(int[] array, int k) {
        Arrays.sort(array);
        return Arrays.copyOf(array, k);
    }

    int[] smallestKMaxHeap(int[] array, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : array) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}
