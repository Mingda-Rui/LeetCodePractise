package pers.mingda.leetcode;

public class LC1047RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            int tailIndex = sb.length() - 1;
            if (tailIndex < 0 || sb.charAt(tailIndex) != c) {
                sb.append(c);
            } else {
                sb.deleteCharAt(tailIndex);
            }
        }
        return sb.toString();
    }
}
