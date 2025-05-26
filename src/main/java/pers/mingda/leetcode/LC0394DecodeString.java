package pers.mingda.leetcode;

import java.util.Stack;

public class LC0394DecodeString {

  public String decodeString(String s) {
    int[] indexHolder = { 0 };
    String modifiedS = "1[" + s + "]";
    return decodeStringRecursive(modifiedS, indexHolder);
  }

  private String decodeStringRecursive(String s, int[] indexHolder) {
    StringBuilder current = new StringBuilder();
    int multiply = 0;
    while (indexHolder[0] < s.length()) {
      char c = s.charAt(indexHolder[0]);
      if (Character.isDigit(c)) {
        multiply = multiply * 10 + (c - '0');
      } else if (c == '[') {
        indexHolder[0]++;
        String part = decodeStringRecursive(s, indexHolder);
        current.append(part.repeat(multiply));
        multiply = 0;
      } else if (c == ']') {
        return current.toString();
      } else {
        current.append(c);
      }
      indexHolder[0]++;
    }
    return null;
  }

  public String decodeStringTwoStacks(String s) {
    Stack<String> strings = new Stack<>();
    Stack<Integer> nums = new Stack<>();
    String current = "";
    int multiply = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        multiply = multiply * 10 + (c - '0');
      } else if (c == '[') {
        nums.push(multiply);
        multiply = 0;
        strings.push(current);
        current = "";
      } else if (c == ']') {
        int repeat = nums.pop();
        String head = strings.pop();
        current = head + current.repeat(repeat);
      } else {
        current += c;
      }
    }
    return current;
  }
}
