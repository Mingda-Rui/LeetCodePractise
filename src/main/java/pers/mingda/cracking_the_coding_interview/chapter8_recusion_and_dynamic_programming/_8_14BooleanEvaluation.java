package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

public class _8_14BooleanEvaluation {

    public int countEval(String expression, boolean result) {
        if (expression.length() == 1) {
            return eval(expression, result);
        }

        int totalCount = 0;
        for (int i = 1; i < expression.length(); i += 2) {
            OPERATOR operator = OPERATOR.from(expression.charAt(i));
            String leftExp = expression.substring(0, i);
            String rightExp = expression.substring(i + 1);

            if (result) {
                int count = switch (operator) {
                    case AND -> countEvalTrue(leftExp) * countEvalTrue(rightExp);
                    case XOR -> countEvalTrue(leftExp) * countEvalFalse(rightExp) + countEvalFalse(leftExp) * countEvalTrue(rightExp);
                    case OR -> countEvalBoth(leftExp) * countEvalBoth(rightExp) - (countEvalFalse(leftExp) * countEvalFalse(rightExp));
                };
                totalCount += count;
            } else {
                int count = switch (operator) {
                    case AND -> countEvalBoth(leftExp) * countEvalBoth(rightExp) - (countEvalTrue(leftExp) * countEvalTrue(rightExp));
                    case XOR -> countEvalTrue(leftExp) * countEvalTrue(rightExp) + countEvalFalse(leftExp) * countEvalFalse(rightExp);
                    case OR -> countEvalFalse(leftExp) * countEvalFalse(rightExp);
                };
                totalCount += count;
            }
        }
        return totalCount;
    }

    public int countEvalTrue(String expression) {
        return countEval(expression, true);
    }

    public int countEvalFalse(String expression) {
        return countEval(expression, false);
    }

    public int countEvalBoth(String expression) {
        return countEval(expression, false) + countEval(expression, true);
    }

    private int eval(String expression, boolean result) {
        return toBoolean(expression) == result ? 1 : 0;
    }

    private boolean toBoolean(String expression) {
        return expression.equals("1");
    }
}

enum OPERATOR {
    AND("&"), XOR("^"), OR("|");
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
