package pers.mingda.leetcode;

public class LC0191NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
