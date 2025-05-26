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

    return generateCountOfAtoms(map);
  }

  private String generateCountOfAtoms(Map<String, Integer> map) {
    StringBuilder sb = new StringBuilder();
    for (String e : map.keySet()) {
      int val = map.get(e);
      sb.append(e);
      if (val > 1) sb.append(val);
    }
    return sb.toString();
  }

  public String countOfAtomsRecursive(String formula) {
    Map<String, Integer> map = countOfAtomsRecursive(
      formula.toCharArray(),
      new int[1]
    );
    return generateCountOfAtoms(map);
  }

  private Map<String, Integer> countOfAtomsRecursive(
    char[] formula,
    int[] indexHolder
  ) {
    Map<String, Integer> map = new TreeMap<>();
    String currentElement = "";
    int magnitude = 0;
    while (indexHolder[0] < formula.length) {
      int index = indexHolder[0];
      char c = formula[indexHolder[0]];
      if (c == '(') {
        indexHolder[0]++;
        Map<String, Integer> innerMap = countOfAtomsRecursive(
          formula,
          indexHolder
        );
        magnitude = 0;
        while (
          indexHolder[0] + 1 < formula.length &&
          Character.isDigit(formula[indexHolder[0] + 1])
        ) {
          indexHolder[0]++;
          magnitude = magnitude * 10 + (formula[indexHolder[0]] - '0');
        }
        magnitude = Math.max(1, magnitude);
        for (String element : innerMap.keySet()) {
          int val = innerMap.get(element) * magnitude;
          int currentVal = map.getOrDefault(element, 0);
          map.put(element, val + currentVal);
        }
        magnitude = 0;
      } else if (c == ')') {
        return map;
      } else if (Character.isLetter(c)) {
        currentElement += c;
      } else if (Character.isDigit(c)) {
        magnitude = magnitude * 10 + (formula[index] - '0');
      }

      boolean atTail = index + 1 == formula.length;
      boolean foundElement =
        atTail ||
        (!currentElement.isEmpty() &&
          !Character.isDigit(formula[index + 1]) &&
          !Character.isLowerCase(formula[index + 1]));
      if (foundElement) {
        int prevVal = map.getOrDefault(currentElement, 0);
        map.put(currentElement, prevVal + Math.max(1, magnitude));
        currentElement = "";
        magnitude = 0;
      }
      indexHolder[0]++;
    }
    return map;
  }
}
