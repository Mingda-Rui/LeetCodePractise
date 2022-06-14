package pers.mingda.leetcode;

public class LC1021RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                balance++;
                if (balance > 1)
                    sb.append(c);
            } else {
                balance--;
                if (balance > 0)
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}
