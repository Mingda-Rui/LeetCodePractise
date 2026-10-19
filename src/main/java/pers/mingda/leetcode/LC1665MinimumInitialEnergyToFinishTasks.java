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