package pers.mingda.leetcode;

public class LC0604DesignCompressedStringIterator {}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
class LC0603StringIterator {

  private static final char WHITE_SPACE = ' ';

  private int currentCount;
  private char currentChar;
  private int index;
  private final String compressedString;

  public LC0603StringIterator(String compressedString) {
    this.currentCount = 0;
    this.currentChar = WHITE_SPACE;
    this.index = 0;
    this.compressedString = compressedString;
  }

  public char next() {
    if (!hasNext()) {
      return WHITE_SPACE;
    }

    if (currentCount == 0) {
      currentChar = compressedString.charAt(index);
      currentCount = getLetterCount();
    }
    currentCount--;
    return currentChar;
  }

  public boolean hasNext() {
    return index < compressedString.length() || currentCount > 0;
  }

  private int getLetterCount() {
    int len = compressedString.length();
    if (index == len) {
      return -1;
    }

    index++;
    int result = 0;
    while (index < len && Character.isDigit(compressedString.charAt(index))) {
      result *= 10;
      result += (compressedString.charAt(index) - '0');
      index++;
    }
    return result;
  }
}
