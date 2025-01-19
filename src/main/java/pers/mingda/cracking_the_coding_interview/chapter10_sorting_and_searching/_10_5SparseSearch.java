package pers.mingda.cracking_the_coding_interview.chapter10_sorting_and_searching;

public class _10_5SparseSearch {
    public int search(String[] sortedStr, String target) {
        return binarySearch(sortedStr, target, 0, sortedStr.length);
    }

    public int binarySearch(String[] sortedStr, String target, int left, int right) {
        if (left >= right) {
            return -1;
        }

        int mid = getNextMid(sortedStr, left, right);
        if (mid == -1 || sortedStr[mid].compareTo(target) == 0) {
            return mid;
        } else if (sortedStr[mid].compareTo(target) > 0) {
            return binarySearch(sortedStr, target, left, mid);
        } else {
            return binarySearch(sortedStr, target, mid + 1, right);
        }

    }

    private int getNextMid(String[] sortedStr, int left, int right) {
        int mid = (left + right) / 2;
        while (mid >= left && sortedStr[mid].isEmpty()) {
            mid--;
        }
        if (mid >= left && !sortedStr[mid].isEmpty()) {
            return mid;
        }

        mid = (left + right) / 2;
        while (mid < right && sortedStr[mid].isEmpty()) {
            mid++;
        }
        return mid < right && !sortedStr[mid].isEmpty() ? mid : -1;
    }
}
