package pers.mingda.leetcode.util;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;

public class NamingHelperWithGuavaDependency {

    private static BiMap<Integer, Character> intToChar = initIntToChar();

    private static BiMap<Integer, Character> initIntToChar() {
        intToChar = HashBiMap.create();
        for (int i = 0; i < 26; i ++) {
            intToChar.put(i, (char) ('A' + i));
        }
        return intToChar;
    }
    
    public static String getClassPrefixByNum(int num) {
        // AAA => 0
        // AAB => 1
        // ...
        // AAZ => 25
        // ABA => 26
        if (num < 1 || num > 17575) {
            throw new IllegalArgumentException(
                "Class number should in the field of 1 to 17576 (AAA to ZZZ)");
        }
        StringBuilder sb = new StringBuilder();
        while(num != 0) {
            int result = num / 26;
            int remainder = num % 26;
            num = result;
            sb.append( intToChar.get(remainder) );
        }

        if (sb.length() > 3) 
            throw new IllegalStateException("The length of prefix should be no longer than 3, now it is " + sb.length());

        while (sb.length() != 3) {
            sb.append('A');
        }

        return sb.reverse().toString();
    }

    public static int getClassNumByPrefix(String prefix) {

        int num = 0;

        for (Character ch: Lists.charactersOf(prefix)) {
            int temp = intToChar.inverse().get(ch);

            num = num * 26 + temp;
        }
        return num;
    }

    public static void main(String[] args) {

        String prefix = "AAD";
        int num = 7;

        System.out.println("Converted from prefix: " + prefix + " to num: " + getClassNumByPrefix(prefix));
        System.out.println("Converted from num: " + num + " to prefix: " + getClassPrefixByNum(num));
        
    }
}

// 30 20
// 1 4 20 => A