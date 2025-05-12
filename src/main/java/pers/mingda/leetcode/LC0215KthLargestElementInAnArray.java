package pers.mingda.leetcode;

import java.util.Random;

public class LC0215KthLargestElementInAnArray {}

class LC0215Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;

        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        for (int j = low; j < high; j++) {
            if (nums[j] <= nums[high]) {
                swap(nums, pivot++, j);
            }
        }
        swap(nums, pivot, high);

        // count the nums that are > pivot from high
        int count = high - pivot + 1;
        // pivot is the one!
        if (count == k) return nums[pivot];
        // pivot is too small, so it must be on the right
        if (count > k) return quickSelect(nums, pivot + 1, high, k);
        // pivot is too big, so it must be on the left
        return quickSelect(nums, low, pivot - 1, k - count);
    }

    private void swap(int[] nums, int pivot, int index) {
        int tmp = nums[pivot];
        nums[pivot] = nums[index];
        nums[index] = tmp;
    }

    private void shuffle(int[] a) {
        final Random random = new Random();
        for (int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }
}

class LC0215SolutionOptimized {
    public int findKthLargest(int[] nums, int k) {
        return quickSelection(nums, k, 0, nums.length);
    }

    private int quickSelection(int[] nums, int k, int start, int end) {
        if (end - start == 1) {
            return nums[start];
        }
        int pivot = (start + end) / 2;
        int pivotVal = nums[pivot];
        int mid = start;
        int right = end;
        int index = start;
        while (index < right) {
            int num = nums[index];
            if (num > pivotVal) {
                right--;
                swap(nums, index, right);
            } else if (num < pivotVal) {
                if (index != mid) {
                    swap(nums, mid, index);
                }
                index++;
                mid++;
            } else if (num == pivotVal) {
                index++;
            }
        }

        int greaterCount = end - right;
        int equalCount = right - mid;
//        int smallerCount = mid - start;
        if (greaterCount >= k) {
            return quickSelection(nums, k, right, end);
        } else if (equalCount + greaterCount >= k) {
            return nums[mid];
        } else {
            return quickSelection(nums, k - (end - mid), start, mid);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}