package pers.mingda.leetcode;

import java.util.Stack;

public class LC0084LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int index = 0;
        while (index <= heights.length) {
            int currentH = index < heights.length ? heights[index] : 0;
            if (stack.isEmpty() || heights[stack.peek()] < currentH) {
                stack.push(index);
                index++;
            } else {
                int targetIndex = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int area = (index - leftIndex - 1) * heights[targetIndex];
                result = Math.max(result, area);
            }
        }

        return result;
    }

    public int largestRectangleAreaDp(int[] heights) {
        int[] leftBoundrayRecord = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            int currentH = heights[i];
            int leftBoundray = i - 1;
            while (leftBoundray >= 0 && heights[leftBoundray] >= currentH)
                leftBoundray = leftBoundrayRecord[leftBoundray];
            leftBoundrayRecord[i] = leftBoundray;
        }

        int[] rightBoundrayRecord = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            int currentH = heights[i];
            int rightBoundray = i + 1;
            while (rightBoundray < heights.length && heights[rightBoundray] >= currentH)
                rightBoundray = rightBoundrayRecord[rightBoundray];
            rightBoundrayRecord[i] = rightBoundray;
        }

        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int currentH = heights[i];
            int distance = rightBoundrayRecord[i] - leftBoundrayRecord[i] - 1;
            result = Math.max(result, distance * currentH);
        }
        return result;
    }
}
