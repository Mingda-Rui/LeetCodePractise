package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0383RansomNote {}

class LC0383Solution {

  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> letters = new HashMap<>();
    for (char l : magazine.toCharArray()) {
      int count = letters.getOrDefault(l, 0);
      letters.put(l, count + 1);
    }

    for (char l : ransomNote.toCharArray()) {
      int count = letters.getOrDefault(l, 0);
      if (count <= 0) {
        return false;
      }
      letters.put(l, count - 1);
    }
    return true;
  }
}
