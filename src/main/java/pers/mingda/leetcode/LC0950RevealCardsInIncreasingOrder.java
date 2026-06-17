package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC0950RevealCardsInIncreasingOrder {}

class LC0950Solution {
  public int[] deckRevealedIncreasing(int[] deck) {
    int len = deck.length;
    Arrays.sort(deck);
    int[] result = new int[len];
    int resultIndex = 0;
    boolean skip = false;
    int i = 0;
    while (i != len) {
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

class LC0950QueueSolution {
  public int[] deckRevealedIncreasing(int[] deck) {
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < deck.length; i++) {
      queue.add(i);
    }
    Arrays.sort(deck);
    int[] result = new int[deck.length];
    for (int card : deck) {
      int index = queue.remove();
      result[index] = card;
      if (!queue.isEmpty()) {
        queue.add(queue.poll());
      }
    }
    return result;
  }
}
