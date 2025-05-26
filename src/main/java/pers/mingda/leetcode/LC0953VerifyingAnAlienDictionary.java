package pers.mingda.leetcode;

public class LC0953VerifyingAnAlienDictionary {}

class LC0953Solution {
  public boolean isAlienSorted(String[] words, String order) {
    int[] orderMap = buildOrderMap(order);
    for (int i = 0; i < words.length - 1; i++) {
      if (!isSorted(words[i], words[i + 1], orderMap)) return false;
    }
    return true;
  }

  private int[] buildOrderMap(String order) {
    int[] orderMap = new int[128];
    for (int i = 0; i < order.length(); i++) orderMap[order.charAt(i)] = i;
    return orderMap;
  }

  private boolean isSorted(String word1, String word2, int[] order) {
    int minLen = Math.min(word1.length(), word2.length());
    for (int i = 0; i < minLen; i++) {
      char c1 = word1.charAt(i);
      char c2 = word2.charAt(i);
      if (order[c1] < order[c2]) return true;
      if (order[c1] > order[c2]) return false;
    }
    return word1.length() <= word2.length();
  }
}
