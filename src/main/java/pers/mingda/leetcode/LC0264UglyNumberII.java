package pers.mingda.leetcode;

public class LC0264UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        int current = 0;
        uglyNums[current] = 1;
        int p2 = current;
        int p3 = current;
        int p5 = current;
        while (current != n - 1) {
            int next2 = uglyNums[p2] * 2;
            int next3 = uglyNums[p3] * 3;
            int next5 = uglyNums[p5] * 5;
            int next = 0;
            if (next2 <= next3 && next2 <= next5) {
                next = next2;
                p2++;
            } else if (next3 <= next2 && next3 <= next5) {
                next = next3;
                p3++;
            } else {
                next = next5;
                p5++;
            }
            if (uglyNums[current] < next)
                current++;
            uglyNums[current] = next;

        }
        return uglyNums[n - 1];
    }
}
