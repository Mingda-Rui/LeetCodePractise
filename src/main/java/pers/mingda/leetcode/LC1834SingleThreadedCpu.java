package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC1834SingleThreadedCpu {}

class LC1834Solution {

  public int[] getOrder(int[][] tasks) {
    Comparator<Task> taskComparator = Comparator.comparingInt(Task::enqueueTime);
    Queue<Task> queue = new PriorityQueue<>(taskComparator);
    for (int i = 0; i < tasks.length; i++) {
      Task t = new Task(i, tasks[i][0], tasks[i][1]);
      queue.add(t);
    }

    Comparator<Task> taskQueueComparator = (t1, t2) ->
      t1.processingTime() == t2.processingTime()
        ? Integer.compare(t1.id(), t2.id())
        : Integer.compare(t1.processingTime(), t2.processingTime());
    Queue<Task> availableTasks = new PriorityQueue<>(taskQueueComparator);

    int[] result = new int[tasks.length];
    if (queue.isEmpty()) {
      return result;
    }
    int ts = queue.peek().enqueueTime();
    int index = 0;
    while (!queue.isEmpty() || !availableTasks.isEmpty()) {
      while (!queue.isEmpty() && queue.peek().enqueueTime() <= ts) {
        availableTasks.add(queue.remove());
      }

      if (availableTasks.isEmpty() && !queue.isEmpty()) {
        ts = queue.peek().enqueueTime();
      } else {
        Task nextTask = availableTasks.remove();
        ts += nextTask.processingTime();
        result[index] = nextTask.id();
        index++;
      }
    }
    return result;
  }
}

record Task(int id, int enqueueTime, int processingTime) {}
