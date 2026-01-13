package pers.mingda.leetcode;

public class LC0877StoneGame {}

class LC0877Solution {

  public boolean stoneGame(int[] piles) {
    int[][] record = new int[piles.length][piles.length];
    int maxStone = stoneGame(piles, 0, piles.length - 1, 0, record);
    return maxStone > 0;
  }

  private int stoneGame(
    int[] piles,
    int leftPile,
    int rightPile,
    int currentStones,
    int[][] record
  ) {
    if (leftPile > rightPile) {
      return currentStones;
    }
    if (record[leftPile][rightPile] != 0) {
      return record[leftPile][rightPile];
    }

    boolean isAlice = (rightPile - leftPile) % 2 == 0;
    int leftPiles = piles[leftPile];
    int leftStones = stoneGame(
      piles,
      leftPile + 1,
      rightPile,
      isAlice ? currentStones + leftPiles : currentStones - leftPiles,
      record
    );

    int rightPiles = piles[rightPile];
    int rightStones = stoneGame(
      piles,
      leftPile,
      rightPile - 1,
      isAlice ? currentStones + rightPiles : currentStones - rightPiles,
      record
    );
    int maxStone = Math.max(leftStones, rightStones);
    record[leftPile][rightPile] = maxStone;
    return maxStone;
  }
}
