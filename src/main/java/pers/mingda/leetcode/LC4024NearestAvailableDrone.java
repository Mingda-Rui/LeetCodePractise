package pers.mingda.leetcode;

public class LC4024NearestAvailableDrone {}

class LC4024Solution {
  public int nearestDrone(int[][] drones, int[] target) {
    int minDist = Integer.MAX_VALUE;
    int result = -1;
    for (int i = 0; i < drones.length; i++) {
      int x = drones[i][0];
      int y = drones[i][1];
      int range = drones[i][2];
      int manhattanDist = Math.abs(x - target[0]) + Math.abs(y - target[1]);
      if (range >= manhattanDist && manhattanDist < minDist) {
        minDist = manhattanDist;
        result = i;
      }
    }
    return result;
  }
}
