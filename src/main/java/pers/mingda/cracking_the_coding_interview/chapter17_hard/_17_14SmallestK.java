package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.Arrays;

public class _17_14SmallestK {
    int[] smallestK(int[] array, int k) {
        Arrays.sort(array);
        return Arrays.copyOf(array, k);
    }
}
