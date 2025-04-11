package pers.mingda.leetcode;

public class LC1004MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int zeroCount = 0;
        int head = 0;
        int tail = 0;
        while (head < nums.length) {
            while (head < nums.length && zeroCount <= k) {
                if (zeroCount == k && nums[head] == 0) {
                    break;
                }
                if (nums[head] == 0) {
                    zeroCount++;
                }
                head++;
            }
            maxLen = Math.max(maxLen, head - tail);
            boolean passZero = false;
            while (!passZero && tail < nums.length && tail <= head) {
                passZero = nums[tail] == 0;
                tail++;
            }
            zeroCount--;
        }
        return maxLen;
    }
}
