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
}
