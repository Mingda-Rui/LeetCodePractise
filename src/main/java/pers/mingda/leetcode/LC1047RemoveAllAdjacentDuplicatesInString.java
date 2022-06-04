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

    public String removeDuplicatesTwoPointers(String s) {
        char[] arr = s.toCharArray();
        int current = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[current] == arr[i]) {
                if (current == 0) {
                    if (i == arr.length - 1) {
                        return "";
                    } else {
                        i++;
                        arr[current] = arr[i];
                    }
                } else {
                    current--;
                }
            } else {
                current++;
                arr[current] = arr[i];
            }
        }

        return String.valueOf(arr, 0, current + 1);
    }
}
