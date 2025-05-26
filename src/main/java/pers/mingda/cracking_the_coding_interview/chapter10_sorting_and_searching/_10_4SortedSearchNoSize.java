package pers.mingda.cracking_the_coding_interview.chapter10_sorting_and_searching;

public class _10_4SortedSearchNoSize {

  private Listy list;

  public int findElement(int target) {
    int index = 1;
    while (list.elementAt(index) != -1 && list.elementAt(index) <= target) {
      index *= 2;
    }
    return binarySearch(list, target, index / 2, index);
  }

  private int binarySearch(Listy list, int target, int left, int right) {
    if (left >= right) {
      return -1;
    }

    int mid = (left + right) / 2;
    if (list.elementAt(mid) > target || list.elementAt(mid) == -1) {
      return binarySearch(list, target, left, mid);
    } else if (list.elementAt(mid) < target) {
      return binarySearch(list, target, mid + 1, right);
    } else {
      return mid;
    }
  }
}

class Listy {

  private int[] array;

  public int elementAt(int index) {
    if (index >= array.length) {
      return -1;
    }
    return array[index];
  }

  public int size() {
    throw new UnsupportedOperationException("size/length is not supported");
  }
}
