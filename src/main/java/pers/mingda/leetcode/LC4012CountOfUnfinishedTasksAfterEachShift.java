package pers.mingda.leetcode;

public class LC4012CountOfUnfinishedTasksAfterEachShift {}

class LC4012Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
      long[] taskSum = new long[tasks.length];
      taskSum[0] = tasks[0];
      for (int i = 1; i < tasks.length; i++) {
        taskSum[i] = taskSum[i - 1] + (long)tasks[i];
      }
      long totalTasks = taskSum[taskSum.length - 1];

      int[] count = new int[shifts.length];
      long taskFinished = 0;
      for (int i = 0; i < shifts.length; i++) {
        int shift = shifts[i];
        taskFinished += shift;
        if (taskFinished >= totalTasks) {
          taskFinished = 0;
          count[i] = 0;
        } else {
          int nextIndex = doShift(taskSum, taskFinished);
          count[i] = tasks.length - nextIndex;
        }
      }
      return count;
    }

    private int doShift(long[] taskSum, long target) {
      int start = 0;
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