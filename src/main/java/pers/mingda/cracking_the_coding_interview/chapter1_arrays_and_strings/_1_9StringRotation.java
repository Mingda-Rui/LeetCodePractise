package pers.mingda.cracking_the_coding_interview.chapter1_arrays_and_strings;

/**
 * String Rotation: Assume you have a method isSubstring which checks if one word is a substring
 * of another, Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 * call to isSubstring 
 */

public class _1_9StringRotation {


    /**
     * SOLUTION:
     * s1 == xy = waterbottle
     * x = wat
     * y = erbottle
     * s2 = yx = erbottlewat
     * s1s1 = waterbottlewaterbottle
     * isSubstring(s1s1, s2) == true if s1&s2 is rotation strings.
     */
    public static boolean stringRotation(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        
        String str1str1 = str1 + str1;
        return isSubstring(str1str1, str2);
    }

    public static boolean isSubstring(String str1, String str2) {
        return str1.contains(str2);
    }
}

// a b c d
//   b c d a
//     c d a b