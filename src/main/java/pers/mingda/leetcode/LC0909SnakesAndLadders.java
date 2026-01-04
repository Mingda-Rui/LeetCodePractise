package pers.mingda.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC0909SnakesAndLadders {}

class LC090Solution {

  public int snakesAndLadders(int[][] board) {
    Queue<Integer> queue = new LinkedList<>();
    int endLabel = getLast(board);

    int round = 0;
    queue.add(1);

    Set<Integer> seenLabels = new HashSet<>();

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int label = queue.remove();
        if (seenLabels.contains(label)) {
          continue;
        }
        if (label >= endLabel) {
          return round;
        }

        seenLabels.add(label);

        for (int roll = 1; roll <= 6; roll++) {
          int nextLabel = jumpIfSnakeOrLadder(board, label + roll);
          queue.add(nextLabel);
        }
      }
      round++;
    }

    return -1;
  }

  private int jumpIfSnakeOrLadder(int[][] board, int current) {
    if (current >= getLast(board)) {
      return current;
    }
    int[] point = toPoint(board, current);
    int row = point[0];
    int col = point[1];
    int nextLabel = board[row][col];
    return nextLabel == -1 ? current : nextLabel;
  }

  private int getLast(int[][] board) {
    int n = board.length;
    return n * n;
  }

  private int[] toPoint(int[][] board, int label) {
    int n = board.length;
    int zeroBasedLabel = label - 1;
    int row = zeroBasedLabel / n;
    int remain = zeroBasedLabel % n;
    int col = row % 2 == 0 ? remain : n - 1 - remain;
    return new int[] { (n - 1) - row, col };
  }
}
