package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0877StoneGame {}

class LC0877Solution {

  public boolean stoneGame(int[] piles) {
    int totalStones = Arrays.stream(piles).sum();
    int[][] aliceRecord = new int[piles.length][piles.length];
    int maxStone = stoneGame(piles, 0, piles.length - 1, totalStones, 0, true, aliceRecord);
    return maxStone > totalStones / 2;
  }

  private int stoneGame(
    int[] piles,
    int leftPile,
    int rightPile,
    int totalStones,
    int currentStones,
    boolean aliceTurn,
    int[][] aliceRecord
  ) {
    if (leftPile > rightPile) {
      return currentStones;
    }
    if (aliceTurn && aliceRecord[leftPile][rightPile] != 0) {
      return aliceRecord[leftPile][rightPile];
    }
    if (currentStones >= totalStones / 2) {
      aliceRecord[leftPile][rightPile] = currentStones;
    }

    if (aliceTurn) {
      int leftPiles = piles[leftPile];
      int leftStones = stoneGame(
        piles,
        leftPile + 1,
        rightPile,
        totalStones,
        currentStones + leftPiles,
        false,
        aliceRecord
      );

      int rightPiles = piles[rightPile];
      int rightStones = stoneGame(
        piles,
        leftPile,
        rightPile - 1,
        totalStones,
        currentStones + rightPiles,
        false,
        aliceRecord
      );
      aliceRecord[leftPile][rightPile] = Math.max(leftStones, rightStones);
      return aliceRecord[leftPile][rightPile];
    } else {
      int leftStones = stoneGame(
        piles,
        leftPile + 1,
        rightPile,
        totalStones,
        currentStones,
        true,
        aliceRecord
      );
      int rightStones = stoneGame(
        piles,
        leftPile,
        rightPile,
        totalStones,
        currentStones,
        true,
        aliceRecord
      );
      aliceRecord[leftPile][rightPile] = Math.max(leftStones, rightStones);
      return aliceRecord[leftPile][rightPile];
    }
  }
}
