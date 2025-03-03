package pers.mingda.cracking_the_coding_interview.chapter17_hard;

public class _17_19MissingTwo {
    int missingOne(int[] array) {
        int expectedNum = array.length + 1;
        int expectedSum = (1 + expectedNum) * (expectedNum) / 2;
        for (int num: array) {
            expectedSum -= num;
        }
        return expectedSum;
    }

    int[] missingTwo(int[] array) {
        int max_value = array.length + 2;
        int rem_square = squareSumToN(max_value, 2);
        int rem_one = max_value * (max_value + 1) / 2;

        for (int i = 0; i < array.length; i++) {
            rem_square -= array[i] * array[i];
            rem_one -= array[i];
        }

        return solveEquation(rem_one, rem_square);
    }

    int squareSumToN(int n, int power) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (int) Math.pow(i, power);;
        }
        return sum;
    }

    int[] solveEquation(int r1, int r2) {
        /* ax^2 + bx + x
         * -->
         * x = [-b +- sqrt(b^2 - 4ac)] / 2a
         * In this case, it has to be a + not a - */
         int a = 2;
         int b = -2 * r1;
         int c = r1 * r1 - r2;

         double part1 = -1 * b;
         double part2 = Math.sqrt(b*b - 4 * a * c);
         double part3 = 2 * a;

         int solutionX = (int) ((part1 + part2) / part3);;
         int solutionY = r1 - solutionX;

        return new int[]{solutionX, solutionY};
    }
}
