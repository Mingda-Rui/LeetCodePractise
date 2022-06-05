package pers.mingda.leetcode;

import java.util.Stack;

public class LC0227BasicCalculator2 {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        char prevOperator = ' ';
        for (int i = 0; i< s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                int num = current - '0';
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    i++;
                    int next = s.charAt(i) - '0';
                    num = num * 10 + next;
                }
                switch (prevOperator) {
                    case '+':
                        nums.push(num); break;
                    case '-':
                        nums.push(-num); break;
                    case '*':
                        nums.push(nums.pop() * num); break;
                    case '/':
                        nums.push(nums.pop() / num); break;
                    default:
                        nums.push(num); break;
                }
            } else if (current != ' ') {
                prevOperator = current;
            }
        }
        int result = 0;
        for (int num: nums)
            result += num;
        return result;
    }
}
