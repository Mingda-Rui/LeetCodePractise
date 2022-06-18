package pers.mingda.leetcode;

import java.util.Stack;

public class LC0042TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        int[] capacityRecord = new int[height.length];
        Stack<Integer> stack = new Stack<>(); // index
        for (int i = 0; i < height.length; i++) {
            int currentH = height[i];
            if (!stack.isEmpty() && height[stack.peek()] < currentH) {
                while (stack.size() > 1 && height[stack.peek()] < currentH)
                    stack.pop();

                int prevIndex = stack.peek();
                int newWaterHeight = Math.min(height[prevIndex], currentH);

                int currentCap = 0;
                for (int j = prevIndex; j < i; j++)
                    currentCap += Math.max(0, newWaterHeight - height[j]);

                capacityRecord[i] = capacityRecord[prevIndex] + currentCap;

                if (height[prevIndex] <= currentH)
                    stack.pop();

                result = Math.max(result, capacityRecord[i]);
            } else if (i - 1 >= 0) {
                capacityRecord[i] = capacityRecord[i - 1];
            }
            stack.push(i);
        }
        return result;
    }
}

// -    -
//    --
//  --