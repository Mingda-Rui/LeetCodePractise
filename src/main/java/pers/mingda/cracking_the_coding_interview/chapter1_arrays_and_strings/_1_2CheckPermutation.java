package pers.mingda.cracking_the_coding_interview.chapter1_arrays_and_strings;

import java.util.Arrays;

/*
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 * A permutation of a string is another string that contains same characters, only the order of characters can be different.
 */

public class _1_2CheckPermutation {

  /*
   * Note, we need to ask whether the permutation is considered case sensitive.
   * Also, whether white space is significant. e.g. "god   " vs "dog"
   */

  public static boolean checkPermutation(String str1, String str2) {
    if (str1.length() != str2.length()) return false;

    int[] charRecorder = new int[256];
    for (char c : str1.toCharArray()) {
      charRecorder[c]++;
    }

    for (char c : str2.toCharArray()) {
      if (charRecorder[c] == 0) return false;
      charRecorder[c]--;
    }

    for (int i : charRecorder) {
      if (i != 0) return false;
    }
    return true;
  }

  public static boolean checkPermutationSorting(String str1, String str2) {
    if (str1.length() != str2.length()) return false;
    char[] charArr1 = str1.toCharArray();
    char[] charArr2 = str2.toCharArray();
    Arrays.sort(charArr1);
    Arrays.sort(charArr2);
    return Arrays.equals(charArr1, charArr2);
  }
}
