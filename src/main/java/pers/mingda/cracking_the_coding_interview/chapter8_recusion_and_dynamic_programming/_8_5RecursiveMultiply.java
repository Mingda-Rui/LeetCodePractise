package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

public class _8_5RecursiveMultiply {
    public int recursiveMultiply(int a, int b) {
        if (Math.abs(b) == 0) {
            return 0;
        } else if (b == 1) {
            return a;
        }
        return recursiveMultiply(a, b - 1) + a;
    }
}
