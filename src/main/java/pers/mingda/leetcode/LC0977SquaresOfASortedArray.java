package pers.mingda.leetcode;

public class LC0977SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int head = 0;
        int tail = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int headVal = nums[head];
            int tailVal = nums[tail];
            if (Math.abs(headVal) > Math.abs(tailVal)) {
                result[i] = headVal * headVal;
                head++;
            } else {
                result[i] = tailVal * tailVal;
                tail--;
            }
        }
        return result;
    }
}
