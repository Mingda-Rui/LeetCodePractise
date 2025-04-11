package pers.mingda.leetcode;

public class LC2843CountSymmetricIntegers {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int num = low; num <= high; num++) {
            if (checkSymmetric(num)) {
                count++;
            }
        }
        return count;
    }

    private boolean checkSymmetric(int num) {
        int digits = countDigits(num);
        if (digits % 2 != 0) {
            return false;
        }
        int divider = getDivider(digits / 2);
        return getDigitSum(num % divider) == getDigitSum(num / divider);
    }

    private int countDigits(int num) {
        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private int getDivider(int digit) {
        int divider = 1;
        for (int i = 0; i < digit; i++) {
            divider *= 10;
        }
        return divider;
    }
}
