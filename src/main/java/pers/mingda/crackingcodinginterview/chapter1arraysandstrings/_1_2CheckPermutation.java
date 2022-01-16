package pers.mingda.crackingcodinginterview.chapter1arraysandstrings;

/*
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 * A permutation of a string is another string that contains same characters, only the order of characters can be different.
 */

public class _1_2CheckPermutation {

    public static boolean checkPermutation(String str1, String str2) {
        int[] charRecorder = new int[256];
        for (char c: str1.toCharArray()) {
            charRecorder[c] ++;
        }

        for (char c: str2.toCharArray()) {
            if (charRecorder[c] == 0) 
                return false;
            charRecorder[c] --;
        }
        
        for (int i: charRecorder) {
            if (i != 0) 
                return false;
        }
        return true;
    }


}
