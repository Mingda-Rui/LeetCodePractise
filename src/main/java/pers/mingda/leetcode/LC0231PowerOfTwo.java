package pers.mingda.leetcode;

public class LC0231PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        while (n != 0) {
            if (n % 2 != 0) {
                return n == 1;
            }
            n /= 2;
        }
        return false;
    }
}
