package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

import java.util.Map;

public class _8_14BooleanEvaluation {

  public int countEval(String expression, boolean result, Map<String, Integer> countMap) {
    if (countMap.containsKey(expression + result)) {
      return countMap.get(expression);
    }
    if (expression.length() == 1) {
      return eval(expression, result);
    }

    int totalCount = 0;
    for (int i = 1; i < expression.length(); i += 2) {
      OPERATOR operator = OPERATOR.from(expression.charAt(i));
      String leftExp = expression.substring(0, i);
      String rightExp = expression.substring(i + 1);

      int leftTrue = countEval(leftExp, true, countMap);
      int leftFalse = countEval(leftExp, false, countMap);
      int rightTrue = countEval(rightExp, true, countMap);
      int rightFalse = countEval(rightExp, false, countMap);
      int total = (leftTrue + leftFalse) + (rightTrue + rightFalse);

      int totalTrue =
          switch (operator) {
            case AND -> leftTrue * rightTrue;
            case XOR -> leftTrue * rightFalse;
            case OR -> total - (leftFalse * rightFalse);
          };
      int count = result ? totalTrue : total - totalTrue;
      totalCount += count;
    }
    countMap.put(expression + result, totalCount);
    return totalCount;
  }

  private int eval(String expression, boolean result) {
    return toBoolean(expression) == result ? 1 : 0;
  }

  private boolean toBoolean(String expression) {
    return expression.equals("1");
  }
}

enum OPERATOR {
  AND("&"),
  XOR("^"),
  OR("|");
  private String operator;

  OPERATOR(String operator) {
    this.operator = operator;
  }

  public static OPERATOR from(char operator) {
    return switch (operator) {
      case '&' -> AND;
      case '^' -> XOR;
      case '|' -> OR;
      default -> throw new IllegalStateException("Unexpected value: " + operator);
    };
  }
}
