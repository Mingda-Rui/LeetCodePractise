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
class Solution {
    public Node expTree(String s) {
        return expTree(s, 0, s.length());
    }

    private Node expTree(String s, int start, int end) {
        Stack<Node> stack = new Stack<>();
        for (int i = start; i < end; i++) {
            char current = s.charAt(i);
            Node digit = null;
            if (current == '(') {
                int close = findClosePare(s, i);
                digit = expTree(s, i + 1, close);
                i = close;
            } else {
                digit = new Node(current);
            }
            i++;
            if (i == end) {
                Node endSign = new Node('#');
                return popStack(stack, digit, endSign);
            }
            char next = s.charAt(i);
            Node sign = new Node(next);

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

    private boolean greaterThanPrevSign(Node sign, Stack<Node> stack) {
        // TODO sign check
        if (stack.isEmpty())
            return true;
        Node prevSign = stack.peek();
        int prevLevel = getSignLevel(prevSign);
        int currentLevel = getSignLevel(sign);
        return currentLevel > prevLevel;
    }

    private int getSignLevel(Node sign) {
        return switch (sign.val) {
                case '-', '+' -> 1;
                case '*', '/' -> 2;
                case '(', ')' -> 3;
                default -> 0;
        };
    }

    private Node popStack(Stack<Node> stack, Node digit, Node sign) {
        while (!stack.isEmpty() && !greaterThanPrevSign(sign, stack)) {
            Node prevSign = stack.pop();
            Node prev = stack.pop();
            prevSign.left = prev;
            prevSign.right = digit;
            digit = prevSign;
        }
        return digit;
    }

}

class Node {
    char val;
    Node left;
    Node right;
    Node() {this.val = ' ';}
    Node(char val) { this.val = val; }
    Node(char val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}