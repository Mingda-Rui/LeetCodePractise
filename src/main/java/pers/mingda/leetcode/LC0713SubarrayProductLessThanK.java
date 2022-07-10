package pers.mingda.leetcode;

public class LC0713SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int counter = 0;
        int slow = 0;
        int fast = 0;
        int product = 1;
        int size = 0;

        while (fast < nums.length) {
            int nextProduct = product * nums[fast];
            if (nextProduct < k || slow == fast) {
                product = nextProduct;
                fast++;
                size++;
                if (product < k)
                    counter += size;
            } else {
                product /= nums[slow];
                slow++;
                size--;
            }
        }
        return counter;
    }
}
