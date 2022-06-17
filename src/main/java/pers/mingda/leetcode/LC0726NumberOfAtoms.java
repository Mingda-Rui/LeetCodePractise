package pers.mingda.leetcode;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class LC0726NumberOfAtoms {
    public String countOfAtoms(String formula) {
        Stack<Integer> stack = new Stack<>();
        Map<String, Integer> map = new TreeMap<>();
        String count = "";
        String element = "";
        for (int i = formula.length() - 1; i >= 0; i--) {
            char c = formula.charAt(i);
            if (Character.isLetter(c)) {
                element = c + element;
                if (Character.isUpperCase(c)) {
                    int val = map.getOrDefault(element, 0);
                    int magnitude = stack.isEmpty() ? 1 : stack.peek();
                    int intCount = count.isEmpty() ? 1 : Integer.parseInt(count);
                    val += intCount * magnitude;
                    map.put(element, val);
                    element = "";
                    count = "";
                }
            } else if (Character.isDigit(c)) {
                count = c + count;
            } else if (c == '(') {
                stack.pop();
            } else if (c == ')') {
                int magnitude = stack.isEmpty() ? 1 : stack.peek();
                int intCount = count.isEmpty() ? 1 : Integer.parseInt(count);
                stack.push(intCount * magnitude);
                count = "";
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String e: map.keySet()) {
            int val = map.get(e);
            sb.append(e);
            if (val > 1)
                sb.append(val);
        }
        return sb.toString();
    }
}
