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

class LC1405GreedySolution {

  public String longestDiverseString(int a, int b, int c) {
    int consecutiveA = 0;
    int consecutiveB = 0;
    int consecutiveC = 0;
    int maxLen = a + b + c;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < maxLen; i++) {
      if (
        (a >= b && a >= c && consecutiveA < 2) ||
        (a > 0 && (consecutiveB == 2 || consecutiveC == 2))
      ) {
        sb.append('a');
        a--;
        consecutiveA++;
        consecutiveB = 0;
        consecutiveC = 0;
      } else if (
        (b >= a && b >= c && consecutiveB < 2) ||
        (b > 0 && (consecutiveA == 2 || consecutiveC == 2))
      ) {
        sb.append('b');
        b--;
        consecutiveB++;
        consecutiveA = 0;
        consecutiveC = 0;
      } else if (
        (c >= a && c >= b && consecutiveC < 2) ||
        (c > 0 && (consecutiveA == 2 || consecutiveB == 2))
      ) {
        sb.append('c');
        c--;
        consecutiveC++;
        consecutiveA = 0;
        consecutiveB = 0;
      } else {
        return sb.toString();
      }
    }
    return sb.toString();
  }
}
