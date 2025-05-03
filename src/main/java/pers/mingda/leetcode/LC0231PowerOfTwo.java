package pers.mingda.leetcode;

public class LC0231PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return n == (n & -n);
    }
}
