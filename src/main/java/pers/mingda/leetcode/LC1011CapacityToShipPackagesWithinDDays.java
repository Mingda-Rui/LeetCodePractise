package pers.mingda.leetcode;

import java.util.Arrays;

public class LC1011CapacityToShipPackagesWithinDDays {}

class LC1011Solution {

  public int shipWithinDays(int[] weights, int days) {
    int sumWeight = Arrays.stream(weights).sum();
    int minWeight = sumWeight / days;
    for (int i = minWeight; i < sumWeight; i++) {
      if (canShipWithinDays(weights, i, days)) {
        return i;
      }
    }
    return minWeight;
  }

  private boolean canShipWithinDays(int[] weights, int capacity, int days) {
    int index = 0;
    while (days > 0) {
      int nextIndex = findBatch(weights, index, capacity);
      if (nextIndex == index) {
        return false;
      }
      if (nextIndex >= weights.length) {
        return true;
      }
      index = nextIndex;
      days--;
    }

    return false;
  }

  private int findBatch(int[] weights, int index, int capacity) {
    int load = 0;
    while (index < weights.length && load + weights[index] <= capacity) {
      load += weights[index];
      index++;
    }
    return index;
  }
}
