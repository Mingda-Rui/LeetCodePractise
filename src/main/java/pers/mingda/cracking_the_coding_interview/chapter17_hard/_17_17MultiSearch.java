package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.*;

public class _17_17MultiSearch {

  Map<String, List<Integer>> searchAll(String big, String[] smalls) {
    Map<String, List<Integer>> map = new HashMap<>();
    MultiSearchTrie trie = buildTrie(smalls);
    for (int i = 0; i < big.length(); i++) {
      Set<String> words = trie.search(big.substring(i));
      for (String word : words) {
        map.computeIfAbsent(word, k -> new ArrayList<>()).add(i);
      }
    }
    return map;
  }

  MultiSearchTrie buildTrie(String[] smalls) {
    MultiSearchTrie trie = new MultiSearchTrie();
    for (String word : smalls) {
      trie.add(word);
    }
    return trie;
  }
}

class MultiSearchTrie {

  MultiSearchTrieNode root;

  public MultiSearchTrie() {
    root = new MultiSearchTrieNode(' ');
  }

  public void add(String word) {
    root.add(word);
  }

  public Set<String> search(String str) {
    StringBuilder sb = new StringBuilder();
    Set<String> result = new HashSet<>();
    MultiSearchTrieNode node = root;
    for (int i = 0; i < str.length(); i++) {
      if (node.isLeaf()) {
        result.add(sb.toString());
      }

      char c = str.charAt(i);
      sb.append(c);
      if (!node.children.containsKey(c)) {
        return result;
      }
      node = node.children.get(c);
    }

    if (node.isLeaf()) {
      result.add(sb.toString());
    }

    return result;
  }
}

class MultiSearchTrieNode {

  char val;
  Map<Character, MultiSearchTrieNode> children;

  public MultiSearchTrieNode(char c) {
    val = c;
    children = new HashMap<>();
  }

  public void add(String word) {
    if (word == null || word.isEmpty()) {
      children.computeIfAbsent('*', MultiSearchTrieNode::new);
      return;
    }
    char c = word.charAt(0);
    children
      .computeIfAbsent(c, MultiSearchTrieNode::new)
      .add(word.substring(1));
  }

  public boolean isLeaf() {
    return children.containsKey('*');
  }
}
