package pers.mingda.crackingcodinginterview.chapter1arraysandstrings;

/*
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */

public class _1_6StringCompression {

    public static String stringCompression(String str) {
        int repeatCounter = 0;
        int currentLen = 0;
        char previous = str.charAt(0);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (previous == c) {
                repeatCounter ++;
            }
            if (previous != c || i == str.length() - 1) {
                sb.append(previous).append(repeatCounter);
                currentLen += 2;
                previous = c;
                repeatCounter = 1;
            }
        }
        return currentLen < str.length() ? sb.toString() : str;
    }
}

// aabbccdd