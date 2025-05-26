package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0853CarFleet {
  public int carFleet(int target, int[] position, int[] speed) {
    int counter = 0;
    Comparator<Integer> comparator = Comparator.comparingInt(n -> position[n]);
    Queue<Integer> queue = new PriorityQueue<>(comparator.reversed());
    for (int i = 0; i < position.length; i++) queue.add(i);

    float maxTime = Integer.MIN_VALUE;
    while (!queue.isEmpty()) {
      int car = queue.poll();
      float remainDistance = target - position[car];
      float remainTime = remainDistance / speed[car];
      if (remainTime > maxTime) {
        counter++;
        maxTime = remainTime;
      }
    }

    return counter;
  }
}
