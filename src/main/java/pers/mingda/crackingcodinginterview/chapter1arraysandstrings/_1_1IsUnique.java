package pers.mingda.crackingcodinginterview.chapter1arraysandstrings;

/* Is Unique: Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures? 
 * */

public class _1_1IsUnique {
    
    public boolean isUnique(String str) {
        
        return false;
    }

    public boolean isUniqueWithArrys(String str) {
        // approvement: if the string is longer than 128/256 chars
        // it has to have duplications.
        if (str.length() > 256)
            return false;
        
        // approvement: boolean array could be better
        int[] charRecorder = new int[255];
        for (char c: str.toCharArray()) {
            if (charRecorder[c] != 0) return false;
            charRecorder[c] = 1;
        }

        return true;
    }
}