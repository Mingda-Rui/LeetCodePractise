package pers.mingda.leetcode;

public class LC0043MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0".repeat(num1.length() + num2.length()));

        for (int i = num1.length() - 1; i >= 0; i--) {
            int posI = num1.length() - 1 - i;
            int digitI = toInt(num1.charAt(i));
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int posJ = num2.length() - 1 - j;
                int digitJ = toInt(num2.charAt(j));
                int posResult = posI + posJ;
                int result = digitI * digitJ + carry + toInt(sb.charAt(posResult));
                //System.out.println(result + ":" + toChar(result % 10));
                sb.setCharAt(posResult, toChar(result % 10));
                carry = result / 10;
            }
            if (carry != 0) {
                int posCarry = posI + num2.length();
                int currentVal = toInt(sb.charAt(posCarry));
                sb.setCharAt(posCarry, toChar(currentVal + carry));
            }
        }

        while (!sb.isEmpty() && sb.charAt(sb.length() - 1) == '0') {
            sb.setLength(sb.length() - 1);
        }

        return sb.reverse().toString();
    }

    private char toChar(int digit) {
        return Character.forDigit(digit, 10);
    }

    private int toInt(char digit) {
        return digit - '0';
    }
}
