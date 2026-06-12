package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0950RevealCardsInIncreasingOrder {
}

class Solution {
  public int[] deckRevealedIncreasing(int[] deck) {
    int len = deck.length;
    Arrays.sort(deck);
    int[] result = new int[len];

    boolean[] seen = new boolean[len];
    int seenIndex = 0;

    boolean skip = false;
    int i = 0;
    while(i != len) {
      while (seen[seenIndex]) {
        seenIndex = (seenIndex + 1) % len;
      }
      if (!skip) {
        result[seenIndex] = deck[i];
        seen[seenIndex] = true;
        i++;
      }
      seenIndex = (seenIndex + 1) % len;
      skip = !skip;
    }

    return result;
  }
}