package pers.mingda.leetcode;

public class LC0011ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxHeight = Math.max(height[start], height[end]);
        int minHeight = Math.min(height[start], height[end]);
        int maxArea = minHeight * (end - start);
        while (start < end) {
            if (height[start] < maxHeight) start++;
            else end--;
            int currentMinHeight = Math.min(height[start], height[end]);
            if (currentMinHeight > minHeight) {
                minHeight = currentMinHeight;
                int currentArea = minHeight * (end - start);
                maxArea = Math.max(currentArea, maxArea);
            }
            maxHeight = Math.max(height[start], height[end]);
        }
        return maxArea;
    }
}
