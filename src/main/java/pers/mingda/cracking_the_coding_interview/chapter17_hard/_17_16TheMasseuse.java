package pers.mingda.cracking_the_coding_interview.chapter17_hard;

public class _17_16TheMasseuse {
    int maxMinutes(int[] massages) {
        return maxMinutes(massages, 0);
    }

    int maxMinutes(int[] massages, int next) {
        if (next == massages.length) {
            return 0;
        }

        int with = massages[next] + maxMinutes(massages, next + 2);
        int without = maxMinutes(massages, next + 1);
        return Math.max(with, without);
    }
}
