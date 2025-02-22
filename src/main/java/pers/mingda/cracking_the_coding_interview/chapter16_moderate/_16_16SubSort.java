package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.Arrays;
import java.util.List;

public class _16_16SubSort {
    List<Integer> findUnsortedSequence(int[] array) {
        int[] sorted = Arrays.copyOf(array, array.length);
        Arrays.sort(sorted);
        int findLeft = -1;
        for (int i = 0; i < sorted.length - 1; i++) {
            if (sorted[i] != array[i]) {
                findLeft = i;
                break;
            }
        }
        if (findLeft == -1) {
            return List.of();
        }

        int findRight = -1;
        for (int i = sorted.length - 1; i >= 0; i--) {
            if (sorted[i] != array[i]) {
                findRight = i;
                break;
            }
        }
        return List.of(findLeft, findRight);
    }
}
