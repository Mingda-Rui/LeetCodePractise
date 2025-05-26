package pers.mingda.cracking_the_coding_interview.chapter17_hard;

public class _17_3RandomSet {
  int[] pickMIteratively(int[] original, int m) {
    int[] subset = new int[m];

    /* File in subset array with first part of original array */
    for (int i = 0; i < m; i++) {
      subset[i] = original[i];
    }

    /* Go through rest of original array. */
    for (int i = m; i < original.length; i++) {
      int k = rand(0, i); // Random # between 0 and i, inclusive
      if (k < m) {
        subset[k] = original[i];
      }
    }
    return subset;
  }

  int rand(int min, int max) {
    return min + (int) (Math.random() * (max - min) + 1);
  }
}
