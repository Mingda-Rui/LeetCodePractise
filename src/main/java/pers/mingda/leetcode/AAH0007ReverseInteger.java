package pers.mingda.leetcode;

public class AAH0007ReverseInteger {
}

class Solution_String {
    public int reverse(int x) {
        String numInString = String.valueOf(x);
        int lengthOfString = numInString.length();
        int endIndex = lengthOfString - 1;
        char negativeSign = '-';
        int lowerBoundary = -2147483648;
        int upperBoundary = 2147483647;
        if (x == 0) {
            return 0;
        } else if (numInString.charAt(0) == negativeSign) {
            String unsignedReversedNum = new StringBuilder(numInString.substring(1, lengthOfString)).reverse()
                    .toString();
            long reversedNumInLong = Long.parseLong(negativeSign + unsignedReversedNum);
            return lowerBoundary <= reversedNumInLong && reversedNumInLong <= upperBoundary ? (int) reversedNumInLong
                    : 0;
        } else if (numInString.charAt(endIndex) == '0') {
            String reversedNum = new StringBuilder(numInString.substring(0, endIndex)).reverse().toString();
            long reversedNumInLong = Long.parseLong(reversedNum);
            return lowerBoundary <= reversedNumInLong && reversedNumInLong <= upperBoundary ? (int) reversedNumInLong
                    : 0;
        } else {
            String reversedNum = new StringBuilder(numInString).reverse().toString();
            long reversedNumInLong = Long.parseLong(reversedNum);
            return lowerBoundary <= reversedNumInLong && reversedNumInLong <= upperBoundary ? (int) reversedNumInLong
                    : 0;
        }
    }
}
