package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC0346MovingAverageFromDataStream {}

class MovingAverage {
  Queue<Integer> queue;
  int size;
  double sum;

  public MovingAverage(int size) {
    this.queue = new LinkedList<>();
    this.size = size;
    this.sum = 0;
  }

  public double next(int val) {
    if (queue.size() == size) {
      int excess = queue.poll();
      sum -= excess;
    }
    queue.offer(val);
    sum += val;
    return sum / queue.size();
  }
}

class MovingAverageArraySolution {
  int[] queue;
  int size;
  int counter;
  int pointer;
  double sum;

  public MovingAverageArraySolution(int size) {
    this.queue = new int[size];
    this.size = size;
    this.counter = 0;
    this.sum = 0;
    this.pointer = 0;
  }

  public double next(int val) {
    if (counter >= size) {
      sum -= queue[pointer];
    }
    counter++;
    queue[pointer] = val;
    sum += val;
    pointer = (pointer + 1) % size;
    return sum / Math.min(counter, size);
  }
}
