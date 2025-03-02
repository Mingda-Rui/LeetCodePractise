package pers.mingda.cracking_the_coding_interview.chapter17_hard;

public class _17_16TheMasseuse {
    int maxMinutes(int[] massages) {
        int first = maxMinutes(massages, 0, 15);
        int second = maxMinutes(massages, 1, 15);
        return Math.max(first, second);
    }

    int maxMinutes(int[] massages, int next, int restTime) {
        if (next == massages.length) {
            return 0;
        }
        if (restTime <= 0) {
            return massages[next] + maxMinutes(massages, next + 1, 15);
        } else {
            return maxMinutes(massages, next + 1, massages[next] - 15);
        }
    }
}
