package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0452MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Queue<int[]> queue = new PriorityQueue<>((p1, p2) -> {
            if(p1[1] == p2[1]) {
                return 0;
            }
            return p1[1] > p2[1] ? 1 : -1;
        });
        queue.addAll(Arrays.asList(points));

        int count = 0;
        while (!queue.isEmpty()) {
            int[] currentP = queue.remove();
            while (!queue.isEmpty() && currentP[1] >= queue.peek()[0]) {
                int[] p = queue.remove();
            }
            count++;
        }
        return count;
    }
}
