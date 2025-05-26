package pers.mingda.cracking_the_coding_interview.chapter1_arrays_and_strings;

/*
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of
 * a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
 * permutation is a rearrangement of letters. The palindrome does not need to be limited to just
 * dictionary words.
 * EXAMPLE
 * Input:   Tact Coa
 * Output:  True(permutation:"taco cat","atco cta", etc.)
 */

public class _1_4PalindromePermutation {

  public static boolean palindromePermutationCaseSensitive(String str) {
    return palindromePermutation(str, true);
  }

  public static boolean palindromePermutationCaseInsensitive(String str) {
    return palindromePermutation(str, false);
  }

  private static boolean palindromePermutation(
    String str,
    boolean caseSensitive
  ) {
    int[] charCounter = new int[256];
    int oddCounter = 0;
    for (char c : str.toCharArray()) {
      if (c == ' ') continue;
      if (!caseSensitive) c = Character.toLowerCase(c);
      charCounter[c]++;
    }

    for (int i : charCounter) {
      if (i % 2 != 0) oddCounter++;
      if (oddCounter > 1) return false;
    }
    return true;
  }
}
