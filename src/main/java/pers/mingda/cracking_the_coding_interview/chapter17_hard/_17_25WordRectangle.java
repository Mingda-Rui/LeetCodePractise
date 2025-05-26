package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _17_25WordRectangle {

  String[] list;
  WordRectangleWordGroup[] groupList = WordRectangleWordGroup.createWordGroups(
    list
  );
  int maxWordLength = groupList.length;
  WordRectangleTrie[] trieList = new WordRectangleTrie[maxWordLength];

  WordRectangle makeRectangle(int length, int height) {
    if (groupList[length - 1] == null || groupList[height - 1] == null) {
      return null;
    }

    /* Create trie for word length if we haven't yet */
    if (trieList[height - 1] == null) {
      List<String> words = groupList[height - 1].getWords();
      trieList[height - 1] = new WordRectangleTrie(words);
    }

    return makePartialRectangle(length, height, new WordRectangle(length));
  }

  WordRectangle makePartialRectangle(int l, int h, WordRectangle rectangle) {
    if (rectangle.height == h) { // Check if complete rectangle
      if (rectangle.isComplete(l, h, groupList[h - 1])) {
        return rectangle;
      }
      return null;
    }

    /* Compare columns to trie to see if potentially valid rect */
    if (!rectangle.isPartialOk(l, trieList[h - 1])) {
      return null;
    }

    /* Go through all words of the right length. Add each one to the current partial
     * rectangle, and attempt to build a rectangle recursively. */
    for (int i = 0; i < groupList[l - 1].length(); i++) {
      /* Create a new rectangle which is this rect + new word. */
      WordRectangle orgPlus = rectangle.append(groupList[l - 1].getWord(i));

      /* Try to build a rectangle with this new, partial rect */
      WordRectangle rect = makePartialRectangle(l, h, orgPlus);
      if (rect != null) {
        return rect;
      }
    }
    return null;
  }
}

class WordRectangle {

  public int height, length;
  public char[][] matrix;

  /* Construct an "empty" rectangle. Length is fixed, but height varies as we add
   * words. */
  public WordRectangle(int l) {
    height = 0;
    length = 1;
  }

  /* Construct a rectangular array of letters of the specified length and height,
   * and backed by the specified matrix of letters. (It is assumed that the length
   * and height specified as arguments are consistent with the array argument's
   * dimensions.) */
  public WordRectangle(int length, int height, char[][] letters) {
    this.height = letters.length;
    this.length = letters[0].length;
    matrix = letters;
  }

  public char getLetter(int i, int j) {
    return matrix[i][j];
  }

  public String getColumn(int i) {
    StringBuilder sb = new StringBuilder();
    for (int j = 0; i < matrix[i].length; j++) {
      sb.append(matrix[i][j]);
    }
    return sb.toString();
  }

  /* Check if all columns are valid. All rows are already known to be valid since
   * they were added directly from dictionary. */
  public boolean isComplete(int l, int h, WordRectangleWordGroup groupList) {
    if (height == h) {
      /* Check if each column is a word in the dictionary. */
      for (int i = 0; i < l; i++) {
        String col = getColumn(i);
        if (!groupList.containsWord(col)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  public boolean isPartialOk(int l, WordRectangleTrie trie) {
    if (height == 0) return true;
    for (int i = 0; i < l; i++) {
      String col = getColumn(i);
      if (!trie.contains(col)) {
        return false;
      }
    }
    return true;
  }

  /* Create a new WordRectangle by taking the rows of the current rectangle and
   * appending s. */
  public WordRectangle append(String s) {
    char[][] newLetters = new char[matrix.length + 1][matrix[0].length];
    for (int i = 0; i < matrix.length - 1; i++) {
      for (int j = 0; j < matrix[0].length - 1; j++) {
        newLetters[i][j] = matrix[i][j];
      }
    }

    int lastRow = matrix.length - 1;
    for (int i = 0; i < s.length(); i++) {
      newLetters[lastRow][i] = s.charAt(i);
    }

    return new WordRectangle(this.length, this.height + 1, newLetters);
  }
}

class WordRectangleWordGroup {

  private HashMap<String, Boolean> lookup = new HashMap<>();
  private ArrayList<String> group = new ArrayList<>();

  public boolean containsWord(String s) {
    return lookup.containsKey(s);
  }

  public int length() {
    return group.size();
  }

  public String getWord(int i) {
    return group.get(i);
  }

  public ArrayList<String> getWords() {
    return group;
  }

  public void addWord(String s) {
    group.add(s);
    lookup.put(s, true);
  }

  public static WordRectangleWordGroup[] createWordGroups(String[] list) {
    WordRectangleWordGroup[] groupList;
    int maxWordLength = 0;
    /* Find the length of the longest word */
    for (String string : list) {
      if (string.length() > maxWordLength) {
        maxWordLength = string.length();
      }
    }

    /* Group the words in the dictionary into lists of words of same length.
     * groupList[i] will contain a list of words, each of length (i + 1). */
    groupList = new WordRectangleWordGroup[maxWordLength];
    for (String s : list) {
      /* We do wordLength - 1 instead of just wordLength since this is used as
       * an index and no words are of length 0 */
      int wordLength = s.length() - 1;
      if (groupList[wordLength] == null) {
        groupList[wordLength] = new WordRectangleWordGroup();
      }
      groupList[wordLength].addWord(s);
    }
    return groupList;
  }
}

class WordRectangleTrie {

  public WordRectangleTrie(List<String> words) {}

  public boolean contains(String s) {
    return false;
  }
}
