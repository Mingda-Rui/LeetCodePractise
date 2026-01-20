package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0767ReorganizeString {}

class LC0767Solution {

  public String reorganizeString(String s) {
    int[] letterCount = new int[26];
    int maxLetter = 0;
    for (char c : s.toCharArray()) {
      int intC = c - 'a';
      letterCount[intC]++;
      maxLetter = Math.max(letterCount[intC], maxLetter);
    }
    if (maxLetter > (s.length() + 1) / 2) {
      return "";
    }

    Comparator<Integer> comparator = Comparator.<Integer>comparingInt(i -> letterCount[i]
    ).reversed();
    Queue<Integer> queue = new PriorityQueue<>(comparator);
    for (int i = 0; i < letterCount.length; i++) {
      if (letterCount[i] > 0) {
        queue.add(i);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      int first = queue.remove();
      char firstL = (char) ('a' + first);
      letterCount[first]--;

      if (queue.isEmpty()) {
        sb.append(firstL);
        break;
      }

      int second = queue.remove();
      char secondL = (char) ('a' + second);
      letterCount[second]--;
      if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == firstL) {
        sb.append(secondL).append(firstL);
      } else {
        sb.append(firstL).append(secondL);
      }
      if (letterCount[first] > 0) {
        queue.add(first);
      }
      if (letterCount[second] > 0) {
        queue.add(second);
      }
    }

    return sb.toString();
  }
}
