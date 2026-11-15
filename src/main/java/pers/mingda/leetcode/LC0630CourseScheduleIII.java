package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC0630CourseScheduleIII {
}

class LC0930PriorityQueueSolution {
  public int scheduleCourse(int[][] courses) {
    // 1 2 3 4 5 6 7 8 9 10 days
    Arrays.sort(courses, Comparator.comparingInt(c -> c[1]));
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    int time = 0;
    for (int[] course : courses) {
      int duration = course[0];
      int deadline = course[1];
      if (time + duration <= deadline) {
        time += duration;
        pq.offer(duration);
      } else if (!pq.isEmpty() && pq.peek() > duration) {
        time += (duration - pq.poll());
        pq.offer(duration);
      }
    }
    return pq.size();
  }
}