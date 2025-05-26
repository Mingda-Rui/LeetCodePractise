package pers.mingda.cracking_the_coding_interview.chapter1_arrays_and_strings;

/**
 * One Away: Threre are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they
 * are one eidt (or zero) eidts) away. EXAMPLE pale, ple -> true pales, pale -> true pale, bale ->
 * true pale, bae -> false
 */
public class _1_5OneAway {
  // insert:
  // acd
  // abcd
  // remove:
  // abcd
  // acd
  // replace:
  // abcd
  // adcd

  public static boolean isOneAway(String str1, String str2) {
    int lengthDiff = Math.abs(str1.length() - str2.length());
    if (lengthDiff > 1) return false;
    int sameIndex1 = -1;
    int sameCount2 = 0;
    int shorterLen = Math.min(str1.length(), str2.length());
    for (int i = 0; i < shorterLen; i++) {
      if (str1.charAt(i) == str2.charAt(i)) {
        sameIndex1 = i;
      } else {
        break;
      }
    }

    int rest = shorterLen - sameIndex1;
    for (int i = 1; i < rest; i++) {
      if (str1.charAt(str1.length() - i) == str2.charAt(str2.length() - i)) {
        sameCount2 = i;
      } else {
        break;
      }
    }

    int sameCount = sameIndex1 + 1 + sameCount2;
    System.out.println(sameIndex1 + " " + sameCount2);
    int longerLen = Math.max(str1.length(), str2.length());
    return sameCount + 1 == longerLen;
  }

  public static boolean isOneAwayOneDirection(String str1, String str2) {
    if (Math.abs(str1.length() - str2.length()) > 1) return false;

    int diffCount = 0;
    int shorterLen = Math.min(str1.length(), str2.length());
    for (int i = 0, j = 0; Math.min(i, j) < shorterLen; i++, j++) {
      if (str1.charAt(i) != str2.charAt(j)) {
        if (diffCount > 0) return false;
        diffCount++;
        if (str1.length() >= str2.length()) i++;
        if (str2.length() >= str1.length()) j++;
      }
    }
    return true;
  }
}

// ab3cd
// 0121
// abcd

// abcde
