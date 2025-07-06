package pers.mingda.leetcode;

import java.util.Stack;

public class LC0032LongestValidParentheses {}

class LC0032Solution {

  public int longestValidParentheses(String s) {
    int[] dp = new int[s.length()];
    int max = 0;
    for (int i = 1; i < s.length(); i++) {
      char current = s.charAt(i);
      if (current == '(') {
        continue;
      }

      if (s.charAt(i - 1) == '(') {
        dp[i] = getLongestAt(dp, i - 2) + 2;
      } else {
        int prevLongest = dp[i - 1];
        int endBeforePrevL = i - prevLongest - 1;
        if (endBeforePrevL < 0 || s.charAt(endBeforePrevL) != '(') {
          continue;
        }
        int prevPrevLongest = getLongestAt(dp, endBeforePrevL - 1);
        dp[i] = prevPrevLongest + prevLongest + 2;
      }
      max = Math.max(max, dp[i]);
    }

    return max;
  }

  private int getLongestAt(int[] dp, int index) {
    if (index < 0) {
      return 0;
    }
    return dp[index];
  }
}

class LC0032StackSolution {

  public int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);

    int longest = 0;

    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      if (current == '(') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          longest = Math.max(longest, i - stack.peek());
        }
      }
    }

    return longest;
  }
}

class LC0032CounterSolution {

  public int longestValidParentheses(String s) {
    int longest = 0;
    longest = Math.max(longest, findLongest(s, '('));
    String reversedS = new StringBuilder(s).reverse().toString();
    longest = Math.max(longest, findLongest(reversedS, ')'));
    return longest;
  }

  private int findLongest(String s, char left) {
    int leftCount = 0;
    int rightCount = 0;
    int longest = 0;
    for (char current : s.toCharArray()) {
      if (current == left) {
        leftCount++;
      } else {
        rightCount++;
      }
      if (rightCount > leftCount) {
        leftCount = 0;
        rightCount = 0;
      } else if (leftCount == rightCount) {
        int currentLength = 2 * leftCount;
        longest = Math.max(longest, currentLength);
      }
    }
    return longest;
  }
}
