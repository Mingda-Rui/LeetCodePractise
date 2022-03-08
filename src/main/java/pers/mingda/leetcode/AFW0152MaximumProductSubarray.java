package pers.mingda.leetcode;

public class AFW0152MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int product = 1;
        int maxNegative = 1;
        for (int num: nums) {
            if (num == 0) {
                product = 1;
                maxNegative = 1;
                max = Math.max(max, 0);
            } else {
                product *= num;
                int currentMax = product < 0 ? product / maxNegative : product;
                max = Math.max(max, currentMax);
                if (product < 0) {
                    maxNegative = maxNegative > 0 ? product : Math.max(maxNegative, product);
                }
            }
        }
        return max;
    }

    public int maxProduct2(int[] nums) {
        int maxPositive = 1;
        int minNegative = 1;
        int result = nums[0];

        for (int num: nums) {
            int currentPositive = Math.max(maxPositive, minNegative);
            int currentNegative = Math.min(maxPositive, minNegative);
            int nextPositive = (num > 0 ? currentPositive : currentNegative) * num;
            int nextNegative = (num > 0 ? currentNegative : currentPositive) * num;

            maxPositive = Math.max(nextPositive, num);
            minNegative = Math.min(nextNegative, num);

            result = Math.max(result, maxPositive);
        }
        return result;
    }
}
