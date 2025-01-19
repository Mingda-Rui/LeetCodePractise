package pers.mingda.cracking_the_coding_interview.chapter10_sorting_and_searching;

public class _10_4SortedSearchNoSize {
    private Listy list;

    public int findElement(int target) {
        int len = calcLen(list);
        return find(list, target, len);
    }

    private int calcLen(Listy list) {
        return calcLenHelper(list, 0, 1);
    }

    private int calcLenHelper(Listy list, int left, int right) {
        if (left + 1 >= right) {
            return left;
        }
        int rightVal = list.elementAt(right);
        if (rightVal != -1) {
            return calcLenHelper(list, left, right * 2);
        }

        int mid = left + right / 2;
        int midVal = list.elementAt(mid);
        if (midVal == -1) {
            return calcLenHelper(list, left, mid);
        } else {
            return calcLenHelper(list, mid, right);
        }
    }

    private int find(Listy list, int element, int len) {
        return findHelper(list, element, 0, len);
    }

    private int findHelper(Listy list, int element, int left, int right) {
        if (left >= right) {
            return element == list.elementAt(left) ? left : -1;
        }
        int mid = (left + right) / 2;
        if (list.elementAt(mid) == element) {
            return mid;
        } else if (list.elementAt(mid) > element) {
            return findHelper(list, element, mid + 1, right);
        } else {
            return findHelper(list, element, left, mid);
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