package pers.mingda.leetcode;

public class AFW0152MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int product = 1;
        int maxNegitive = 1;
        for (int num: nums) {
            if (num == 0) {
                product = 1;
                maxNegitive = 1;
                max = Math.max(max, 0);
            } else {
                product *= num;
                int currentMax = product < 0 ? product / maxNegitive : product;
                max = Math.max(max, currentMax);
                if (product < 0) {
                    maxNegitive = maxNegitive > 0 ? product : Math.max(maxNegitive, product);
                }
            }
        }
        return max;
    }
}
