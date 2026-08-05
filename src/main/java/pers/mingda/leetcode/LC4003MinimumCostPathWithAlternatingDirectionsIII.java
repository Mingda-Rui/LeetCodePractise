package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC4003MinimumCostPathWithAlternatingDirectionsIII {}

class LC4003Solution {
  public long minCost(int m, int n, int[][] penalty) {
    long[][][] dist = new long[m][n][2];

    PriorityQueue<Action> pq = new PriorityQueue<>(Comparator.comparingLong(Action::cost));
    Action start = new Action(0, 0, 1L, 0);
    pq.add(start);
    int[][] coordinates = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    while (!pq.isEmpty()) {
      Action prev = pq.remove();
      int prevM = prev.m();
      int prevN = prev.n();
      if (dist[prevM][prevN][prev.actionNum() % 2] != 0
          && prev.cost() >= dist[prevM][prevN][prev.actionNum() % 2]) {
        continue;
      }
      dist[prevM][prevN][prev.actionNum() % 2] = prev.cost();
      if (prevM == m - 1 && prevN == n - 1) {
        return prev.cost();
      }
      int nextActionNum = prev.actionNum() + 1;
      // wait
      long waitCost = prev.cost() + penalty[prevM][prevN];
      if (dist[prevM][prevN][nextActionNum % 2] == 0
          || waitCost < dist[prevM][prevN][nextActionNum % 2]) {
        Action next = new Action(prevM, prevN, waitCost, nextActionNum);
        pq.add(next);
      }

      // move
      for (int[] coordinate : coordinates) {
        int nextM = prev.m() + coordinate[0];
        int nextN = prev.n() + coordinate[1];
        if (nextM < 0 || nextM >= m || nextN < 0 || nextN >= n) {
          continue;
        }
        long nextCost =
            prev.cost()
                + entryCost(nextM, nextN)
                + (payPenalty(coordinate, nextActionNum) ? (long) penalty[prevM][prevN] : 0L);

        if (dist[nextM][nextN][nextActionNum % 2] == 0
            || nextCost < dist[nextM][nextN][nextActionNum % 2]) {
          Action next = new Action(nextM, nextN, nextCost, nextActionNum);
          pq.add(next);
        }
      }
    }
    return -1;
  }

  private long entryCost(int m, int n) {
    return (long) (m + 1) * (n + 1);
  }

  private boolean payPenalty(int[] coordinate, int actionNum) {
    boolean isLeft = coordinate[0] == 0 && coordinate[1] == -1;
    boolean isUp = coordinate[0] == -1 && coordinate[1] == 0;
    boolean isRight = coordinate[0] == 0 && coordinate[1] == 1;
    boolean isDown = coordinate[0] == 1 && coordinate[1] == 0;
    return !(actionNum % 2 == 0 && (isLeft || isUp))
        && !(actionNum % 2 == 1 && (isRight || isDown));
  }
}

record Action(int m, int n, long cost, int actionNum) {}
