package pers.mingda.leetcode;

public class LC0977SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int minIndex = 0;
        while (minIndex < nums.length && nums[minIndex] < 0)
            minIndex++;
        int negative = minIndex - 1;
        int positive = minIndex;
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            int negVal = negative >= 0 ? nums[negative] : Integer.MAX_VALUE;
            int posVal = positive < nums.length ? nums[positive] : Integer.MAX_VALUE;
            if (Math.abs(negVal) < posVal) {
                result[i] = negVal * negVal;
                negative--;
            } else {
                result[i] = posVal * posVal;
                positive++;
            }
        }

        return result;
    }
}
