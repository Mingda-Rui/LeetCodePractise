package pers.mingda.leetcode;

public class LC0227BasicCalculator2 {
    public int calculate(String s) {
        int prevVal = 0;
        int val = 0;
        int result = 0;
        char prevOp = '+';
        for (int i = 0; i< s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                val = val * 10 + (current - '0');
            }
            if ((current != ' ' && !Character.isDigit(current)) || i == s.length() - 1) {
                switch (prevOp) {
                    case '+':
                        result += prevVal; prevVal = val; break;
                    case '-':
                        result += prevVal; prevVal = -val; break;
                    case '*':
                        prevVal *= val; break;
                    case '/':
                        prevVal /= val; break;
                    default:
                        break;
                }
                prevOp = current;
                val = 0;
            }
        }
        result += prevVal;
        return result;
    }
}
