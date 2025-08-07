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
