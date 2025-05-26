package pers.mingda.leetcode;

public class LC0211DesignAddAndSearchWordsDataStructure {}

class WordDictionary {

  WordDictionary[] record;
  boolean isEnd;

  public WordDictionary() {
    this(false);
  }

  private WordDictionary(boolean isEnd) {
    this.record = new WordDictionary[128];
    this.isEnd = isEnd;
  }

  public void addWord(String word) {
    addWord(word, 0);
  }

  private void addWord(String word, int index) {
    if (index < word.length()) {
      if (record['.'] == null) record['.'] = new WordDictionary();
      char c = word.charAt(index);
      if (record[c] == null) record[c] = new WordDictionary();
      if (index == word.length() - 1) {
        record[c].isEnd = true;
        record['.'].isEnd = true;
      }
      record[c].addWord(word, index + 1);
    }
  }

  public boolean search(String word) {
    return search(word, 0);
  }

  private boolean search(String word, int index) {
    char c = word.charAt(index);
    if (record[c] == null) return false;
    if (index == word.length() - 1) return record[c].isEnd;
    if (c == '.') {
      for (WordDictionary wd : record) {
        if (wd != null && wd.search(word, index + 1)) return true;
      }
    }
    return record[c].search(word, index + 1);
  }
}
/**
 * Your WordDictionary object will be instantiated and called as such: WordDictionary obj = new
 * WordDictionary(); obj.addWord(word); boolean param_2 = obj.search(word);
 */
