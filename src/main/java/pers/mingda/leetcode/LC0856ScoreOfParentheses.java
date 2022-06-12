package pers.mingda.leetcode;

import java.util.Stack;

public class LC0856ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        return score(s, new int[1]);
    }

    private int score(String s, int[] indexHolder) {
        if (indexHolder[0] < 0)
            return 0;
        int score = 0;
        while (indexHolder[0] < s.length()) {
            int index = indexHolder[0];
            indexHolder[0]++;
            char c = s.charAt(index);
            if (c == '(') {
                int subScore = score(s, indexHolder);
                score += Math.max(subScore * 2, 1);
            } else
                return score;
        }
        return score;
    }

    public int scoreOfParenthesesStackSolution(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentScore = 0;
        char prev = '(';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (prev == '(' && c == '(') {
                stack.push(0);
            } else if (prev == '(' && c == ')') {
                int currentSum = stack.pop();
                currentScore = 1;
                stack.push(currentSum + currentScore);
            } else if (prev == ')' && c == '(') {
                currentScore = 0;
            } else if (prev == ')' && c == ')') {
                int prevSum = stack.pop();
                int currentSum = stack.pop() + prevSum * 2;
                stack.push(currentSum);
            }

            prev = c;
        }

        return stack.pop();
    }
}
