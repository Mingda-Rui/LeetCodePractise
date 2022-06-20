package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC1046LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone: stones)
            queue.add(stone);

        while (queue.size() > 1) {
            int stone1 = queue.remove();
            int stone2 = queue.remove();
            if (stone1 != stone2)
                queue.add(Math.abs(stone1 - stone2));
        }
        return queue.isEmpty() ? 0 : queue.remove();
    }
}
