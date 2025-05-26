package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.Arrays;

public class _16_6SmallestDifference {
  int findSmallestDifference(int[] array1, int[] array2) {
    Arrays.sort(array1);
    Arrays.sort(array2);
    int i = 0, j = 0;
    int smallest = Integer.MAX_VALUE;
    while (i < array1.length && j < array2.length) {
      int diff = Math.abs(array1[i] - array2[j]);
      smallest = Math.min(smallest, diff);
      if (array1[i] < array2[j]) {
        i++;
      } else {
        j++;
      }
    }
    return smallest;
  }
}
