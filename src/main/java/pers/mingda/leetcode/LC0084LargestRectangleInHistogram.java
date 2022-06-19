package pers.mingda.leetcode;

import java.util.Stack;

public class LC0084LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int[] leftHighests = new int[heights.length];
        Stack<Integer> leftIndexStack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int currentH = heights[i];
            int currentBoundray = i;
            while (!leftIndexStack.isEmpty() && heights[leftIndexStack.peek()] >= currentH)
                currentBoundray = leftIndexStack.pop();

            leftIndexStack.push(i);
            int area = currentH * (i - currentBoundray + 1);
            int prevArea = 0;
            if (heights[currentBoundray] != 0)
                prevArea = (leftHighests[currentBoundray] / heights[currentBoundray] * currentH) - currentH;
            leftHighests[i] = area + Math.max(0, prevArea);
        }

        int[] rightHighests = new int[heights.length];
        Stack<Integer> rightIndexStack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            int currentH = heights[i];
            int currentBoundray = i;
            while (!rightIndexStack.isEmpty() && heights[rightIndexStack.peek()] >= currentH)
                currentBoundray = rightIndexStack.pop();

            rightIndexStack.push(i);
            int area = currentH * (currentBoundray - i + 1);
            int prevArea = 0;
            if (heights[currentBoundray] != 0)
                prevArea = (rightHighests[currentBoundray] / heights[currentBoundray] * currentH) - currentH;
            rightHighests[i] = area + Math.max(0, prevArea);
        }

        int result = 0;
        for (int i = 0; i < heights.length; i++)
            result = Math.max(result, leftHighests[i] + rightHighests[i] - heights[i]);
        return result;
    }
}
