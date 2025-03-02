package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _17_14SmallestK {
    int[] smallestK(int[] array, int k) {
        Arrays.sort(array);
        return Arrays.copyOf(array, k);
    }

    int[] smallestKMaxHeap(int[] array, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : array) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    int[] smallestKSelectionRank(int[] array, int k) {
        return selectionSort(array, k - 1, 0, array.length);
    }

    int[] selectionSort(int[] array, int targetIndex, int start, int boundary) {
        int pivotIndex = start;
        for (int i = start + 1; i < boundary; i++) {
            if (array[i] <= array[pivotIndex]) {
                swap(array, i, pivotIndex);
                pivotIndex = i;
            }
        }
        if (pivotIndex != boundary - 1 && array[boundary - 1] <= array[pivotIndex]) {
            pivotIndex = boundary - 1;
        }

        if (pivotIndex < targetIndex) {
            return selectionSort(array, targetIndex - pivotIndex, pivotIndex + 1, boundary);
        } else if (pivotIndex > targetIndex) {
            return selectionSort(array, targetIndex, start, pivotIndex);
        } else {
            return Arrays.copyOf(array, pivotIndex);
        }
    }

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
