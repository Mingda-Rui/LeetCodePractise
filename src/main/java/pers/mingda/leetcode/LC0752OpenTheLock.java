package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class LC0752OpenTheLock {
}

class LC0752Solution {
  public int openLock(String[] deadEnds, String target) {
    Set<String> deadendSet = Arrays.stream(deadEnds).collect(Collectors.toSet());
    Set<String> seen = new HashSet<>();

    Queue<String> queue = new LinkedList<>();
    queue.add("0000");

    int count = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String current = queue.remove();
        if (current.equals(target)) {
          return count;
        }
        if (seen.contains(current) || deadendSet.contains(current)) {
          continue;
        }
        seen.add(current);
        for (int pos = 0; pos < 4; pos++) {
          queue.add(dial(current, pos, true));
          queue.add(dial(current, pos, false));
        }
      }
      count++;
    }
    return -1;
  }

  private String dial(String current, int pos, boolean increase) {
    int num = current.charAt(pos) - '0';
    int dialedNum = (num +  10 + (increase ? 1 : -1)) % 10;
    return current.substring(0, pos) + Integer.toString(dialedNum) + current.substring(pos + 1);
  }
}