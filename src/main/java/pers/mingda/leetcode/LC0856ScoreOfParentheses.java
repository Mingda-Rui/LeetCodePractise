package pers.mingda.leetcode;

import java.util.Stack;

public class LC0856ScoreOfParentheses {

  public int scoreOfParentheses(String s) {
    return score(s, new int[1]);
  }

  private int score(String s, int[] indexHolder) {
    if (indexHolder[0] < 0) return 0;
    int score = 0;
    while (indexHolder[0] < s.length()) {
      int index = indexHolder[0];
      indexHolder[0]++;
      char c = s.charAt(index);
      if (c == '(') {
        int subScore = score(s, indexHolder);
        score += Math.max(subScore * 2, 1);
      } else return score;
    }
    return score;
  }

  public int scoreOfParenthesesStackSolution(String s) {
    Stack<Integer> stack = new Stack<>();
    int score = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(score);
        score = 0;
      } else if (c == ')') {
        score = stack.pop() + Math.max(score * 2, 1);
      }
    }
    return score;
  }

  public int scoreOfParenthesesO1SpaceComplexity(String s) {
    int result = 0;
    int depth = 0;
    char prev = '(';
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        depth++;
      } else {
        depth--;
        if (prev == '(') result += Math.pow(2, depth);
      }
      prev = c;
    }
    return result;
  }
}
