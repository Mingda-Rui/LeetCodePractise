package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LC0049GroupAnagrams {

  public List<List<String>> groupAnagramsBruteForce(String[] strs) {
    List<List<String>> result = new LinkedList<>();
    boolean[] isProcessed = new boolean[strs.length];
    for (int i = 0; i < strs.length; i++) {
      if (!isProcessed[i]) {
        List<String> anagrams = groupAnagramsBruteForce(strs, i, isProcessed);
        result.add(anagrams);
      }
    }
    return result;
  }

  private List<String> groupAnagramsBruteForce(
    String[] strs,
    int current,
    boolean[] isProcessed
  ) {
    String curStr = strs[current];
    List<String> anagram = new LinkedList<>();
    anagram.add(curStr);
    for (int i = current + 1; i < strs.length; i++) {
      if (!isProcessed[i]) {
        String compared = strs[i];
        if (isAnagram(curStr, compared)) {
          isProcessed[i] = true;
          anagram.add(compared);
        }
      }
    }
    return anagram;
  }

  private boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] record = new int[128]; // could use int[26] and use char - 'a' as index
    for (char charInS : s.toCharArray()) record[charInS]++;
    for (char charInT : t.toCharArray()) {
      record[charInT]--;
      if (record[charInT] < 0) return false;
    }
    return true;
  }

  public List<List<String>> groupAnagramsWorseThanBruteForce(String[] strs) {
    List<List<String>> result = new LinkedList<>();
    for (int i = 0; i < strs.length; i++) {
      String current = strs[i];
      boolean foundAnagrams = false;
      for (List<String> anagrams : result) {
        if (!foundAnagrams && isAnagram(anagrams.get(0), current)) {
          anagrams.add(current);
          foundAnagrams = true;
        }
      }

      if (!foundAnagrams) {
        List<String> anagrams = new LinkedList<>(Arrays.asList(current));
        result.add(anagrams);
      }
    }
    return result;
  }

  public List<List<String>> groupAnagramsJavaSort(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String sorted = new String(chars);
      map.putIfAbsent(sorted, new LinkedList<>());
      map.get(sorted).add(str);
    }

    return map.values().stream().toList();
  }

  public List<List<String>> groupAnagramsNativeSort(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      String sorted = sort(str);
      map.putIfAbsent(sorted, new LinkedList<>());
      map.get(sorted).add(str);
    }

    return map.values().stream().toList();
  }

  private String sort(String str) {
    int[] record = new int[128];
    for (char c : str.toCharArray()) record[c]++;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < record.length; i++) {
      int num = record[i];
      for (int j = 0; j < num; j++) {
        sb.append(i);
      }
    }
    return sb.toString();
  }
}
