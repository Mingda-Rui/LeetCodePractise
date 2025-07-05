package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1268SearchSuggestionsSystem {}

class LC1268Solution {

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    LC1268Trie root = new LC1268Trie();
    Arrays.sort(products);
    for (String product : products) {
      root.add(product);
    }

    return root.find(searchWord);
  }
}

class LC1268Trie {

  char letter;
  Map<Character, LC1268Trie> children;
  List<String> words;

  public LC1268Trie() {
    this.children = new HashMap<>();
    this.words = new ArrayList<>();
  }

  public void add(String word) {
    add(word, 0);
  }

  public List<List<String>> find(String searchWord) {
    return find(searchWord, 0);
  }

  private void add(String word, int index) {
    if (index == word.length()) {
      return;
    }
    char initial = word.charAt(index);
    LC1268Trie child = children.computeIfAbsent(initial, i -> new LC1268Trie());
    child.add(word, index + 1);
    child.letter = initial;
    if (child.words.size() < 3) {
      child.words.add(word);
    }
  }

  private List<List<String>> find(String searchWord, int index) {
    if (index == searchWord.length()) {
      return List.of();
    }
    List<List<String>> result = new ArrayList<>();
    char current = searchWord.charAt(index);
    if (!children.containsKey(current)) {
      for (int i = 0; i < searchWord.length() - index; i++) {
        result.add(List.of());
      }
      return result;
    }
    LC1268Trie child = children.get(current);
    result.add(child.words);
    result.addAll(children.get(current).find(searchWord, index + 1));
    return result;
  }
}
