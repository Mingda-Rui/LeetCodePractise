package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC0202HappyNumber {
    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        while (!seen.contains(n)) {
            seen.add(n);
            n = calcHappyNumber(n, map);
            if (n == 1) return true;
        }
        return false;
    }

    private int calcHappyNumber(int n, Map<Integer, Integer> map) {
        int sum = 0;
        while (n != 0) {
            int val = n % 10;
            n /= 10;
            if (!map.containsKey(val)) map.put(val, val * val);
            int square = map.get(val);
            sum += square;
        }
        return sum;
    }
}
