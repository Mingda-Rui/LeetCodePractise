package pers.mingda.leetcode;

public class LC4012CountOfUnfinishedTasksAfterEachShift {}

class LC4012Solution {
  public int[] countTasks(int[] tasks, int[] shifts) {
    long[] taskSum = new long[tasks.length];
    taskSum[0] = tasks[0];
    for (int i = 1; i < tasks.length; i++) {
      taskSum[i] = taskSum[i - 1] + (long) tasks[i];
    }
    int[] count = new int[shifts.length];
    int startTask = 0;
    int leftOver = 0;
    for (int i = 0; i < shifts.length; i++) {
      int shift = shifts[i];
      if (shift < leftOver) {
        leftOver -= shift;
        count[i] = count[i - 1];
      } else if (shift == leftOver) {
        leftOver -= shift;
        startTask++;
        count[i] = count[i - 1] - 1;
      } else {
        int prevTaskFinished = leftOver == 0 ? 0 : tasks[startTask] - leftOver;
        int[] shiftResult = doShift(taskSum, startTask, prevTaskFinished, shift);

        int nextTask = shiftResult[0];
        leftOver = shiftResult[1];
        int prevCount = i - 1 >= 0 ? count[i - 1] : 0;
        count[i] = tasks.length - nextTask;
        startTask = nextTask;
      }
      if (startTask == tasks.length) {
        startTask = 0;
        leftOver = 0;
      }
    }
    return count;
  }

  private int[] doShift(long[] taskSum, int startTask, int prevTaskFinished, int shift) {
    long target = (startTask - 1 >= 0 ? taskSum[startTask - 1] : 0) + shift + prevTaskFinished;
    int start = startTask;
    int end = taskSum.length;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (taskSum[mid] == target) {
        end = mid + 1;
        return new int[] {end, 0};
      } else if (taskSum[mid] < target) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    int leftOver = (end == taskSum.length ? 0 : (int) (taskSum[end] - target));
    return new int[] {end, leftOver};
  }
}
