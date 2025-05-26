package pers.mingda.cracking_the_coding_interview.chapter10_sorting_and_searching;

import java.util.Arrays;

public class _10_11PeaksAndValleys {

  void sortValleyPeak(int[] array) {
    Arrays.sort(array);
    for (int i = 1; i < array.length; i += 2) {
      swap(array, i - 1, i);
    }
  }

  void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }

  void sortValleyPeakOptimized(int[] array) {
    for (int i = 1; i < array.length; i += 2) {
      int biggestIndex = maxIndex(array, i - 1, i, i + 1);
      if (i != biggestIndex) {
        swap(array, i, biggestIndex);
      }
    }
  }

  int maxIndex(int[] array, int a, int b, int c) {
    int len = array.length;
    int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
    int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
    int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;

    int max = Math.max(aValue, Math.max(bValue, cValue));
    if (aValue == max) return a;
    else if (bValue == max) return b;
    else return c;
  }
}
