package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _16_6SmallestDifference {
    int findSmallestDifference(int[] array1, int[] array2) {
        int[] sortedArray = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2)).sorted().toArray();
        int smallest = Integer.MAX_VALUE;
        for (int i = 1; i < sortedArray.length; i++) {
            int prev = sortedArray[i - 1];
            smallest = Math.min(smallest, sortedArray[i] - prev);
        }
        return smallest;
    }
}
