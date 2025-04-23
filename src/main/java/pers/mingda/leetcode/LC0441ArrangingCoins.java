package pers.mingda.leetcode;

public class LC0441ArrangingCoins {}

class LC0441Solution {
    public int arrangeCoins(int n) {
        if (n == 1) return 1;
        long start = 1;
        long end = n;

        while (start < end) {
            long mid = start + (end - start) / 2;
            long sum = (1 + mid) * mid / 2;
            if (sum > n) {
                end = mid;
            } else if (sum < n) {
                start = mid + 1;
            } else {
                return (int) mid;
            }
        }
        return (int) start - 1;
    }
}