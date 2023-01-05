package pers.mingda.leetcode;

public class LC0191NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeight2(int n) {
        int counter = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0)
                counter++;
            mask <<= 1;
        }
        return counter;
    }

    public int hammingWeight3(int n) {
        int counter = 0;
        while (n != 0) {
            counter++;
            n &= n - 1;
        }
        return counter;
    }
}
