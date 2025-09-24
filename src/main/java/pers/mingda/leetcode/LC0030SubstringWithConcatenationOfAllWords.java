package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LC0030SubstringWithConcatenationOfAllWords {}

class LC0030Solution {

  public List<Integer> findSubstring(String s, String[] words) {
    int wordLen = words[0].length();
    int totalLen = wordLen * words.length;
    Map<String, Integer> wordCount = countWords(words);
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < wordLen; i++) {
      List<Integer> concatStrings = checkConcatenatedStr(s, i, wordLen, totalLen, wordCount);
      result.addAll(concatStrings);
    }
    return result;
  }

  private Map<String, Integer> countWords(String[] words) {
    Map<String, Integer> wordCount = new HashMap<>();
    for (String word : words) {
      int prevCount = wordCount.getOrDefault(word, 0);
      wordCount.put(word, prevCount + 1);
    }
    return wordCount;
  }

  private List<Integer> checkConcatenatedStr(
    String s,
    int head,
    int wordLen,
    int totalLen,
    Map<String, Integer> wordCount
  ) {
    List<Integer> result = new ArrayList<>();
    int tail = head;
    Map<String, Integer> currCount = new HashMap<>();
    while (tail + wordLen <= s.length()) {
      String nextWord = s.substring(tail, tail + wordLen);
      updateWordCount(currCount, nextWord, 1);
      tail += wordLen;
      if (tail - head > totalLen) {
        String prevWord = s.substring(head, head + wordLen);
        updateWordCount(currCount, prevWord, -1);
        head += wordLen;
      }
      if (isEqual(wordCount, currCount)) {
        result.add(head);
      }
    }
    return result;
  }

  private void updateWordCount(Map<String, Integer> map, String word, int offset) {
    int prevCount = map.getOrDefault(word, 0);
    int newCount = prevCount + offset;
    if (newCount == 0) {
      map.remove(word);
    } else {
      map.put(word, prevCount + offset);
    }
  }

  private boolean isEqual(Map<String, Integer> map1, Map<String, Integer> map2) {
    if (map1.size() != map2.size()) {
      return false;
    }
    for (String str : map1.keySet()) {
      if (!map2.containsKey(str) || !Objects.equals(map1.get(str), map2.get(str))) {
        return false;
      }
    }
    return true;
  }
}
