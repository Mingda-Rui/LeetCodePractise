package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC0022GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    List<String> result = new LinkedList<>();
    return generateParenthesis(result, n, n, new StringBuilder());
  }

  private List<String> generateParenthesis(
    List<String> result,
    int numOfStart,
    int numOfClose,
    StringBuilder current
  ) {
    if (numOfStart == 0 && numOfClose == 0) {
      result.add(current.toString());
      return result;
    }

    if (numOfStart != 0) {
      current.append("(");
      generateParenthesis(result, numOfStart - 1, numOfClose, current);
      current.deleteCharAt(current.length() - 1);
    }
    if (numOfStart != numOfClose) {
      current.append(")");
      generateParenthesis(result, numOfStart, numOfClose - 1, current);
      current.deleteCharAt(current.length() - 1);
    }
    return result;
  }

  public List<String> generateParenthesisDp(int n) {
    List<List<String>> result = new ArrayList<>();
    List<String> list0 = List.of("");
    result.add(list0);
    for (int length = 1; length <= n; length++) {
      List<String> currList = new LinkedList<>();
      for (int leftSize = 0; leftSize < length; leftSize++) {
        int rightSize = length - leftSize - 1;
        for (String left : result.get(leftSize)) for (String right : result.get(
          rightSize
        )) currList.add("(" + left + ")" + right);
      }
      result.add(currList);
    }

    return result.get(n);
  }

  public List<String> generateParenthesisDpRecursive(int n) {
    return generateParenthesisDpRecursive(n, new ArrayList<>());
  }

  private List<String> generateParenthesisDpRecursive(
    int n,
    List<List<String>> result
  ) {
    if (n == 0) return List.of("");
    if (result.size() > n) return result.get(n);

    List<String> currList = new LinkedList<>();
    for (int leftSize = 0; leftSize < n; leftSize++) {
      int rightSize = n - leftSize - 1;
      for (String left : generateParenthesisDpRecursive(
        leftSize,
        result
      )) for (String right : generateParenthesisDpRecursive(
        rightSize,
        result
      )) currList.add("(" + left + ")" + right);
    }
    result.add(currList);
    return currList;
  }
}
