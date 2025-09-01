package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC1086HighFive {

  class LC1086Solution {

    public int[][] highFive(int[][] items) {
      Map<Integer, Queue<Integer>> topFiveScores = new HashMap<>();
      for (int[] item : items) {
        int id = item[0];
        int score = item[1];
        topFiveScores.computeIfAbsent(id, i -> initQueue()).add(score);
        if (topFiveScores.get(id).size() > 5) {
          topFiveScores.get(id).remove();
        }
      }

      int[][] result = new int[topFiveScores.size()][2];
      int index = 0;
      for (int id : topFiveScores.keySet().stream().sorted().toList()) {
        result[index][0] = id;
        result[index][1] = getTopFiveAve(topFiveScores.get(id));
        index++;
      }
      return result;
    }

    private Queue<Integer> initQueue() {
      return new PriorityQueue<>();
    }

    private int getTopFiveAve(Queue<Integer> scores) {
      int sum = 0;
      for (int i = 0; i < 5; i++) {
        sum += scores.remove();
      }
      return sum / 5;
    }
  }
}
