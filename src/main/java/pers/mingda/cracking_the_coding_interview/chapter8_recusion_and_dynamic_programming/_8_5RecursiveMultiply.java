package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

public class _8_5RecursiveMultiply {
    public int recursiveMultiply(int a, int b) {
        int smaller = Math.min(a, b);
        int larger = Math.max(a, b);
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return larger;
        }

        // smaller >= 2
        int halfSmallerFloor = smaller >> 1;
        int halfSum = recursiveMultiply(halfSmallerFloor, larger);
        int sum = halfSum + halfSum;
        return smaller % 2 == 0 ? sum : sum + larger;
    }
}
