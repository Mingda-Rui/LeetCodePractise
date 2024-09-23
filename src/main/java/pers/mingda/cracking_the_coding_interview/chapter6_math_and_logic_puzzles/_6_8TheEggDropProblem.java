package pers.mingda.cracking_the_coding_interview.chapter6_math_and_logic_puzzles;

public class _6_8TheEggDropProblem {

    private static final int TOTAL_FLOORS = 100;

    public int findMinimumWorstCase() {
        int min = 100;
        for (int i = 1; i < 100; i++) {
            int total = simulateSteps(i);
            if (total < min) {
                min = total;
            }
        }
        return min;
    }

    private int simulateSteps(int step) {
        int largeSteps = TOTAL_FLOORS / step;
        return largeSteps + (step - 2);
    }
}
