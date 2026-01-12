package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0149MaxPointsOnALine {}

class LC0149Solution {

  public int maxPoints(int[][] points) {
    int max = 0;
    for (int i = 0; i < points.length; i++) {
      Map<Double, Integer> cnt = new HashMap<>();
      for (int j = 0; j < points.length; j++) {
        if (i == j) {
          continue;
        }
        double atan = atans(points[i], points[j]);
        int count = cnt.getOrDefault(atan, 0) + 1;
        cnt.put(atan, count);
        max = Math.max(max, count);
      }
    }
    return max + 1;
  }

  private double atans(int[] point1, int[] point2) {
    return Math.atan2(point1[1] - point2[1], point1[0] - point2[0]);
  }
}
