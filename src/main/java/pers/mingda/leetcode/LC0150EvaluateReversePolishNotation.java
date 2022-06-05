package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LC0150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for (String token: tokens) {
            if (!operators.contains(token)) {
                int intToken = Integer.parseInt(token);
                stack.push(intToken);
            } else {
                int second = stack.pop();
                int first = stack.pop();
                if ("+".equals(token)) {
                    stack.push(first + second);
                } else if ("-".equals(token)) {
                    stack.push(first - second);
                } else if ("*".equals(token)) {
                    stack.push(first * second);
                } else if ("/".equals(token)) {
                    stack.push(first / second);
                }
            }
        }
        return stack.pop();
    }
}
