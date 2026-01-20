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

    char[] result = new char[s.length()];
    int evenIndex = 0;
    int l = queue.remove();
    while (evenIndex < s.length()) {
      char c = (char) ('a' + l);
      while (letterCount[l] != 0 && evenIndex < s.length()) {
        result[evenIndex] = c;
        evenIndex += 2;
        letterCount[l]--;
      }
      if (!queue.isEmpty() && letterCount[l] == 0) {
        l = queue.remove();
      }
    }

    int oddIndex = 1;
    while (oddIndex < s.length()) {
      char c = (char) ('a' + l);
      while (letterCount[l] != 0) {
        result[oddIndex] = c;
        oddIndex += 2;
        letterCount[l]--;
      }
      if (!queue.isEmpty()) {
        l = queue.remove();
      }
    }
    return new String(result);
  }
}
