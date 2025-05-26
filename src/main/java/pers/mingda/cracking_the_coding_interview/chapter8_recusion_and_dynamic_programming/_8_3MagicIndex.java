package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

public class _8_3MagicIndex {

  public int findMagicIndex(int[] array) {
    return findMagicIndex(array, 0, array.length);
  }

  public int findMagicIndex(int[] array, int from, int to) {
    int index = (from + to) / 2;
    if (from + 1 == to) {
      return array[index] == index ? index : -1;
    }
    return array[index] > index
      ? findMagicIndex(array, from, index)
      : findMagicIndex(array, index, to);
  }

  public int magicFastNonDistinctVal(int[] array, int start, int end) {
    if (end < start) return -1;

    int midIndex = (start + end) / 2;
    int midValue = array[midIndex];
    if (midValue == midIndex) {
      return midIndex;
    }

    /* Search left */
    int leftIndex = Math.min(midIndex - 1, midValue);
    int left = magicFastNonDistinctVal(array, start, leftIndex);
    if (left >= 0) return left;

    /* Search right */
    int rightIndex = Math.max(midIndex + 1, midValue);
    return magicFastNonDistinctVal(array, rightIndex, end);
  }
}
