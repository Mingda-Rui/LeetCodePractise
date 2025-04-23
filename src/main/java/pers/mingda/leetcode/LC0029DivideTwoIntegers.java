package pers.mingda.leetcode;

public class LC0029DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        else if (divisor == 1) return dividend;
        else if (divisor == -1) return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);
        int positiveResult = (int) binarySearch(dividendL, divisorL);
        boolean isSameSign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        return isSameSign ? positiveResult : -positiveResult;
    }

    private long binarySearch(long dividend, long divisor) {
        long start = 0;
        long end = dividend + 1;
        long mid = start;
        while (start < end) {
            mid = (start + end) / 2;

            int counter = 0;
            int sum = 0;
            while (sum + mid <= dividend) {
                counter++;
                sum += mid;
            }

            if (counter == divisor && sum == dividend) return mid;
            else if (counter < divisor) end = mid;
            else start = mid + 1;
        }
        return mid;
    }

    public int divideBitManipulation(int dividend, int divisor) {

        while (dividend >> 1 != 0 && divisor >> 1 != 0) {
            dividend = dividend >> 1;
            divisor = divisor >> 1;
        }

        return dividend / divisor;
    }

    private boolean isEvenNum(int num) {
        int halfNum = num >> 1;
        return halfNum + halfNum == num;
    }
}