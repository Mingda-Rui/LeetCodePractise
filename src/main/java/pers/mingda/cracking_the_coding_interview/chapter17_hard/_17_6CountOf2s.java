package pers.mingda.cracking_the_coding_interview.chapter17_hard;

public class _17_6CountOf2s {
    int numberOf2s(int n) {
        int count = 0;
        while (n > 0) {
            int leastSignificantDigit = n % 10;
            if (leastSignificantDigit == 2) {
                count++;
            }
            n /= 10;
        }
        return count;
    }
}
