package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

public class _16_7NumberMax {
    /* Flips a 1 to a 0 and a 0 to a 1 */
    int flip(int bit) {
        return 1^bit;
    }

    /* Returns 1 if a is positive, and 0 if a is negative */
    int sign(int a) {
        return flip((a >> 31) & 0x1);
    }

    int getMaxNaive(int a, int b) {
        int k = sign(a - b);
        int q = flip(k);
        return a * k + b * q;
    }
}
