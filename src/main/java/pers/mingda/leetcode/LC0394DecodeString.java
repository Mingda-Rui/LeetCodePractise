package pers.mingda.leetcode;

public class LC0394DecodeString {
    public String decodeString(String s) {
        int[] indexHolder = {0};
        String modifiedS = "1[" + s + "]";
        return decodeStringRecursive(modifiedS, indexHolder);
    }

    private String decodeStringRecursive(String s, int[] indexHolder) {
        StringBuilder current = new StringBuilder();
        int multiply = 0;
        while (indexHolder[0] < s.length()) {
            char c = s.charAt(indexHolder[0]);
            if (Character.isDigit(c)) {
                multiply = multiply * 10 + (c - '0');
            } else if (c == '[') {
                indexHolder[0]++;
                String part = decodeStringRecursive(s, indexHolder);
                current.append(part.repeat(multiply));
                multiply = 0;
            } else if (c == ']') {
                return current.toString();
            } else {
                current.append(c);
            }
            indexHolder[0]++;
        }
        return null;
    }
}
