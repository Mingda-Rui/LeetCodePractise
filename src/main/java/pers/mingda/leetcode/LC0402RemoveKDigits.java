package pers.mingda.leetcode;

import java.util.Stack;

public class LC0402RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (k >= num.length())
            return "0";

        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < num.length()) {
            char c = num.charAt(index);
            if (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            } else {
                if (stack.size() == 1 && stack.peek() == '0')
                    stack.pop();
                stack.push(c);
                index++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (k == 0)
                sb.append(c);
            else
                k--;
        }

        return sb.isEmpty() ? "0" : sb.reverse().toString();
    }
}

