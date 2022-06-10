package pers.mingda.leetcode;

import java.util.Stack;

public class LC0682BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op: ops) {
            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    int timesTwo = stack.peek() * 2;
                    stack.push(timesTwo);
                    break;
                case "+":
                    int second = stack.pop();
                    int first = stack.peek();
                    stack.push(second);
                    stack.push(first + second);
                    break;
                default:
                    int val = Integer.parseInt(op);
                    stack.push(val);
            }
        }
        int result = 0;
        while (!stack.isEmpty())
            result += stack.pop();
        return result;
    }

    public int calPointsNoStack(String[] ops) {
        int[] record = new int[ops.length];
        int pointer = -1;
        int sum = 0;
        for (String op: ops) {
            switch (op) {
                case "C" -> {
                    sum -= record[pointer];
                    pointer--;
                }
                case "D" -> {
                    int val = record[pointer] * 2;
                    pointer++;
                    record[pointer] = val;
                    sum += val;
                }
                case "+" -> {
                    int first = record[pointer - 1];
                    int val = first + record[pointer];
                    pointer++;
                    record[pointer] = val;
                    sum += val;
                }
                default -> {
                    pointer++;
                    record[pointer] = Integer.parseInt(op);
                    sum += record[pointer];
                }
            }
        }
        return sum;
    }
}
