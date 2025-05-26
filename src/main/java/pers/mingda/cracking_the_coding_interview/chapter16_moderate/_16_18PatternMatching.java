package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

public class _16_18PatternMatching {

  boolean doesMatch(String pattern, String value) {
    if (pattern.length() == 0) return value.length() == 0;

    char mainChar = pattern.charAt(0);
    char altChar = mainChar == 'a' ? 'b' : 'a';
    int size = value.length();

    int countOfMain = countOf(pattern, mainChar);
    int countOfAlt = pattern.length() - countOfMain;
    int firstAlt = pattern.indexOf(altChar);
    int maxMainSize = size / countOfMain;

    for (int mainSize = 0; mainSize <= maxMainSize; mainSize++) {
      int remainingLength = size - mainSize * countOfMain;
      if (countOfAlt == 0 || remainingLength % countOfAlt == 0) {
        int altIndex = firstAlt * mainSize;
        int altSize = countOfAlt == 0 ? 0 : remainingLength / countOfAlt;
        if (matches(pattern, value, mainSize, altSize, altIndex)) {
          return true;
        }
      }
    }
    return false;
  }

  /* Iterates through pattern and value. At each character within pattern, checks if
   * this is the main string or the alternate string. Then checks if the next set of
   * characters in value match the original set of those characters (either the main
   * or the alternate. */
  boolean matches(
    String pattern,
    String value,
    int mainSize,
    int altSize,
    int firstAlt
  ) {
    int stringIndex = mainSize;
    for (int i = 1; i < pattern.length(); i++) {
      int size = pattern.charAt(i) == pattern.charAt(0) ? mainSize : altSize;
      int offset = pattern.charAt(i) == pattern.charAt(0) ? 0 : firstAlt;
      if (!isEqual(value, offset, stringIndex, size)) {
        return false;
      }
      stringIndex += size;
    }
    return true;
  }

  /* Checks if two substrings are equal, starting at given offsets and continuing to
   * size. */
  boolean isEqual(String s1, int offset1, int offset2, int size) {
    for (int i = 0; i < size; i++) {
      if (s1.charAt(offset1 + i) != s1.charAt(offset2 + i)) {
        return false;
      }
    }
    return true;
  }

  int countOf(String pattern, char c) {
    int count = 0;
    for (int i = 0; i < pattern.length(); i++) {
      if (pattern.charAt(i) == c) {
        count++;
      }
    }
    return count;
  }
}
