package pers.mingda.leetcode;

public class LC0678ValidParenthesisString {
    public boolean checkValidString(String s) {
        int[][] memo = new int[s.length()][s.length()];
        return checkValidString(s, 0, 0, memo);
    }

    private boolean checkValidString(String s, int index, int openParenthesis, int[][] memo) {
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
            result |= (checkValidString(s, index + 1, openParenthesis, memo) || checkValidString(s, index + 1, openParenthesis + 1, memo) || checkValidString(s, index + 1, openParenthesis - 1, memo));
        }
        memo[index][openParenthesis] = result ? 1 : -1;
        return result;
    }
}
