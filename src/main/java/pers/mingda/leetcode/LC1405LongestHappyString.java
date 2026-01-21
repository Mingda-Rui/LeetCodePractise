package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC1405LongestHappyString {}

class LC1405Solution {

  public String longestDiverseString(int a, int b, int c) {
    int[] count = { a, b, c };
    Comparator<Character> comparator = Comparator.<Character>comparingInt(ch -> count[ch - 'a']
    ).reversed();
    Queue<Character> queue = new PriorityQueue<>(comparator);
    for (char ch = 'a'; ch <= 'c'; ch++) {
      if (count[ch - 'a'] > 0) {
        queue.add(ch);
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      char first = queue.remove();
      int firstIndex = first - 'a';
      if (!isEqualToLastTwoChar(sb, first)) {
        sb.append(first);
        count[firstIndex]--;
        if (count[firstIndex] > 0) {
          queue.add(first);
        }
      } else if (!queue.isEmpty()) {
        char second = queue.remove();
        int secondIndex = second - 'a';
        sb.append(second);
        count[secondIndex]--;
        if (count[secondIndex] > 0) {
          queue.add(second);
        }
        queue.add(first);
      }
    }
    return sb.toString();
  }

  private boolean isEqualToLastTwoChar(StringBuilder sb, char ch) {
    int len = sb.length();
    if (len < 2) {
      return false;
    }
    return ch == sb.charAt(len - 1) && ch == sb.charAt(len - 2);
  }
}
