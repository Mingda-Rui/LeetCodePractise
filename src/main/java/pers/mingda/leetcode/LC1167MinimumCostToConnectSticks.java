package pers.mingda.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC1167MinimumCostToConnectSticks {
}

class LC1167Solution {
    public int connectSticks(int[] sticks) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int stick : sticks) {
            queue.add(stick);
        }

        int cost = 0;
        while (!queue.isEmpty()) {
            int firstStick = queue.remove();
            if (queue.isEmpty()) {
                return cost;
            }
            int secondStick = queue.remove();
            cost += (firstStick + secondStick);
            queue.add(firstStick + secondStick);
        }
        return cost;
    }
}
