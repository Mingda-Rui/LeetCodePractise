package pers.mingda.leetcode.util;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;

import java.util.regex.Pattern;

public class NamingHelperWithGuavaDependency {

    private static BiMap<Integer, Character> intToChar = initIntToChar();
    private static final Pattern digitsOnly = Pattern.compile("\\d+");

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
        if (args.length == 0) {
            throw new IllegalArgumentException(
                    "In order to use NamingHelper util, 1 or more args in the following format need to be provided.\n " +
                            "1. Prefix no less than 3 letters, which will be converted to number\n " +
                            "2. Or, number of leetcode problems, which will be converted to prefix");
        }

        for (String arg : args) {
            try {
                parseArg(arg);
            } catch (Exception ex) {
                System.out.println("Arg: " + arg + " can not be processed. Cause by error: " + ex.getCause() + "\n" +
                        "Error message: " + ex.getMessage());
            }
        }
    }

    private static void parseArg(String arg) {
        if (digitsOnly.matcher(arg).matches()) {
            int num = Integer.parseInt(arg);
            String parsedPrefix = getClassPrefixByNum(num);
            System.out.println("Converted from num: " + num + " to prefix: " + parsedPrefix);
        } else {
            int parsedNum = getClassNumByPrefix(arg);
            System.out.println("Converted from prefix: " + arg + " to num: " + parsedNum);
        }
    }
}

// 30 20
// 1 4 20 => A