package pers.mingda.leetcode;

import java.util.Stack;

public class LC1249MinimumRemoveToMakeValidParentheses {
  public String minRemoveToMakeValid(String s) {
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      boolean isPrevLeftParenth = !stack.isEmpty() && s.charAt(stack.peek()) == '(';
      if (c == ')' && isPrevLeftParenth) {
        stack.pop();
      } else if (!Character.isLetter(c)) {
        stack.push(i);
      }
    }

    StringBuilder sb = new StringBuilder();
    int toBeRemoved = s.length();
    for (int i = s.length() - 1; i >= 0; i++) {
      if (toBeRemoved > i && !stack.isEmpty()) toBeRemoved = stack.pop();
      if (i != toBeRemoved) sb.append(s.charAt(i));
    }
    return sb.reverse().toString();
  }

  public String minRemoveToMakeValidNoStack(String s) {
    int balance = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (c == '(') {
        balance++;
      } else if (c == ')') {
        if (balance > 0) balance--;
        else chars[i] = '*';
      }
    }

    for (int i = chars.length - 1; i >= 0 && balance > 0; i--) {
      if (chars[i] == '(') {
        chars[i] = '*';
        balance--;
      }
    }

    int index = 0;
    for (char c : chars) {
      if (c != '*') {
        chars[index] = c;
        index++;
      }
    }
    return String.valueOf(chars, 0, index);
  }
}
