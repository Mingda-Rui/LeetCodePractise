package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _17_5LettersAndNumbers {
    char[] findLongestSubarray(char[] array) {
        Map<Integer, Integer> deltasMap = new HashMap<>();
        int delta = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (isLetter(c)) {
                delta++;
            } else {
                delta--;
            }
            if (delta == 0) {
                maxStart = 0;
                maxEnd = i;
            } else if (deltasMap.containsKey(delta)) {
                maxStart = deltasMap.get(delta) + 1;
                maxEnd = i;
            }
            deltasMap.putIfAbsent(delta, i);
        }
        return getSubarray(array, maxStart, maxEnd);
    }

    boolean isLetter(char c) {
        return Character.isLetter(c);
    }

    char[] getSubarray(char[] array, int start, int end) {
        if (start == end) {
            return new char[0];
        }
        return Arrays.copyOfRange(array, start, end + 1);
    }
}
