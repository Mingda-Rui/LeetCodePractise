package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LC1665MinimumInitialEnergyToFinishTasks {
}

class LC1665GreedyDifferenceIncreasingSolution {
  public int minimumEffort(int[][] tasks) {
    Arrays.sort(tasks, Comparator.comparingInt(t -> t[1] - t[0]));
    int ans = 0;
    for (int[] task : tasks) {
      ans = Math.max(ans + task[0], task[1]);
    }
    return ans;
  }
}

class LC1665GreedDifferenceDecreasingSolution {
  public int minimumEffort(int[][] tasks) {
    Arrays.sort(tasks, (t1, t2) -> (t2[1] - t2[0]) - (t1[1] - t1[0]));

    int total = 0;
    int remaining = 0;

    for (int[] task : tasks) {
      total += Math.max(0, task[1] - remaining);
      remaining = Math.max(remaining, task[1]) - task[0];
    }
    return total;
  }
}