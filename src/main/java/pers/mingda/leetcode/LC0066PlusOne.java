package pers.mingda.leetcode;

public class LC0066PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int len = digits.length;
        digits[len - 1] += 1;
        for (int i = len - 1; i >= 0; i--) {
            int val = digits[i] + carry;
            digits[i] = val % 10;
            if (val <= 9) {
                carry = 0;
                break;
            }

            carry = 1;
        }
        if (carry == 1) {
            int[] result = new int[len + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++)
                result[i] = digits[i - 1];
            return result;
        }
        return digits;
    }
}
