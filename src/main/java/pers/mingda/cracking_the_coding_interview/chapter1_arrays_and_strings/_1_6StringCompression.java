package pers.mingda.cracking_the_coding_interview.chapter1_arrays_and_strings;

/*
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */

public class _1_6StringCompression {

  public static String stringCompression(String str) {
    int repeatCounter = 0;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
      repeatCounter++;

      if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
        sb.append(str.charAt(i)).append(repeatCounter);
        repeatCounter = 0;
      }
    }
    return sb.length() < str.length() ? sb.toString() : str;
  }

  public static String stringCompressionCountFirst(String str) {
    int consecutiveCounter = 0;
    int compressedLenth = 0;
    for (int i = 0; i < str.length(); i++) {
      consecutiveCounter++;
      if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
        compressedLenth += 1 + String.valueOf(consecutiveCounter).length();
        consecutiveCounter = 0;
      }
    }
    if (compressedLenth >= str.length()) return str;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      consecutiveCounter++;
      if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
        sb.append(str.charAt(i)).append(consecutiveCounter);
        consecutiveCounter = 0;
      }
    }

    return sb.toString();
  }
}

// aabbccdd
