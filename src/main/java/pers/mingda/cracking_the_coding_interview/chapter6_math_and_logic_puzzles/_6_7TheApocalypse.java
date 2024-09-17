package pers.mingda.cracking_the_coding_interview.chapter6_math_and_logic_puzzles;

public class _6_7TheApocalypse {
    // 1/2 girl
    // 1/4 boy girl
    // 1/8 boy boy girl
    // 1/16 boy boy girl

    // girl = 1 * 1/2 + 1/2 * 1/4 + 1/3 * 1/8 + 1/4 * 1/16 + ... + 1/x * 1/2^x
    // boy  =           1/2 * 1/4 + 2/3 * 1/8 + 3/4 * 1/16 + ... + (x - 1)/x * 1/2^x

    // girl - boy =
    //        1 * 1/2 - 0 - 1/3 * 1/8 - 2/4 * 1/16 - ... - (x - 2)/x * 1/2^x

    public double simulate(int families, int precision) {
        double simulatedBoys = simulateBoys(families, precision);
        double simulatedGirls = simulateGirls(families, precision);
        return simulatedBoys/simulatedGirls;
    }

    private double simulateBoys(int families, int precision) {
        double boyPossibility = 0;
        for (int i = 0; i < precision; i++) {
            boyPossibility += i * (1 / Math.pow(2, i + 1));
        }
        return families * boyPossibility;
    }

    private double simulateGirls(int families, int precision) {
        double girlPossibility = 0;
        for (int i = 0; i < precision; i++) {
            girlPossibility += 1 / Math.pow(2, i + 1);
        }
        return families * girlPossibility;
    }
}
