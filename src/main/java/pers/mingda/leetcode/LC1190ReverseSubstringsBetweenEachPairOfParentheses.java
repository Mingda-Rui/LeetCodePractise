package pers.mingda.leetcode;

import java.util.Stack;

public class LC1190ReverseSubstringsBetweenEachPairOfParentheses {
    public String reverseParentheses(String s) {
        return reverseParenthesesRecursive(s, new int[1]);
    }

    private String reverseParenthesesRecursive(String s, int[] indexHolder) {
        StringBuilder sb = new StringBuilder();
        while (indexHolder[0] < s.length()) {
            char c = s.charAt(indexHolder[0]);
            if (c == '(') {
                indexHolder[0]++;
                sb.append(reverseParenthesesRecursive(s, indexHolder));
            } else if (c == ')') {
                return sb.reverse().toString();
            } else {
                sb.append(c);
            }
            indexHolder[0]++;
        }
        return sb.toString();
    }

    public String reverseParenthesesIterative(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(sb);
                sb = new StringBuilder();
            } else if (c == ')') {
                String reversed = sb.reverse().toString();
                sb = stack.pop().append(reversed);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
