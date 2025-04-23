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

    private void shuffle(int a[]) {
        final Random random = new Random();
        for (int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }
}