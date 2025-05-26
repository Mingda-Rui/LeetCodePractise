package pers.mingda.leetcode;

import java.util.Stack;

public class LC0678ValidParenthesisString {

  public boolean checkValidString(String s) {
    int[][] memo = new int[s.length()][s.length()];
    return checkValidString(s, 0, 0, memo);
  }

  private boolean checkValidString(
    String s,
    int index,
    int openParenthesis,
    int[][] memo
  ) {
    if (index == s.length()) {
      return openParenthesis == 0;
    }

    if (openParenthesis < 0) {
      return false;
    }

    if (memo[index][openParenthesis] != 0) {
      return memo[index][openParenthesis] == 1;
    }

    int c = s.charAt(index);
    boolean result = false;
    if (c == '(') {
      result |= checkValidString(s, index + 1, openParenthesis + 1, memo);
    } else if (c == ')') {
      result |= checkValidString(s, index + 1, openParenthesis - 1, memo);
    } else {
      result |= (checkValidString(s, index + 1, openParenthesis, memo) ||
        checkValidString(s, index + 1, openParenthesis + 1, memo) ||
        checkValidString(s, index + 1, openParenthesis - 1, memo));
    }
    memo[index][openParenthesis] = result ? 1 : -1;
    return result;
  }

  public boolean checkValidStringTabulationSolution(String s) {
    int len = s.length();
    boolean[][] memo = new boolean[len + 1][len + 1];
    memo[len][0] = true;
    for (int i = len - 1; i >= 0; i--) {
      char c = s.charAt(i);
      for (int j = 0; j <= len / 2; j++) {
        boolean leftP = memo[i + 1][j + 1];
        boolean rightP = j == 0 ? false : memo[i + 1][j - 1];
        if (c == '(') {
          memo[i][j] = leftP;
        } else if (c == ')') {
          memo[i][j] = rightP;
        } else {
          memo[i][j] = memo[i + 1][j] || leftP || rightP;
        }
      }
    }
    return memo[0][0];
  }

  public boolean checkValidStringTwoStackSolution(String s) {
    Stack<Integer> openP = new Stack<>();
    Stack<Integer> asterisk = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        openP.push(i);
      } else if (c == '*') {
        asterisk.push(i);
      } else if (!openP.isEmpty()) {
        openP.pop();
      } else if (!asterisk.isEmpty()) {
        asterisk.pop();
      } else {
        return false;
      }
    }

    while (!openP.isEmpty() && !asterisk.isEmpty()) {
      if (openP.pop() > asterisk.pop()) {
        return false;
      }
    }

    return openP.isEmpty();
  }
}
