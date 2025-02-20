package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

public class _16_5FactorialZeros {
    int countFactZeros(int num) {
        int count = 0;
        if (num < 0) {
            return -1;
        }
        for (int i = 5; num / i > 0; i *= 5) {
            count += num / i;
        }
        return count;
    }
}
