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

class LC0767CountOnOddEvenSolution {

  public String reorganizeString(String s) {
    int[] letterCount = new int[26];
    int maxLetterCount = 0;
    int maxLetter = -1;
    for (char c : s.toCharArray()) {
      int intC = c - 'a';
      letterCount[intC]++;
      if (letterCount[intC] > maxLetterCount) {
        maxLetterCount = letterCount[intC];
        maxLetter = intC;
      }
    }
    if (maxLetterCount > (s.length() + 1) / 2) {
      return "";
    }

    char[] result = new char[s.length()];

    int index = 0;
    while (letterCount[maxLetter] != 0) {
      char c = (char) ('a' + maxLetter);
      result[index] = c;
      index += 2;
      letterCount[maxLetter]--;
    }

    for (int i = 0; i < letterCount.length; i++) {
      while (letterCount[i] != 0) {
        if (index >= s.length()) {
          index = 1;
        }
        char c = (char) ('a' + i);
        result[index] = c;
        index += 2;
        letterCount[i]--;
      }
    }

    return String.valueOf(result);
  }
}
