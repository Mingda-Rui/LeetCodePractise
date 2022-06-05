package pers.mingda.leetcode;

import java.util.Stack;

public class LC0227BasicCalculator2 {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        int val = 0;
        char prevOp = '+';
        for (int i = 0; i< s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                val = val * 10 + (current - '0');
            }
            if ((current != ' ' && !Character.isDigit(current)) || i == s.length() - 1) {
                switch (prevOp) {
                    case '+':
                        nums.push(val); break;
                    case '-':
                        nums.push(-val); break;
                    case '*':
                        nums.push(nums.pop() * val); break;
                    case '/':
                        nums.push(nums.pop() / val); break;
                    default:
                        nums.push(val); break;
                }
                prevOp = current;
                val = 0;
            }
        }
        int result = 0;
        for (int num: nums)
            result += num;
        return result;
    }
}
