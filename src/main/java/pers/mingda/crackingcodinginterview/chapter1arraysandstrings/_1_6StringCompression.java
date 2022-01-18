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
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            repeatCounter++;
            
            if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i)).append(repeatCounter);
                repeatCounter = 0;
            }
        }
        return sb.length() < str.length() ? sb.toString() : str;
    }
}

// aabbccdd