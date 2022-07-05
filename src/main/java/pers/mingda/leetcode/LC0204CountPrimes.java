package pers.mingda.leetcode;

public class LC0204CountPrimes {
    public int countPrimes(int n) {
        boolean[] record = new boolean[n];
        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (!record[i]) {
                counter++;
                for (int j = i + i; j < n; j += i)
                    record[j] = true;
            }
        }
        return counter;
    }
}
