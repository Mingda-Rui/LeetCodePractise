package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0846HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num: hand) {
            queue.add(num);
        }
        int current = 0;
        List<Integer> cache = new ArrayList<>();
        for (int i = 0; i < hand.length; i++) {
            if (i % groupSize == 0) {
                queue.addAll(cache);
                current = queue.poll();
                cache.clear();
            } else {
                while (!queue.isEmpty()) {
                    int next = queue.poll();
                    if (current + 1 == next) {
                        current = next;
                        break;
                    } else {
                        cache.add(next);
                    }
                }
                if (queue.isEmpty() && !cache.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}
