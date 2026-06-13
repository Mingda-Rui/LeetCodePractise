package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0950RevealCardsInIncreasingOrder {
}

class LC0950Solution {
  public int[] deckRevealedIncreasing(int[] deck) {
    int len = deck.length;
    Arrays.sort(deck);
    int[] result = new int[len];
    int resultIndex = 0;
    boolean skip = false;
    int i = 0;
    while(i != len) {
      if (result[resultIndex] == 0) {
        if (!skip) {
          result[resultIndex] = deck[i];
          i++;
        }
        skip = !skip;
      }
      resultIndex = (resultIndex + 1) % len;
    }

    return result;
  }
}