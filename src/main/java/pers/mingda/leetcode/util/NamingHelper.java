package pers.mingda.leetcode.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * In Github UI, classes in the same package are sorted by class name initials.
 * If we want the leetcode problem sorted in the same order with their problem number,
 * we need to covert the problem number to string,
 * and make sure github orders those string in the same way with the problem number's order.<br>
 * `NamingHelper` helps to convert the problem number to a prefix, so that we can prefix each class name with the prefix,
 * and those classes will be ordered in UI in the same way with their problem number.
 * It can also convert the prefix back to problem number.
 */
public class NamingHelper {

    private static final Map<Integer, Character> intToChar = initIntToChar();
    private static final Map<Character, Integer> charToInt = initCharToInt();
    private static final Pattern digitsOnly = Pattern.compile("\\d+");

    private static Map<Integer, Character> initIntToChar() {
        Map<Integer, Character> intToChar = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            intToChar.put(i, (char) ('A' + i));
        }
        return Collections.unmodifiableMap(intToChar);
    }

    private static Map<Character, Integer> initCharToInt() {
        Map<Character, Integer> charToInt = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            charToInt.put((char) ('A' + i), i);
        }
        return Collections.unmodifiableMap(charToInt);
    }

    public static String getClassPrefixByNum(int num) {
        // AAA => 0000
        // AAB => 0001
        // ...
        // AAZ => 0025
        // ABA => 0026
        if (num < 1 || num > 17575) {
            throw new IllegalArgumentException("Class number should be in the field of 1 to 17576 (AAA to ZZZ)");
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int result = num / 26;
            int remainder = num % 26;
            num = result;
            sb.append(intToChar.get(remainder));
        }

        if (sb.length() > 3) {
            throw new IllegalStateException(
                    "The length of prefix should be no longer than 3, now it is " + sb.length());
        }

        while (sb.length() != 3) {
            sb.append('A');
        }

        return sb.reverse().toString();
    }

    public static int getClassNumByPrefix(String prefix) {
        int num = 0;
        for (Character ch : normalizePrefix(prefix).toCharArray()) {
            int temp = charToInt.get(ch);
            num = num * 26 + temp;
        }
        return num;
    }

    private static String normalizePrefix(String prefix) {
        String normalizedPrefix = prefix;
        if (prefix == null || !prefix.matches("[a-zA-Z]{1,3}")) {
            throw new IllegalArgumentException("Illegal prefix format. The prefix should consist of 3 letters");
        } else if (prefix.length() < 3) {
            normalizedPrefix = "A".repeat(3 - (prefix.length())) + prefix;
        }
        return normalizedPrefix;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException(
                    "In order to use NamingHelper util, 1 or more args in the following format need to be provided.\n "
                            + "1. Prefix no less than 3 letters, which will be converted to number\n "
                            + "2. Or, number of leetcode problems, which will be converted to prefix");
        }

        for (String arg : args) {
            try {
                parseArg(arg);
            } catch (Exception ex) {
                System.out.println("Arg: " + arg + " can not be processed. Cause by error: " + ex.getCause() + "\n"
                        + "Error message: " + ex.getMessage());
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
