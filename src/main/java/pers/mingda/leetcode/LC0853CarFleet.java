package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0853CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int counter = 0;
        Comparator<Integer> comparator = Comparator.comparingInt(n -> position[n]);
        Queue<Integer> queue = new PriorityQueue<>(comparator.reversed());

        Map<Integer, Float> time = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            float remainLen = target - position[i];
            float remainTime = remainLen / speed[i];
            time.put(i, remainTime);
            queue.add(i);
        }
        float maxTime = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int car = queue.poll();
            float remainTime = time.get(car);
            if (remainTime > maxTime) {
                counter++;
                maxTime = remainTime;
            }
        }

        return counter;
    }
}
