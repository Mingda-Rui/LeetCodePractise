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
        if (a[left] < a[mid]) { // left ordered
            if (a[left] <= target && target < a[mid]) {
                // search left
                return search(a, left, mid - 1, target);
            } else {
                // search right
                return search(a, mid + 1, right, target);
            }
        } else if (a[mid] < a[right]) { // right ordered
            if (a[mid] < target && target <= a[right]) {
                // search right
                return search(a, mid + 1, right, target);
            } else {
                // search left
                return search(a, left, mid - 1, target);
            }
        } else {
            if (a[left] == a[mid]) {
                int rightResult = search(a, mid + 1, right, target);
                return rightResult == -1 ? search(a, left, mid - 1, target) : rightResult;
            } else {
                // search left
                return search(a, left, mid - 1, target);
            }
        }
    }
}

// 5 6 7 5 5 5 5

// 5 5 5 5 6 7 5
