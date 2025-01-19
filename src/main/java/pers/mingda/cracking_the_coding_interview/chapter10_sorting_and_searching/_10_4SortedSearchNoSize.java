package pers.mingda.cracking_the_coding_interview.chapter10_sorting_and_searching;

public class _10_4SortedSearchNoSize {
}

class Listy {

    private int[] array;

    public int elementAt(int index) {
        if (index >= array.length) {
            return -1;
        }
        return array[index];
    }

    public int find(int element) {
        return find(element, 0, array.length);
    }

    private int find(int element, int left, int right) {
        if (left >= right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (array[mid] == element) {
            return mid;
        } else if (array[mid] < element) {
            return find(element, mid + 1, right);
        } else {
            return find (element, left, mid);
        }
    }
}