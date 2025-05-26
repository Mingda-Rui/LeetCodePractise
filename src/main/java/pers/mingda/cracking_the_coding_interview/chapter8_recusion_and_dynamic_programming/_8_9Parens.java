package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class _8_9Parens {
  private static final String OPEN_PARENS = "(";
  private static final String CLOSE_PARENS = ")";

  public List<String> generateParens(int numOfParens) {
    return generateParens(numOfParens, numOfParens);
  }

  private List<String> generateParens(int remainOpenP, int remainCloseP) {
    if (remainOpenP < 0 || remainOpenP < remainCloseP) {
      // invalid case, return empty list
      return List.of();
    }
    if (remainCloseP == 0) {
      return List.of("");
    }

    List<String> allParens = new ArrayList<>();
    List<String> openPrefix =
        generateParens(remainOpenP - 1, remainCloseP).stream()
            .map(parens -> OPEN_PARENS + parens)
            .toList();
    allParens.addAll(openPrefix);
    List<String> closePrefix =
        generateParens(remainOpenP, remainCloseP - 1).stream()
            .map(parens -> CLOSE_PARENS + parens)
            .toList();
    allParens.addAll(closePrefix);
    return allParens;
  }
}
