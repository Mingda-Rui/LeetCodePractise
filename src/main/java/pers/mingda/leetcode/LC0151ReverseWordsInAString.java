package pers.mingda.leetcode;

public class LC0151ReverseWordsInAString {

  public String reverseWords(String s) {
    StringBuilder sb = new StringBuilder();
    readWords(s.trim(), sb);
    return sb.toString().trim();
  }

  private void readWords(String s, StringBuilder sb) {
    if (s.isEmpty()) return;
    int index = s.length() - 1;
    while (index - 1 >= 0 && s.charAt(index - 1) != ' ') index--;

    String word = s.substring(index);
    sb.append(word).append(" ");
    while (index - 1 >= 0 && s.charAt(index - 1) == ' ') index--;

    readWords(s.substring(0, index), sb);
  }
}
