package pers.mingda.leetcode;

import java.util.List;

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

