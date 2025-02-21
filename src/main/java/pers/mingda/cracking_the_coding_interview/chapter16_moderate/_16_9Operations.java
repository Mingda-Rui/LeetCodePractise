package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

public class _16_9Operations {
    /* Flip a positive sign to negative or negative sign to pos. */
    int negate(int a) {
        int neg = 0;
        int newSign = a < 0 ? 1 : -1;
        while (a != 0) {
            neg += newSign;
            a += newSign;
        }
        return neg;
    }

    /* Subtract two numbers by negating b and adding them */
    int minus(int a, int b) {
        return a + negate(b);
    }
}
