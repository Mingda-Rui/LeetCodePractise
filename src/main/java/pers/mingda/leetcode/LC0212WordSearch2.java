package pers.mingda.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LC0212WordSearch2 {

  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new LinkedList<>();
    for (String word : words) {
      int currSize = result.size();
      for (int i = 0; i < board.length && currSize == result.size(); i++) {
        for (
          int j = 0;
          j < board[0].length && currSize == result.size();
          j++
        ) if (
          findWordReverse(
            board,
            i,
            j,
            word,
            word.length() - 1,
            new boolean[board.length][board[0].length]
          )
        ) result.add(word);
      }
    }
    return result;
  }

  private boolean findWordReverse(
    char[][] board,
    int x,
    int y,
    String word,
    int index,
    boolean[][] visited
  ) {
    if (
      x < 0 || x >= board.length || y < 0 || y >= board[0].length
    ) return false;
    char c = word.charAt(index);
    if (visited[x][y] || board[x][y] != c) return false;
    visited[x][y] = true;
    boolean found = false;
    if (index == 0) return true;
    index--;
    found = found || findWordReverse(board, x + 1, y, word, index, visited);
    found = found || findWordReverse(board, x - 1, y, word, index, visited);
    found = found || findWordReverse(board, x, y + 1, word, index, visited);
    found = found || findWordReverse(board, x, y - 1, word, index, visited);
    visited[x][y] = false;
    return found;
  }

  public List<String> findWordsTrie(char[][] board, String[] words) {
    Set<String> set = new HashSet<>();
    TrieNode trie = buildTrie(words);
    int row = board.length;
    int column = board[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        findWordsFromTrie(board, i, j, trie, set, new boolean[row][column]);
      }
    }
    return List.copyOf(set);
  }

  private TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode('.');
    for (String word : words) root.add(word);
    return root;
  }

  private boolean findWordsFromTrie(
    char[][] board,
    int x,
    int y,
    TrieNode trie,
    Set<String> result,
    boolean[][] visited
  ) {
    if (
      x < 0 ||
      x >= board.length ||
      y < 0 ||
      y >= board[0].length ||
      visited[x][y]
    ) return false;
    char c = board[x][y];
    if (trie.record[c] == null) return false;
    visited[x][y] = true;
    TrieNode subTrie = trie.record[c];
    if (subTrie.word != null) {
      result.add(subTrie.word);
    }

    findWordsFromTrie(board, x + 1, y, subTrie, result, visited);
    findWordsFromTrie(board, x - 1, y, subTrie, result, visited);
    findWordsFromTrie(board, x, y + 1, subTrie, result, visited);
    findWordsFromTrie(board, x, y - 1, subTrie, result, visited);

    trie.remove(c);

    visited[x][y] = false;
    return true;
  }
}

class TrieNode {

  String word;
  TrieNode[] record;
  TrieNode parent;
  char c;
  int size;

  public TrieNode(char c) {
    this(null, c);
  }

  public TrieNode(TrieNode parent, char c) {
    this.word = null;
    this.record = new TrieNode[128];
    this.parent = parent;
    this.c = c;
    this.size = 0;
  }

  public void add(String word) {
    addRecursive(word, 0);
  }

  private void addRecursive(String word, int index) {
    char c = word.charAt(index);
    if (this.record[c] == null) {
      this.record[c] = new TrieNode(this, c);
      this.size++;
    }

    if (index == word.length() - 1) this.record[c].word = word;
    else record[c].addRecursive(word, index + 1);
  }

  public void remove(char c) {
    if (this.record[c] != null && this.record[c].size == 0) {
      this.record[c] = null;
      size--;
    }
    if (parent != null) parent.remove(this.c);
  }
}
