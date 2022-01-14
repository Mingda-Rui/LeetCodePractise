package pers.mingda.crackingcodinginterview.chapter1arraysandstrings;

/* Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures? 
 * */

public class _1_1IsUnique {
    
    public boolean isUnique(String str) {
        return false;
    }

    public boolean isUniqueWithArrys(String str) {
        int[] charRecorder = new int[255];
        for (char c: str.toCharArray()) {
            if (charRecorder[c] != 0) return false;
            charRecorder[c] = 1;
        }

        return true;
    }
}