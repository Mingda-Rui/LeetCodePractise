package pers.mingda.leetcode;

public class LC0746MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] record = new int[cost.length];
        record[0] = cost[0];
        record[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int currCost = cost[i];
            record[i] = currCost + Math.min(record[i - 1], record[i - 2]);
        }
        return Math.min(record[cost.length - 1], record[cost.length - 2]);
    }
}
