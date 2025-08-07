package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0135Candy {}

class LC0135Solution {

  public int candy(int[] ratings) {
    int[] candies = new int[ratings.length];
    int isFirstGoingUp = isFirstGoingUp(ratings);
    if (isFirstGoingUp == 0) {
      return ratings.length;
    }
    boolean isGoingUp = isFirstGoingUp == 1;
    isGoingUp = calculateCandy(ratings, candies, true, isGoingUp);
    calculateCandy(ratings, candies, false, isGoingUp);

    int sum = 0;
    for (int candy : candies) {
      sum += Math.max(candy, 1);
    }
    return sum;
  }

  private boolean calculateCandy(
    int[] ratings,
    int[] candies,
    boolean increaseOrder,
    boolean isGoingUp
  ) {
    int start = increaseOrder ? 0 : ratings.length - 1;
    int end = increaseOrder ? ratings.length - 1 : 0;
    int nextOffset = increaseOrder ? 1 : -1;

    int i = start;
    while (i != end + nextOffset) {
      int rating = ratings[i];
      int nextNeighbour = i + nextOffset;
      if (!isGoingUp) {
        boolean isLocalLowest = i == end || rating < ratings[nextNeighbour];
        if (isLocalLowest) {
          isGoingUp = true;
          candies[i] = 1;
        }
      } else {
        int prevNeighbor = i - nextOffset;
        if (i == start) {
          // ignore
        } else if (ratings[prevNeighbor] == rating) {
          candies[i] = Math.max(candies[i], 1);
        } else {
          candies[i] = Math.max(candies[i], candies[prevNeighbor] + 1);
        }

        boolean isLocalHighest = i == end || rating > ratings[nextNeighbour];
        if (isLocalHighest) {
          isGoingUp = false;
        }
      }
      i += nextOffset;
    }
    return isGoingUp;
  }

  private int isFirstGoingUp(int[] ratings) {
    int rating = ratings[0];
    for (int i = 1; i < ratings.length; i++) {
      if (rating < ratings[i]) {
        return -1;
      } else if (rating > ratings[i]) {
        return 1;
      }
    }
    return 0;
  }
}

class LC0135TwoArraySolution {

  public int candy(int[] ratings) {
    int len = ratings.length;
    int[] leftToRight = new int[ratings.length];
    int[] rightToLeft = new int[ratings.length];
    Arrays.fill(leftToRight, 1);
    Arrays.fill(rightToLeft, 1);

    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        leftToRight[i] = leftToRight[i - 1] + 1;
      }
    }

    for (int i = len - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        rightToLeft[i] = rightToLeft[i + 1] + 1;
      }
    }

    int sum = 0;
    for (int i = 0; i < len; i++) {
      sum += Math.max(leftToRight[i], rightToLeft[i]);
    }
    return sum;
  }
}
