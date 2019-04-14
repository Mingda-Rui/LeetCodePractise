package pers.mingda.leetcode.utils;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class NamingHelper {

    private static BiMap<Integer, Character> intToChar = initIntToChar();

    private static BiMap<Integer, Character> initIntToChar() {
        intToChar = HashBiMap.create();
        for (int i = 0; i < 26; i ++) {
            intToChar.put(new Integer(i), new Character( (char)('A'+i) ));
        }
        return intToChar;
    }
    
    public static String getClassNamePrefixByNum(int num) {
        // AAA => 0
        // AAB => 1
        // ...
        // AAZ => 25
        // ABA => 26
        if (num < 1 || num > 17576) {
            throw new IllegalArgumentException(
                "Class number should in the field of 1 to 17576 (AAA to ZZZ)");
        }
        StringBuilder sb = new StringBuilder();
        while(num != 0) {
            int result = num / 26;
            int remainder = num % 26;
            num = result;
            sb.append( intToChar.get(new Integer(remainder)) );
        }

        if (sb.length() > 3) 
            throw new IllegalStateException("The lenght of prefix should be no longer than 3, now it is " + sb.length());

        while (sb.length() != 3) {
            sb.append('A');
        }

        String classNamePrefix = sb.reverse().toString();

        return classNamePrefix;
    }

    public static void main(String[] args) {
        System.out.println(getClassNamePrefixByNum(123));
        
    }
}

// 30 20
// 1 4 20 => A