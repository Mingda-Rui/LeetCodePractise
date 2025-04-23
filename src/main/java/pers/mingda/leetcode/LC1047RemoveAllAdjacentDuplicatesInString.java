package pers.mingda.leetcode;

public class LC1047RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int tailIndex = sb.length() - 1;
            if (tailIndex < 0 || sb.charAt(tailIndex) != c) {
                sb.append(c);
            } else {
                sb.deleteCharAt(tailIndex);
            }
        }
        return sb.toString();
    }

    public String removeDuplicatesTwoPointers(String s) {
        char[] arr = s.toCharArray();
        int current = 0;
        for (int i = 1; i < arr.length; i++) {
            if (current < 0 || arr[current] != arr[i]) {
                current++;
                arr[current] = arr[i];
            } else {
                current--;
            }
        }
        return String.valueOf(arr, 0, current + 1);
    }
}
