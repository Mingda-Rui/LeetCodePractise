package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0438FindAllAnagramsInAString {}

class LC0438Solution {

  public List<Integer> findAnagrams(String s, String p) {
    int pLen = p.length();
    int[] sArr = new int[26];
    int[] pArr = new int[26];

    addStr(pArr, p);

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      updateMap(sArr, s, i - pLen, i);
      if (Arrays.equals(sArr, pArr)) {
        result.add(i - pLen + 1);
      }
    }
    return result;
  }

  private void addStr(int[] arr, String s) {
    for (int i = 0; i < s.length(); i++) {
      updateMap(arr, s, -1, i);
    }
  }

  private void updateMap(int[] arr, String s, int removeAt, int addAt) {
    if (removeAt >= 0 && s.charAt(removeAt) == s.charAt(addAt)) {
      return;
    }

    int addIndex = s.charAt(addAt) - 'a';
    arr[addIndex]++;

    if (removeAt < 0) {
      return;
    }

    int removeIndex = s.charAt(removeAt) - 'a';
    arr[removeIndex] = Math.max(arr[removeIndex] - 1, 0);
  }
}
