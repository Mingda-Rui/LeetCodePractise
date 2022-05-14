package pers.mingda.leetcode;

public class LC0055JumpGame {
    public boolean canJumpArray(int[] nums) {
        boolean[] canReach = new boolean[nums.length];
        canReach[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (canReach[i]) {
                for (int next = i + 1; next <= i + nums[i] && next < nums.length; next++) {
                    canReach[next] = true;
                }
            }
        }
        return canReach[nums.length - 1];
    }

    public boolean canJump(int[] nums) {
        int furthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (furthest < i)
                return false;
            furthest = Math.max(furthest, i + nums[i]);
            if (furthest >= nums.length - 1)
                return true;
        }
        return true;
    }
}
