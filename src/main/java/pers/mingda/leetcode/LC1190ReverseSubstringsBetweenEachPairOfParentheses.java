package pers.mingda.leetcode;

public class LC1190ReverseSubstringsBetweenEachPairOfParentheses {
    public String reverseParentheses(String s) {
        return reverseParenthesesRecursive(s, new int[1]);
    }

    private String reverseParenthesesRecursive(String s, int[] indexHolder) {
        StringBuilder sb = new StringBuilder();
        while (indexHolder[0] < s.length()) {
            char c = s.charAt(indexHolder[0]);
            if (c == '(') {
                indexHolder[0]++;
                sb.append(reverseParenthesesRecursive(s, indexHolder));
            } else if (c == ')') {
                return sb.reverse().toString();
            } else {
                sb.append(c);
            }
            indexHolder[0]++;
        }
        return sb.toString();
    }
}
