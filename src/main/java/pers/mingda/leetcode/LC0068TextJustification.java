package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

class LC0068TextJustification {}

class LC0068Solution {

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    int currentRowStart = 0;
    int currentRowMinLen = 0;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      int spacePlaceHolder = currentRowMinLen == 0 ? 0 : 1;
      int rowLenWithWord = currentRowMinLen + spacePlaceHolder + word.length();
      if (rowLenWithWord <= maxWidth) {
        currentRowMinLen = rowLenWithWord;
      } else {
        String justifiedRow = justifyRow(currentRowStart, i, words, maxWidth);
        result.add(justifiedRow);
        currentRowStart = i;
        currentRowMinLen = word.length();
      }
    }
    result.add(justifyRow(currentRowStart, words.length, words, maxWidth));
    return result;
  }

  private String justifyRow(int start, int end, String[] words, int maxWidth) {
    int wordCount = end - start;
    int spaceSlotCount = wordCount - 1;
    if (spaceSlotCount == 0) {
      return words[start] + " ".repeat(maxWidth - words[start].length());
    }
    int wordsLen = getWordsLen(start, end, words);
    int spacesLen = maxWidth - wordsLen;

    boolean isLastRow = end == words.length;
    int shorterSpaceLen = isLastRow ? 1 : spacesLen / spaceSlotCount;
    int longerSpaceCount = isLastRow ? 0 : spacesLen % spaceSlotCount;
    StringBuilder sb = new StringBuilder();
    for (int i = start; i < end; i++) {
      String word = words[i];
      sb.append(word);
      if (spaceSlotCount == 0) {
        continue;
      }
      int nextSpaces = shorterSpaceLen + (longerSpaceCount > 0 ? 1 : 0);
      sb.append(" ".repeat(nextSpaces));
      spaceSlotCount--;
      longerSpaceCount--;
    }
    int remainSpaces = maxWidth - sb.length();
    if (remainSpaces > 0) {
      sb.append(" ".repeat(remainSpaces));
    }

    return sb.toString();
  }

  private int getWordsLen(int start, int end, String[] words) {
    int totalLen = 0;
    for (int i = start; i < end; i++) {
      totalLen += words[i].length();
    }
    return totalLen;
  }
}
