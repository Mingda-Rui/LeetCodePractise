package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC0438FindAllAnagramsInAString {}

class LC0438Solution {

  public List<Integer> findAnagrams(String s, String p) {
    int pLen = p.length();
    Map<Character, Integer> sMap = new HashMap<>();
    Map<Character, Integer> pMap = new HashMap<>();

    addStr(pMap, p);

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      updateMap(sMap, s, i - pLen, i);
      if (isEqual(sMap, pMap)) {
        result.add(i - pLen + 1);
      }
    }
    return result;
  }

  private void addStr(Map<Character, Integer> map, String s) {
    for (int i = 0; i < s.length(); i++) {
      updateMap(map, s, -1, i);
    }
  }

  private void updateMap(Map<Character, Integer> map, String s, int removeAt, int addAt) {
    if (removeAt >= 0 && s.charAt(removeAt) == s.charAt(addAt)) {
      return;
    }
    char addChar = s.charAt(addAt);
    int addCount = map.getOrDefault(addChar, 0);
    map.put(addChar, addCount + 1);

    if (removeAt < 0) {
      return;
    }

    char removeChar = s.charAt(removeAt);
    int removeCount = map.getOrDefault(removeChar, 0);
    if (removeCount - 1 == 0) {
      map.remove(removeChar);
    } else {
      map.put(removeChar, removeCount - 1);
    }
  }

  private boolean isEqual(Map<Character, Integer> map1, Map<Character, Integer> map2) {
    if (map1.size() != map2.size()) {
      return false;
    }

    for (char key : map1.keySet()) {
      if (!map2.containsKey(key) || map1.get(key).intValue() != map2.get(key).intValue()) {
        return false;
      }
    }
    return true;
  }
}
