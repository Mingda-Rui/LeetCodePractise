package pers.mingda.leetcode;

public class LC0604DesignCompressedStringIterator {}

class StringIterator {

  private static final char WHITE_SPACE = ' ';

  private int currentCount;
  private int index;
  private int compressedLetterCount;
  private final String compressedString;

  public StringIterator(String compressedString) {
    this.currentCount = 0;
    this.index = 0;
    this.compressedString = compressedString;
    this.compressedLetterCount = getLetterCount();
  }

  public char next() {
    if (!hasNext()) {
      return WHITE_SPACE;
    }

    currentCount++;
    char result = compressedString.charAt(index);

    if (compressedLetterCount == currentCount) {
      index = getNextIndex();
      currentCount = 0;
      compressedLetterCount = getLetterCount();
    }
    return result;
  }

  public boolean hasNext() {
    return index < compressedString.length();
  }

  private int getLetterCount() {
    int len = compressedString.length();
    if (index == len) {
      return -1;
    }

    int tempIndex = index + 1;
    int result = 0;
    while (tempIndex < len && isDigit(compressedString.charAt(tempIndex))) {
      result *= 10;
      result += (compressedString.charAt(tempIndex) - '0');
      tempIndex++;
    }
    return result;
  }

  private int getNextIndex() {
    int len = compressedString.length();
    if (index == len) {
      return index;
    }

    index++;
    while (index < len && isDigit(compressedString.charAt(index))) {
      index++;
    }
    return index == len - 1 ? len : index;
  }

  private boolean isDigit(char c) {
    return c >= '0' && c <= '9';
  }
}
/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
