package pers.mingda.cracking_the_coding_interview.chapter10_sorting_and_searching;

public class _10_3SearchInRotatedArray {
    public int search(int[] a, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (a[mid] == target) {
            return mid;
        }

        // both side ordered -> binary search
        // one side ordered
        //   - target in ordered side
        //   - target in rotated side
        if (a[mid] > a[right]) { // right rotated (left ordered or equal)
            if (a[left] <= target && target < a[mid]) {
                // search left
                return search(a, left, mid - 1, target);
            } else {
                // search right
                return search(a, mid + 1, right, target);
            }
        } else if (a[left] > a[mid]) { // left rotated (right ordered or equal)
            if (a[mid] < target && target <= a[right]) {
                // search right
                return search(a, mid + 1, right, target);
            } else {
                // search left
                return search(a, left, mid - 1, target);
            }
        } else {
            // a[left] == a[mid] && a[mid] == a[right]
            // two scenarios:
            // 5 6 7 5 5 5 5
            // or
            // 5 5 5 5 6 7 5
            int leftResult = search(a, left, mid - 1, target);
            return leftResult == -1 ? search(a, mid + 1, right, target) : leftResult;
        }
    }
}
