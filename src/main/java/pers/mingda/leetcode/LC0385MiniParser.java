package pers.mingda.leetcode;

import java.util.List;
import java.util.Stack;

public class LC0385MiniParser {
    public NestedInteger deserialize(String s) {
        return constructNestedInteger(s.toCharArray(), new int[1]);
    }

    private NestedInteger constructNestedInteger(char[] arr, int[] indexHolder) {
        char c = arr[indexHolder[0]];

        if (Character.isDigit(c) || c == '-') {
            int val = 0;
            if (c == '-')
                indexHolder[0]++;
            while (indexHolder[0] < arr.length && Character.isDigit(arr[indexHolder[0]])) {
                val = val * 10 + (arr[indexHolder[0]] - '0');
                indexHolder[0]++;
            }
            val *= (c == '-') ? -1 : 1;
            NestedInteger next = new NestedInteger(val);
            return next;
        } else if (c == '[') {
            NestedInteger next = new NestedInteger();
            indexHolder[0]++;
            while (indexHolder[0] < arr.length && arr[indexHolder[0]] != ']') {
                NestedInteger child = constructNestedInteger(arr, indexHolder);
                next.add(child);
            }
            indexHolder[0]++;
            return next;
        } else {
            indexHolder[0]++;
            return constructNestedInteger(arr, indexHolder);
        }
    }

    public NestedInteger deserializeStackSolution(String s) {
        if (s.charAt(0) != '[') {
            int val = Integer.parseInt(s);
            return new NestedInteger(val);
        }

        NestedInteger result = null;
        Stack<NestedInteger> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                NestedInteger next = new NestedInteger();
                if (!stack.isEmpty())
                    stack.peek().add(next);
                stack.push(next);
            } else if (Character.isDigit(c) || c == '-') {
                if (c == '-')
                    i++;
                int val = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    val = val * 10 + (s.charAt(i) - '0');
                }
                val *= (c == '-') ? -1 : 1;
                NestedInteger next = new NestedInteger(val);
                stack.peek().add(next);
            } else if (c == ']') {
                result = stack.pop();
            }
        }
        return result;
    }
}


class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger() {}
    // Constructor initializes a single integer.
    public NestedInteger(int value) {}

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return 0;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {

    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {

    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return null;
    }
}

