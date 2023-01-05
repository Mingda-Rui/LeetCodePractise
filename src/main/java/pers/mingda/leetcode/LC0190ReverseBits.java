package pers.mingda.leetcode;

public class LC0190ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    public int reverseBits2(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += (n & 1);
            n >>= 1;
        }
        return result;
    }
}
