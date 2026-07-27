package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC4001AggregateTwoTimeSeries {}

class LC4001Solution {
  public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
    int p1 = series1.length - 1;
    int p2 = series2.length - 1;

    int v1 = 0;
    int v2 = 0;

    List<List<Integer>> result = new LinkedList<>();
    while (p1 >= 0 || p2 >= 0) {
      int nextTs = 0;

      int prevP1 = p1;
      int prevP2 = p2;
      boolean bothSeriesNonExhausted = prevP1 >= 0 && prevP2 >= 0;

      if (prevP2 < 0 || (bothSeriesNonExhausted && series1[prevP1][0] >= series2[prevP2][0])) {
        nextTs = series1[prevP1][0];
        v1 = series1[prevP1][1];
        p1--;
      }
      if (prevP1 < 0 || (bothSeriesNonExhausted && series2[prevP2][0] >= series1[prevP1][0])) {
        nextTs = series2[prevP2][0];
        v2 = series2[prevP2][1];
        p2--;
      }
      List<Integer> nextTsVal = new ArrayList<>();
      nextTsVal.add(nextTs);
      nextTsVal.add(v1 + v2);
      result.addFirst(nextTsVal);
    }

    return result;
  }
}
