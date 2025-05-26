package pers.mingda.cracking_the_coding_interview.chapter10_sorting_and_searching;

import java.util.*;

public class _10_2GroupAnagrams {
  public void sort(String[] array) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : array) {
      String sorted = sortString(s);
      map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(s);
    }

    List<String> flattenList = map.values().stream().flatMap(List::stream).toList();
    Iterator<String> iterator = flattenList.iterator();
    for (int i = 0; i < array.length; i++) {
      array[i] = iterator.next();
    }
  }

  private String sortString(String str) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    return String.valueOf(chars);
  }
}
