package pers.mingda.leetcode;

public class LC0394DecodeString {
    public String decodeString(String s) {
        int[] indexHolder = {0};
        String modifiedS = "1[" + s + "]";
        return decodeStringRecursive(modifiedS, indexHolder);
    }

    private String decodeStringRecursive(String s, int[] indexHolder) {
        int paraCounter = 0;
        int multiply = 1;
        StringBuilder current = new StringBuilder();
        while (indexHolder[0] < s.length()) {
            char c = s.charAt(indexHolder[0]);
            if (Character.isDigit(c)) {
                if (paraCounter == 0) {
                    multiply = c - '0';
                    while (indexHolder[0] + 1 < s.length() && Character.isDigit(s.charAt(indexHolder[0] + 1))) {
                        multiply = multiply * 10 + (s.charAt(indexHolder[0] + 1) - '0');
                        indexHolder[0]++;
                    }
                } else if (paraCounter == 1) {
                    String part = decodeStringRecursive(s, indexHolder);
                    current.append(part);
                }
            } else if (c == '[') {
                paraCounter++;
            } else if (c == ']') {
                return current.toString().repeat(multiply);
            } else {
                current.append(c);
            }
            indexHolder[0]++;
        }
        return null;
    }
}
