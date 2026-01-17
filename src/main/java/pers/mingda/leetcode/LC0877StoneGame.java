package pers.mingda.leetcode;

public class LC0877StoneGame {}

class LC0877Solution {

  public boolean stoneGame(int[] piles) {
    int[][] record = new int[piles.length][piles.length];
    return stoneGame(piles, 0, piles.length - 1, record) > 0;
  }

  private int stoneGame(int[] piles, int leftPile, int rightPile, int[][] record) {
    boolean isAlice = (rightPile - leftPile) % 2 == 1;
    if (leftPile == rightPile) {
      return isAlice ? piles[leftPile] : -piles[leftPile];
    }
    if (record[leftPile][rightPile] != 0) {
      return record[leftPile][rightPile];
    }

    int leftStones = stoneGame(piles, leftPile + 1, rightPile, record);
    int rightStones = stoneGame(piles, leftPile, rightPile - 1, record);

    if (isAlice) {
      record[leftPile][rightPile] = Math.max(
        piles[leftPile] + leftStones,
        piles[rightPile] + rightStones
      );
    } else {
      record[leftPile][rightPile] = Math.min(
        -piles[leftPile] + leftStones,
        -piles[rightPile] + rightStones
      );
    }

    return record[leftPile][rightPile];
  }
}

class LC0877IterativeSolution {

  public boolean stoneGame(int[] piles) {
    int[][] record = new int[piles.length][piles.length];
    for (int remainedPiles = 1; remainedPiles <= piles.length; remainedPiles++) {
      for (int leftPile = 0; leftPile <= piles.length - remainedPiles; leftPile++) {
        int rightPile = leftPile + remainedPiles - 1;
        boolean isAlice = (piles.length - remainedPiles) % 2 == 0;

        if (isAlice) {
          int leftPick = piles[leftPile] + record[leftPile + 1][rightPile];
          int rightPick = piles[rightPile] + record[leftPile][rightPile - 1];
          int max = Math.max(leftPick, rightPick);
          record[leftPile][rightPile] = max;
        } else {
          int leftPick =
            -piles[leftPile] + (leftPile == rightPile ? 0 : record[leftPile + 1][rightPile]);
          int rightPick =
            -piles[rightPile] + (leftPile == rightPile ? 0 : record[leftPile][rightPile - 1]);
          int max = Math.min(leftPick, rightPick);
          record[leftPile][rightPile] = max;
        }
      }
    }

    return record[0][piles.length - 1] > 0;
  }
}
