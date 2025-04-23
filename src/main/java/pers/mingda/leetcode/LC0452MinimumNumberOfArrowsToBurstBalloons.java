package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0452MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Queue<int[]> queue = new PriorityQueue<>((p1, p2) -> {
            if (p1[1] == p2[1]) {
                return 0;
            }
            return p1[1] > p2[1] ? 1 : -1;
        });
        queue.addAll(Arrays.asList(points));

        if (queue.isEmpty()) {
            return 0;
        }

        int count = 1;
        int prevEnd = queue.peek()[1];
        while (!queue.isEmpty()) {
            int[] currentP = queue.remove();
            int currentStart = currentP[0];
            if (prevEnd < currentStart) {
                count++;
                prevEnd = currentP[1];
            }
        }
        return count;
    }
}
