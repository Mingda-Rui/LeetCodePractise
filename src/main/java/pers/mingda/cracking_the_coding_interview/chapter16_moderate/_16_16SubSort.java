package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.List;

public class _16_16SubSort {
    List<Integer> findUnsortedSequence(int[] array) {
        int leftMostSortedIndex = findLeftmostSorted(array);
        int rightMostSortedIndex = findRightmostSorted(array);

        int minInRight = findMinFrom(array, leftMostSortedIndex);
        int maxInLeft = findMaxTill(array, rightMostSortedIndex);

        int adjustedLeftMost = adjustLeftWithMin(array, leftMostSortedIndex, minInRight);
        int adjustedRightMost = adjustRightWithMax(array, rightMostSortedIndex, maxInLeft);

        return List.of(adjustedLeftMost + 1, adjustedRightMost - 1);
    }

    int findLeftmostSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return i - 1;
            }
        }
        return array.length - 1;
    }

    int findRightmostSorted(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i - 1] > array[i]) {
                return i;
            }
        }
        return 0;
    }

    int findMinFrom(int[] array, int from) {
        int max = 0;
        for (int i = from; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        return max;
    }

    int findMaxTill(int[] array, int till) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= till; i++) {
            min = Math.min(min, array[i]);
        }
        return min;
    }

    int adjustLeftWithMin(int[] array, int leftEndIndex, int min) {
        for (int i = leftEndIndex; i >= 0; i--) {
            if (array[i] <= min) {
                return i;
            }
        }
        return -1;
    }

    int adjustRightWithMax(int[] array, int rightStartIndex, int max) {
        for (int i = rightStartIndex; i < array.length; i++) {
            if (array[i] >= max) {
                return i;
            }
        }
        return array.length;
    }
}
