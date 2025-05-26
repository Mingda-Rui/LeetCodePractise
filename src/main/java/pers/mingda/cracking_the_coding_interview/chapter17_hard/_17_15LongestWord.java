package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _17_15LongestWord {
  String printLongestWord(String[] arr) {
    Map<String, Boolean> map = new HashMap<>();
    for (String str : arr) {
      map.put(str, true);
    }
    Arrays.sort(arr, Comparator.comparing(String::length));
    for (String s : arr) {
      if (canBuildWord(s, true, map)) {
        return s;
      }
    }
    return "";
  }

  boolean canBuildWord(String str, boolean isOriginalWord, Map<String, Boolean> map) {
    if (map.containsKey(str) && !isOriginalWord) {
      return map.get(str);
    }
    for (int i = 1; i < str.length(); i++) {
      String left = str.substring(0, i);
      String right = str.substring(i);
      if (map.containsKey(left) && map.get(left) && canBuildWord(right, false, map)) {
        return true;
      }
    }
    map.put(str, false);
    return false;
  }
}
