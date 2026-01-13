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

    int leftPiles = piles[leftPile];
    int leftStones = stoneGame(
      piles,
      leftPile + 1,
      rightPile,
      totalStones,
      aliceTurn ? currentStones + leftPiles : currentStones,
      !aliceTurn,
      aliceRecord
    );
    if (leftStones > totalStones / 2) {
      return leftStones;
    }
    int rightPiles = piles[rightPile];
    int rightStones = stoneGame(
      piles,
      leftPile,
      rightPile - 1,
      totalStones,
      aliceTurn ? currentStones + rightPiles : currentStones,
      !aliceTurn,
      aliceRecord
    );
    int maxStone = Math.max(leftStones, rightStones);
    if (aliceTurn) {
      aliceRecord[leftPile][rightPile] = maxStone;
    }
    return maxStone;
  }
}
