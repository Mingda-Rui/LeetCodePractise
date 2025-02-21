package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

public class _16_9Operations {
    /* Flip a positive sign to negative or negative sign to pos. */
    int negate(int a) {
        int neg = 0;
        int newSign = a < 0 ? 1 : -1;
        int delta = newSign;
        while (a != 0) {
            boolean differentSigns = (a + delta > 0) != (a > 0);
            if (a + delta != 0 && differentSigns) { // If delta is too big, reset it.
                delta = newSign;
            }
            neg += delta;
            a += delta;
            delta += delta; // Double the delta
        }
        return neg;
    }

    /* Subtract two numbers by negating b and adding them */
    int minus(int a, int b) {
        return a + negate(b);
    }

    int multiply(int a, int b) {
        if (abs(a) < abs(b)) {
            return multiply(b, a); // algorithm is faster if b < a
        }
        if (a == 0 || b == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = abs(b); i > 0; i = minus(i, 1)) {
            sum += a;
        }
        if (b < 0) {
            sum = negate(sum);
        }
        return sum;
    }

    /* Return absolute value */
    int abs(int num) {
        if (num < 0) {
            return negate(num);
        }
        return num;
    }

    int divide(int a, int b) {
        int absA = abs(a);
        int absB = abs(b);

        int count = 0;
        int sum = 0;
        while (absA > sum) {
            sum += absB;
            count++;
        }
        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            return count;
        } else {
            return negate(count);
        }
    }
}
