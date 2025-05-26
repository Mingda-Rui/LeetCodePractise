package pers.mingda.leetcode;

import java.util.Stack;

public class LC0224BasicCalculator {
  public int calculate(String s) {
    return calculate(s, new int[1]);
  }

  private int calculate(String s, int[] indexHolder) {
    int result = 0;
    boolean isSum = true;
    int currentVal = 0;
    while (indexHolder[0] < s.length()) {
      char c = s.charAt(indexHolder[0]);
      if (c == '(') {
        indexHolder[0]++;
        int currentResult = calculate(s, indexHolder);
        result += (isSum ? 1 : -1) * currentResult;
      } else if (c == ')') {
        return result;
      } else if (Character.isDigit(c)) {
        currentVal = currentVal * 10 + (c - '0');
        while (indexHolder[0] + 1 < s.length() && Character.isDigit(s.charAt(indexHolder[0] + 1))) {
          indexHolder[0]++;
          c = s.charAt(indexHolder[0]);
          currentVal = currentVal * 10 + (c - '0');
        }
        result += (isSum ? 1 : -1) * currentVal;
        currentVal = 0;
      } else if (c != ' ') {
        isSum = c == '+';
      }
      indexHolder[0]++;
    }
    return result;
  }

  public int calculateIterative(String s) {
    Stack<Integer> stack = new Stack<>();
    Stack<Character> opStack = new Stack<>();
    int currentVal = 0;
    char prevOp = '+';
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(result);
        opStack.push(prevOp);
        result = 0;
        prevOp = '+';
      } else if (c == ')') {
        int prevResult = stack.pop();
        prevOp = opStack.pop();
        switch (prevOp) {
          case '+' -> {
            result = prevResult + result;
          }
          case '-' -> {
            result = prevResult - result;
          }
        }
      } else if (Character.isDigit(c)) {
        currentVal = currentVal * 10 + (s.charAt(i) - '0');
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          i++;
          currentVal = currentVal * 10 + (s.charAt(i) - '0');
        }
        switch (prevOp) {
          case '+' -> {
            result += currentVal;
          }
          case '-' -> {
            result -= currentVal;
          }
        }
        currentVal = 0;
      } else if (c != ' ') {
        prevOp = c;
      }
    }
    return result;
  }
}
