package pers.mingda.cracking_the_coding_interview.chapter10_sorting_and_searching;

public class _10_3SearchInRotatedArray {
    public int search(int[] a, int left, int right, int target) {
        if (left >= right) {
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
        if (a[left] <= a[mid] && a[mid] <= a[right]) { // both ordered
            if (a[mid] > target) {
                return search(a, left, mid - 1, target);
            } else if (a[mid] < target) {
                return search(a, mid + 1, right, target);
            }
        } else if (a[left] <= a[mid]) { // left ordered
            if (a[left] <= target && target < a[mid]) {
                return search(a, left, mid - 1, target);
            } else {
                return search(a, mid + 1, right, target);
            }
        } else if (a[mid] <= a[right]) { // right ordered
            if (a[mid] < target && target <= a[right]) {
                return search(a, mid + 1, right, target);
            } else {
                return search(a, left, mid - 1, target);
            }
        }
        return -1;
    }
}
