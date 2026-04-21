package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2707ExtraCharactersInAString {
}

class LC2707Solution {
  public int minExtraChar(String s, String[] dictionary) {
    LC2707Trie trie = new LC2707Trie();
    trie.initialize(dictionary);
    int[] memo = new int[s.length()];
    Arrays.fill(memo, -1);
    return s.length() - minExtraChar(s, 0, trie, memo);
  }

  private int minExtraChar(String s, int index, LC2707Trie trie, int[] memo) {
    if (index == s.length()) {
      return 0;
    }

    if (memo[index] != -1) {
      return memo[index];
    }

    List<String> matchedStrings = trie.find(s, index);
    int max = Integer.MIN_VALUE;
    for (String matchedString : matchedStrings) {
      int len = matchedString.length();
      int matchedCount = minExtraChar(s, index + len, trie, memo);
      max = Math.max(max, len + matchedCount);
    }
    max = Math.max(max, minExtraChar(s, index + 1, trie, memo));
    memo[index] = max;
    return max;
  }
}

class LC2707Trie {
  LC2707Trie[] nodes;
  boolean[] isWord;

  public LC2707Trie() {
    this.nodes = new LC2707Trie[26];
    this.isWord = new boolean[26];
  }

  public void initialize(String[] dictionary) {
    for (String word : dictionary) {
      if (word.isEmpty()) {
        continue;
      }
      add(word, 0);
    }
  }

  public List<String> find(String word, int index) {
    List<String> result = new ArrayList<>();
    if (word.isEmpty() || index == word.length()) {
      return result;
    }
    char letter = word.charAt(index);
    int letterPos = letter - 'a';
    String singleLetterStr = String.valueOf(letter);
    if (nodes[letterPos] == null) {
      return result;
    }
    if (isWord[letterPos]) {
      result.add(singleLetterStr);
    }
    if (index == word.length() - 1) {
      return result;
    }
    for (String found : nodes[letterPos].find(word, index + 1)) {
      result.add(singleLetterStr + found);
    }
    return result;
  }

  private void add(String word, int index) {
    char letter = word.charAt(index);
    int letterPos = letter - 'a';
    if (nodes[letterPos] == null) {
      nodes[letterPos] = new LC2707Trie();
    }
    if (index == word.length() - 1) {
      isWord[letterPos] = true;
    } else {
      nodes[letterPos].add(word, index + 1);
    }
  }
}