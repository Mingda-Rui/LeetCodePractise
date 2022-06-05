package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LC0227BasicCalculator2 {
    public int calculate(String s) {
        Set<Character> firstClassOperators = new HashSet<>(Arrays.asList('*', '/'));
        Set<Character> validOperators = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

        Deque<Character> operators = new LinkedList<>();
        Deque<Integer> nums = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (validOperators.contains(current)) {
                operators.addLast(current);
            } else if (current != ' ') {
                int num = current - '0';
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    i++;
                    int next = s.charAt(i) - '0';
                    num = num * 10 + next;
                }
                char prevOperator = operators.isEmpty() ? ' ' : operators.getLast();
                if (firstClassOperators.contains(prevOperator)) {
                    operators.removeLast();
                    int first = nums.removeLast();
                    if (prevOperator == '*')
                        nums.addLast(first * num);
                    else if (prevOperator == '/')
                        nums.addLast(first / num);
                } else {
                    nums.addLast(num);
                }
            }
        }

        int result = 0;
        if (!nums.isEmpty())
            result = nums.removeFirst();
        while (!operators.isEmpty()) {
            char operator = operators.removeFirst();
            int next = nums.removeFirst();
            if (operator == '+')
                result = result + next;
            else if (operator == '-')
                result = result - next;
        }

        return result;
    }
}
