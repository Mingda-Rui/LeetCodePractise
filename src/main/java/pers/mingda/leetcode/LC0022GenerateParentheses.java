package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LC0022GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        return generateParenthesis(result, n, n, "");
    }

    private List<String> generateParenthesis(List<String> result, int numOfStart, int numOfClose, String current) {
        if (numOfStart == 0 && numOfClose == 0) {
            result.add(current);
            return result;
        }

        if (numOfStart != 0)
            generateParenthesis(result, numOfStart - 1, numOfClose, current + "(");
        if (numOfStart != numOfClose)
            generateParenthesis(result, numOfStart, numOfClose - 1, current + ")");
        return result;
    }
}
