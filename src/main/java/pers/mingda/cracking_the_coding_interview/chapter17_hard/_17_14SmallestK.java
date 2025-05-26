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
    int threshold = selectionSort(array, k, 0, array.length);
    return generateResult(array, k, threshold);
  }

  int selectionSort(int[] array, int targetSize, int start, int boundary) {
    SmallestKPartitionResult result = partition(
      array,
      array[start],
      start,
      boundary
    );
    int totalLeft = result.leftSize;
    int totalMiddle = result.leftSize + result.middleSize;

    if (totalLeft > targetSize) {
      return selectionSort(array, targetSize, start, start + totalLeft);
    } else if (totalMiddle < targetSize) {
      return selectionSort(
        array,
        targetSize - totalMiddle,
        start + totalMiddle,
        boundary
      );
    }
    return array[start + totalMiddle];
  }

  int[] generateResult(int[] array, int targetSize, int threshold) {
    int[] result = new int[targetSize];
    int resultIndex = 0;
    for (int val : array) {
      if (val < threshold) {
        result[resultIndex] = val;
        resultIndex++;
      }
    }
    for (int i = resultIndex; i < result.length; i++) {
      result[resultIndex] = threshold;
    }

    return result;
  }

  /* Partition result into < pivot, equal to pivot -> bigger than pivot. */
  SmallestKPartitionResult partition(
    int[] array,
    int pivot,
    int start,
    int end
  ) {
    int left = start;/* Stays at (right) edge of left side. */
    int right = end;/* Stays at (left) edge of right side. */
    int middle = start;/* Stays at (right) edge of middle. */
    while (middle <= right) {
      if (array[middle] < pivot) {
        /* Middle is smaller than the pivot. Left is either smaller or equal to
         * the pivot. Either way, swap them. Then middle and left should move by
         * one. */
        swap(array, middle, left);
        middle++;
        left++;
      } else if (array[middle] > pivot) {
        /* Middle is bigger than the pivot. Right could have any value. Swap them,
         * then we know that the new right is bigger than the pivot. Move right by
         * one. */
        swap(array, middle, right);
        right--;
      } else if (array[middle] == pivot) {
        /* Middle is equal to the pivot. Move by one. */
        middle++;
      }
    }
    /* Return sizes of left and middle. */
    return new SmallestKPartitionResult(left - start, right - left + 1);
  }

  void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

class SmallestKPartitionResult {

  int leftSize, middleSize;

  public SmallestKPartitionResult(int left, int middle) {
    this.leftSize = left;
    this.middleSize = middle;
  }
}
