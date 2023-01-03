package pers.mingda.leetcode;

public class LC0264UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        int num2 = 2;
        int num3 = 3;
        int num5 = 5;
        for (int i = 1; i < n; i++) {
            int min = getMin(num2, num3, num5);
            uglyNums[i] = min;
            if (num2 == min) {
                index2++;
                num2 = uglyNums[index2] * 2;
            }
            if (num3 == min) {
                index3++;
                num3 = uglyNums[index3] * 3;
            }
            if (num5 == min) {
                index5++;
                num5 = uglyNums[index5] * 5;
            }
        }
        return uglyNums[n - 1];
    }

    private int getMin(int num1, int num2, int num3) {
        return Math.min(num1, Math.min(num2, num3));
    }
}
