package pers.mingda.leetcode;

public class LC0050PowXN {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        double result = 1;
        for (int i = 1; i <= Math.abs(n); i++)
            result *= x;
        return n > 0 ? result : 1 / result;
    }
}
