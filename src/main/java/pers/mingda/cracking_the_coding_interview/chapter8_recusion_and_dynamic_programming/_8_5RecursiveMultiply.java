package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

public class _8_5RecursiveMultiply {
    public int recursiveMultiply(int a, int b, int[] memo) {
        int smaller = Math.min(a, b);
        int larger = Math.max(a, b);
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return larger;
        }

        if (memo[smaller] != 0) {
            return memo[smaller];
        }

        // smaller >= 2
        int halfSmallerFloor = smaller >> 1;
        int halfSum = recursiveMultiply(halfSmallerFloor, larger, memo);
        int secondHalfSum = smaller % 2 == 0 ? halfSum : recursiveMultiply(halfSmallerFloor + 1, larger, memo);
        int sum = halfSum + secondHalfSum;
        memo[smaller] = sum;
        return sum;
    }
}
