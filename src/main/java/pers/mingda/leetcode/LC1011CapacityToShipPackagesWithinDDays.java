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
    int todayWeights = 0;
    for (int i = 0; i < weights.length; i++) {
      if (days == 0 || weights[i] > capacity) {
        return false;
      }
      if (todayWeights + weights[i] < capacity) {
        todayWeights += weights[i];
      } else if (todayWeights + weights[i] > capacity) {
        days--;
        todayWeights = weights[i];
      } else {
        days--;
        todayWeights = 0;
      }

      if (i == weights.length - 1 && days == 0 && todayWeights != 0) {
        return false;
      }
    }
    return true;
  }
}
