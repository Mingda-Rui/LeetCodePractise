package pers.mingda.crackingcodinginterview.chapter1arraysandstrings;

/**
 * String Rotation: Assume you have a method isSubstring which checks if one word is a substring
 * of another, Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 * call to isSubstring 
 */

public class _1_9StringRotation {
    
    public static boolean isSubstring(String str1, String str2) {
        return str1.contains(str2);
    }
}
