package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0567PermutationInString {

  public boolean checkInclusion(String s1, String s2) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s1.toCharArray()) {
      int val = map.getOrDefault(c, 0);
      map.put(c, val - 1);
    }

    int head = 0;
    int tail = 0;
    while (tail < s2.length()) {
      if (tail - head < s1.length()) {
        char c = s2.charAt(tail);
        tail++;
        int val = map.getOrDefault(c, 0);
        if (val == -1) map.remove(c);
        else map.put(c, val + 1);
      } else {
        char c = s2.charAt(head);
        head++;
        int val = map.getOrDefault(c, 0);
        if (val == 1) map.remove(c);
        else map.put(c, val - 1);
      }
      if (map.isEmpty()) return true;
    }
    return false;
  }

  public boolean checkInclusion2(String s1, String s2) {
    if (s1.isEmpty()) return true;
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s1.toCharArray()) {
      int count = map.getOrDefault(c, 0);
      map.put(c, count - 1);
    }

    int head = 0;
    int tail = 0;
    while (tail < s2.length()) {
      char tailC = s2.charAt(tail);
      tail++;
      int count = map.getOrDefault(tailC, 0);
      map.put(tailC, count + 1);
      while (map.get(tailC) > 0) {
        char headC = s2.charAt(head);
        head++;
        int headCount = map.getOrDefault(headC, 0) - 1;
        map.put(headC, headCount);
      }
      if (tail - head == s1.length()) return true;
    }

    return false;
  }
}
