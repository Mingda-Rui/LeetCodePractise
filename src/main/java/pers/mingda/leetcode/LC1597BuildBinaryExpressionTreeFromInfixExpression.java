package pers.mingda.leetcode;

import java.util.Stack;

public class LC1597BuildBinaryExpressionTreeFromInfixExpression {

}

/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class LC1597Solution {
    public LC1597Node expTree(String s) {
        return expTree(s, 0, s.length());
    }

    private LC1597Node expTree(String s, int start, int end) {
        Stack<LC1597Node> stack = new Stack<>();
        for (int i = start; i < end; i++) {
            char current = s.charAt(i);
            LC1597Node digit;
            if (current == '(') {
                int close = findClosePare(s, i);
                digit = expTree(s, i + 1, close);
                i = close;
            } else {
                digit = new LC1597Node(current);
            }
            i++;
            if (i == end) {
                LC1597Node endSign = new LC1597Node('#');
                return popStack(stack, digit, endSign);
            }
            char next = s.charAt(i);
            LC1597Node sign = new LC1597Node(next);

            digit = popStack(stack, digit, sign);
            stack.push(digit);
            stack.push(sign);
        }
        return null;
    }

    private int findClosePare(String s, int start) {
        int numOfOpenPare = -1;
        while (s.charAt(start) != ')' || numOfOpenPare != 0) {
            char pare = s.charAt(start);
            if (pare == ')')
                numOfOpenPare--;
            else if (pare == '(')
                numOfOpenPare++;
            start++;
        }

        return start;
    }

    private boolean greaterThanPrevSign(LC1597Node sign, Stack<LC1597Node> stack) {
        // TODO sign check
        if (stack.isEmpty())
            return true;
        LC1597Node prevSign = stack.peek();
        int prevLevel = getSignLevel(prevSign);
        int currentLevel = getSignLevel(sign);
        return currentLevel > prevLevel;
    }

    private int getSignLevel(LC1597Node sign) {
        return switch (sign.val) {
                case '-', '+' -> 1;
                case '*', '/' -> 2;
                case '(', ')' -> 3;
                default -> 0;
        };
    }

    private LC1597Node popStack(Stack<LC1597Node> stack, LC1597Node digit, LC1597Node sign) {
        while (!stack.isEmpty() && !greaterThanPrevSign(sign, stack)) {
            LC1597Node prevSign = stack.pop();
            LC1597Node prev = stack.pop();
            prevSign.left = prev;
            prevSign.right = digit;
            digit = prevSign;
        }
        return digit;
    }

}

class LC1597Node {
    char val;
    LC1597Node left;
    LC1597Node right;
    LC1597Node() {this.val = ' ';}
    LC1597Node(char val) { this.val = val; }
    LC1597Node(char val, LC1597Node left, LC1597Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}