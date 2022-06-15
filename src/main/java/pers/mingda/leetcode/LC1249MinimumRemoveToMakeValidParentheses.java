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
            if (toBeRemoved > i && !stack.isEmpty())
                toBeRemoved = stack.pop();
            if (i != toBeRemoved)
                sb.append(s.charAt(i));
        }
        return sb.reverse().toString();
    }
}
