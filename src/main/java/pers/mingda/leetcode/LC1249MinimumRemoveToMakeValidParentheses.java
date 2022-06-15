package pers.mingda.leetcode;

import java.util.Stack;

public class LC1249MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] removeChars = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    removeChars[i] = true;
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            int removeIndex = stack.pop();
            removeChars[removeIndex] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!removeChars[i])
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
