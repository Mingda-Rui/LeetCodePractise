package pers.mingda.cracking_the_coding_interview.chapter17_hard;

public class _17_10MajorityElement {
    int findMajorityElement(int[] array) {
        int delta = 0;
        int index = 0;
        int current = 0;
        while (index < array.length) {
            if (delta == 0) {
                current = array[index];
                delta++;
            } else if (array[index] == current) {
                delta++;
            } else {
                delta--;
            }
            index++;
        }
        if (delta == 0 || !validMajorityElement(array, current)) {
            return 0;
        } else {
            return current;
        }
    }

    boolean validMajorityElement(int[] array, int target) {
        int count = 0;
        for (int num: array) {
            if (num == target) {
                count++;
            }
        }
        return count > array.length / 2;
    }
}
