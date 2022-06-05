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

    public int evalRPNRecursive(String[] tokens) {
        int[] indexHolder = {tokens.length - 1};
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        return evalRPNRecursive(tokens, indexHolder, operators);
    }

    public int evalRPNRecursive(String[] tokens, int[] indexHolder, Set<String> operators) {
        int index = indexHolder[0];
        String token = tokens[index];
        indexHolder[0]--;
        if (operators.contains(token)) {
            int second = evalRPNRecursive(tokens, indexHolder, operators);
            int first = evalRPNRecursive(tokens, indexHolder, operators);
            int result = 0;
            switch (token) {
                case "+": result = first + second; break;
                case "-": result = first - second; break;
                case "*": result = first * second; break;
                case "/": result = first / second; break;
                default:
            }
            return result;
        }
        return Integer.parseInt(token);
    }
}
