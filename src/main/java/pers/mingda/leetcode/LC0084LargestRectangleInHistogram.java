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
            int distance = i - currentBoundray + 1;
            int prevDistance = Math.max(0, leftHighests[currentBoundray] - 1);
            leftHighests[i] = distance + prevDistance;
        }

        int[] rightHighests = new int[heights.length];
        Stack<Integer> rightIndexStack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            int currentH = heights[i];
            int currentBoundray = i;
            while (!rightIndexStack.isEmpty() && heights[rightIndexStack.peek()] >= currentH)
                currentBoundray = rightIndexStack.pop();

            rightIndexStack.push(i);
            int distance = currentBoundray - i + 1;
            int prevDistance = Math.max(0, rightHighests[currentBoundray] - 1);
            rightHighests[i] = distance + prevDistance;
        }

        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = (leftHighests[i] + rightHighests[i] - 1) * heights[i];
            result = Math.max(result, area);
        }
        return result;
    }
}
