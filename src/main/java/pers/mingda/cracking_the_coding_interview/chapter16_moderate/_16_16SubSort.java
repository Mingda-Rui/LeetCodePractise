package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.List;

public class _16_16SubSort {

  List<Integer> findUnsortedSequence(int[] array) {
    int leftMostSortedIndex = findLeftmostSorted(array);
    if (leftMostSortedIndex == array.length - 1) {
      // already sorted
      return List.of();
    }
    int rightMostSortedIndex = findRightmostSorted(array);

    int minInRight = array[rightMostSortedIndex];
    int maxInLeft = array[leftMostSortedIndex];
    for (int i = leftMostSortedIndex + 1; i < rightMostSortedIndex; i++) {
      minInRight = Math.min(minInRight, array[i]);
      maxInLeft = Math.max(maxInLeft, array[i]);
    }

    int adjustedLeftMost = adjustLeftWithMin(
      array,
      leftMostSortedIndex,
      minInRight
    );
    int adjustedRightMost = adjustRightWithMax(
      array,
      rightMostSortedIndex,
      maxInLeft
    );

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
