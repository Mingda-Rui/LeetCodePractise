package pers.mingda.leetcode;

import java.util.Stack;

public class LC0020ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char p : s.toCharArray()) {
            if (p == '(' || p == '{' || p == '[') {
                stack.push(p);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char open = stack.pop();
                if (p != getClosure(open)) return false;
            }
        }
        return stack.isEmpty();
    }

    private char getClosure(char open) {
        char closure;
        switch (open) {
            case '(':
                closure = ')';
                break;
            case '{':
                closure = '}';
                break;
            default:
                closure = ']';
        }
        return closure;
    }
}
