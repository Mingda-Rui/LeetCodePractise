package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LC0022GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        return generateParenthesis(result, n, n, new StringBuilder());
    }

    private List<String> generateParenthesis(List<String> result, int numOfStart, int numOfClose, StringBuilder current) {
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
}

