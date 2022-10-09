package pers.mingda.leetcode;

public class LC0066PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            int val = digits[i];
            digits[i] = (val + 1) % 10;
            if (digits[i] != 0)
                return digits;
        }

        int[] result = new int[len + 1];
        result[0] = 1;
        return result;
    }
}
