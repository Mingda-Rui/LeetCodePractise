package pers.mingda.leetcode;

import java.util.Arrays;

public class LC1011CapacityToShipPackagesWithinDDays {}

class LC1011Solution {

  public int shipWithinDays(int[] weights, int days) {
    int maxWeight = Arrays.stream(weights).sum();
    int minWeight = maxWeight / days;
    while (minWeight < maxWeight) {
      int mid = (minWeight + maxWeight) / 2;
      if (canShipWithinDays(weights, mid, days)) {
        maxWeight = mid;
      } else {
        minWeight = mid + 1;
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
