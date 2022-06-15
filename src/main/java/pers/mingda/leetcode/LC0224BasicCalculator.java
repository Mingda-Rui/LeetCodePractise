package pers.mingda.leetcode;

public class LC0224BasicCalculator {
    public int calculate(String s) {
        return calculate(s, new int[1]);
    }

    private int calculate(String s, int[] indexHolder) {
        int result = 0;
        boolean isSum = true;
        int currentVal = 0;
        while (indexHolder[0] < s.length()) {
            char c = s.charAt(indexHolder[0]);
            if (c == '(') {
                indexHolder[0]++;
                int currentResult = calculate(s, indexHolder);
                result += (isSum ? 1 : -1) * currentResult;
            } else if (c == ')') {
                return result;
            } else if (Character.isDigit(c)) {
                currentVal = currentVal * 10 + (c - '0');
                while (indexHolder[0] + 1 < s.length() && Character.isDigit(s.charAt(indexHolder[0] + 1))) {
                    indexHolder[0]++;
                    c = s.charAt(indexHolder[0]);
                    currentVal = currentVal * 10 + (c - '0');
                }
                result += (isSum ? 1 : -1) * currentVal;
                currentVal = 0;
            } else if (c != ' ') {
                isSum = c == '+';
            }
            indexHolder[0]++;
        }
        return result;
    }
}
