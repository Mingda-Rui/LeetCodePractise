package pers.mingda.leetcode;

import java.util.List;
import java.util.Stack;

public class LC0385MiniParser {
  public LC0385NestedInteger deserialize(String s) {
    return constructLC0385NestedInteger(s.toCharArray(), new int[1]);
  }

  private LC0385NestedInteger constructLC0385NestedInteger(char[] arr, int[] indexHolder) {
    char c = arr[indexHolder[0]];

    if (Character.isDigit(c) || c == '-') {
      int val = 0;
      if (c == '-') indexHolder[0]++;
      while (indexHolder[0] < arr.length && Character.isDigit(arr[indexHolder[0]])) {
        val = val * 10 + (arr[indexHolder[0]] - '0');
        indexHolder[0]++;
      }
      val *= (c == '-') ? -1 : 1;
      LC0385NestedInteger next = new LC0385NestedInteger(val);
      return next;
    } else if (c == '[') {
      LC0385NestedInteger next = new LC0385NestedInteger();
      indexHolder[0]++;
      while (indexHolder[0] < arr.length && arr[indexHolder[0]] != ']') {
        LC0385NestedInteger child = constructLC0385NestedInteger(arr, indexHolder);
        next.add(child);
      }
      indexHolder[0]++;
      return next;
    } else {
      indexHolder[0]++;
      return constructLC0385NestedInteger(arr, indexHolder);
    }
  }

  public LC0385NestedInteger deserializeStackSolution(String s) {
    if (s.charAt(0) != '[') {
      int val = Integer.parseInt(s);
      return new LC0385NestedInteger(val);
    }

    LC0385NestedInteger result = null;
    Stack<LC0385NestedInteger> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '[') {
        LC0385NestedInteger next = new LC0385NestedInteger();
        if (!stack.isEmpty()) stack.peek().add(next);
        stack.push(next);
      } else if (Character.isDigit(c) || c == '-') {
        if (c == '-') i++;
        int val = s.charAt(i) - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          i++;
          val = val * 10 + (s.charAt(i) - '0');
        }
        val *= (c == '-') ? -1 : 1;
        LC0385NestedInteger next = new LC0385NestedInteger(val);
        stack.peek().add(next);
      } else if (c == ']') {
        result = stack.pop();
      }
    }
    return result;
  }
}

class LC0385NestedInteger {
  // Constructor initializes an empty nested list.
  public LC0385NestedInteger() {}

  // Constructor initializes a single integer.
  public LC0385NestedInteger(int value) {}

  // @return true if this LC0385NestedInteger holds a single integer, rather than a nested list.
  public boolean isInteger() {
    return false;
  }

  // @return the single integer that this LC0385NestedInteger holds, if it holds a single integer
  // Return null if this LC0385NestedInteger holds a nested list
  public Integer getInteger() {
    return 0;
  }

  // Set this LC0385NestedInteger to hold a single integer.
  public void setInteger(int value) {}

  // Set this LC0385NestedInteger to hold a nested list and adds a nested integer to it.
  public void add(LC0385NestedInteger ni) {}

  // @return the nested list that this LC0385NestedInteger holds, if it holds a nested list
  // Return empty list if this LC0385NestedInteger holds a single integer
  public List<LC0385NestedInteger> getList() {
    return null;
  }
}
