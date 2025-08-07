package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0135Candy {}

class LC0135Solution {

  public int candy(int[] ratings) {
    int len = ratings.length;
    int[] candies = new int[len];
    Arrays.fill(candies, 1);
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        candies[i] = candies[i - 1] + 1;
      }
    }

    for (int i = len - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
      }
    }

    return Arrays.stream(candies).sum();
  }
}

class LC0135OnePassSolution {

  public int candy(int[] ratings) {
    int len = ratings.length;

    int candies = 0;
    int i = 0;
    int up = 0;
    int down = 0;
    while (i < len) {
      while (i + 1 < len && ratings[i] == ratings[i + 1]) {
        if ((i > 0 && ratings[i - 1] > ratings[i]) || isFlat(ratings, i)) {
          candies++;
        }
        i++;
      }
      while (i + 1 < len && ratings[i] < ratings[i + 1]) {
        up++;
        i++;
      }
      while (i + 1 < len && ratings[i] > ratings[i + 1]) {
        down++;
        i++;
      }
      if (up != 0 || down != 0) {
        candies += count(up) + Math.max(0, count(down) - 1) + Math.max(up, down) + 1;
      }
      up = 0;
      down = 0;
      if (i == len - 1) {
        if (len == 1 || ratings[len - 2] >= ratings[len - 1]) {
          candies++;
        }
        return candies;
      }
    }

    return candies;
  }

  private int count(int n) {
    return (n * (n + 1)) / 2;
  }

  private boolean isFlat(int[] ratings, int index) {
    boolean equalsToLeft = index == 0 || ratings[index - 1] == ratings[index];
    boolean equalsToRight = index == ratings.length - 1 || ratings[index] == ratings[index + 1];
    return equalsToLeft && equalsToRight;
  }
}
