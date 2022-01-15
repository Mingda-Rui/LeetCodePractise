package pers.mingda.crackingcodinginterview.chapter1arraysandstrings;

import java.util.Arrays;

/* Is Unique: Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures? 
 * */

public class _1_1IsUnique {
    
    public boolean isUniqueBrutalForce(String str) {
        int strLength = str.length();
        for (int i = 0; i < strLength; i++) {
            for (int j = i + 1; j < strLength; j++) {
                if (str.charAt(i) == str.charAt(j))
                    return false;
            }
        }
        return true;
    }

    public boolean isUniqueSorting(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = 1; i < str.length(); i++) {
            if (chars[i - 1] == chars[i])
                return false;
        }
        return true;
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