package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.HashMap;
import java.util.Map;

public class _17_6CountOf2s {
    int numberOf2sInRange(int n) {
        int count = 0;
        Map<Integer, Integer> countOfTwoMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            count += numberOf2s(i, countOfTwoMap);
        }
        return count;
    }

    int numberOf2s(int n, Map<Integer, Integer> countOfTwoMap) {
        int count = 0;
        while (n > 0) {
            if (countOfTwoMap.containsKey(n)) {
                count += countOfTwoMap.get(n);
            }
            int leastSignificantDigit = n % 10;
            if (leastSignificantDigit == 2) {
                count++;
            }
            n /= 10;
        }
        countOfTwoMap.put(n, count);
        return count;
    }
}
