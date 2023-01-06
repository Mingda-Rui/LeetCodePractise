package pers.mingda.leetcode;

public class LC0268MissingNumber {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        int sum = (1 + size) * size / 2;
        for (int num: nums)
            sum -= num;
        return sum;
    }
}
