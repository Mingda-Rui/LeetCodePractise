package pers.mingda.cracking_the_coding_interview.chapter10_sorting_and_searching;

import java.util.Arrays;

public class _10_11PeaksAndValleys {
    void sortValleyPeak(int[] array) {
        Arrays.sort(array);
        for (int i = 1; i < array.length; i += 2) {
            swap(array, i - 1, i);
        }
    }

    void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
