package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LC1657DetermineIfTwoStringsAreClose {

  public boolean closeStrings(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }
    Map<Character, Integer> word1Count = countLetters(word1);
    Map<Character, Integer> word2Count = countLetters(word2);
    if (!word1Count.keySet().equals(word2Count.keySet())) {
      return false;
    }

    Map<Integer, Integer> convertCount1 = convertCounts(word1Count);
    Map<Integer, Integer> convertCount2 = convertCounts(word2Count);

    return compareMap(convertCount1, convertCount2);
  }

  private Map<Character, Integer> countLetters(String word) {
    Map<Character, Integer> counter = new HashMap<>();
    for (char letter : word.toCharArray()) {
      populateLetter(letter, counter);
    }
    return counter;
  }

  private void populateLetter(char letter, Map<Character, Integer> counter) {
    int count = counter.getOrDefault(letter, 0);
    counter.put(letter, count + 1);
  }

  private Map<Integer, Integer> convertCounts(Map<Character, Integer> map) {
    Map<Integer, Integer> convertCounts = new HashMap<>();
    for (int count : map.values()) {
      int convertedCount = convertCounts.getOrDefault(count, 0);
      convertCounts.put(count, convertedCount + 1);
    }
    return convertCounts;
  }

  private boolean compareMap(
    Map<Integer, Integer> map1,
    Map<Integer, Integer> map2
  ) {
    if (map1.size() != map2.size()) {
      return false;
    }
    for (int key : map1.keySet()) {
      if (
        !Objects.equals(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0))
      ) {
        return false;
      }
    }
    return true;
  }
}
