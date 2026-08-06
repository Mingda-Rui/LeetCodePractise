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
    int taskIndex = 0;
    int currTaskWorked = 0;
    for (int i = 0; i < shifts.length; i++) {
      int shift = shifts[i];

      long target = (taskIndex - 1 >= 0 ? taskSum[taskIndex - 1] : 0) + currTaskWorked + shift;
      taskIndex = doShift(taskSum, taskIndex, target);

      if (taskIndex == tasks.length || target == taskSum[taskIndex]) {
        currTaskWorked = 0;
      } else {
        int leftOver = (int) (taskSum[taskIndex] - target);
        currTaskWorked = tasks[taskIndex] - leftOver;
      }
      count[i] = tasks.length - taskIndex;

      if (taskIndex == tasks.length) {
        taskIndex = 0;
      }
    }
    return count;
  }

  private int doShift(long[] taskSum, int taskIndex, long target) {
    int start = taskIndex;
    int end = taskSum.length;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (taskSum[mid] == target) {
        end = mid + 1;
        return end;
      } else if (taskSum[mid] < target) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    return end;
  }
}
