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
    int[] leftBoundaryRecord = new int[heights.length];
    for (int i = 0; i < heights.length; i++) {
      int currentH = heights[i];
      int leftBoundray = i - 1;
      while (leftBoundray >= 0 && heights[leftBoundray] >= currentH)
        leftBoundray = leftBoundaryRecord[leftBoundray];
      leftBoundaryRecord[i] = leftBoundray;
    }

    int[] rightBoundaryRecord = new int[heights.length];
    for (int i = heights.length - 1; i >= 0; i--) {
      int currentH = heights[i];
      int rightBoundray = i + 1;
      while (rightBoundray < heights.length && heights[rightBoundray] >= currentH)
        rightBoundray = rightBoundaryRecord[rightBoundray];
      rightBoundaryRecord[i] = rightBoundray;
    }

    int result = 0;
    for (int i = 0; i < heights.length; i++) {
      int currentH = heights[i];
      int distance = rightBoundaryRecord[i] - leftBoundaryRecord[i] - 1;
      result = Math.max(result, distance * currentH);
    }
    return result;
  }
}

class LC0084DivideAndConquerSolution {
  public int largestRectangleArea(int[] heights) {
    LC0084SegTree st = new LC0084SegTree(heights);
    return largestRectangleArea(heights, st, 0, heights.length);
  }

  private int largestRectangleArea(int[] heights, LC0084SegTree st, int from, int to) {
    if (from == to) {
      return 0;
    } else if (from + 1 == to) {
      return heights[from];
    }

    int miniIndex = st.getShortestIndex(heights, from, to);
    int largestArea = heights[miniIndex] * (to - from);
    int leftLargest = largestRectangleArea(heights, st, from, miniIndex);
    int rightLargest = largestRectangleArea(heights, st, miniIndex + 1, to);
    largestArea = Math.max(largestArea, leftLargest);
    largestArea = Math.max(largestArea, rightLargest);
    return largestArea;
  }

  private int findShortestBar(int[] heights, int from, int to) {
    int shortestIndex = from;
    for (int i = from; i < to; i++) {
      if (heights[shortestIndex] > heights[i]) {
        shortestIndex = i;
      }
    }
    return shortestIndex;
  }
}

class LC0084SegTree {
  int shortestIndex;
  int from;
  int to;
  LC0084SegTree left;
  LC0084SegTree right;

  public LC0084SegTree(int[] heights) {
    this(heights, 0, heights.length);
  }

  private LC0084SegTree(int[] heights, int from, int to) {
    this.from = from;
    this.to = to;
    if (from + 1 == to) {
      this.shortestIndex = from;
      return;
    }
    int n = heights.length;
    int mid = (from + to) / 2;
    this.left = new LC0084SegTree(heights, from, mid);
    this.right = new LC0084SegTree(heights, mid, to);
    this.shortestIndex = heights[left.shortestIndex] < heights[right.shortestIndex] ? left.shortestIndex : right.shortestIndex;
  }

  public int getShortestIndex(int[] heights, int from, int to) {
    if (from <= this.from && to >= this.to) {
      return this.shortestIndex;
    } else if (from >= this.to || to <= this.from) {
      return -1;
    }
    int leftShortest = this.left.getShortestIndex(heights, from, to);
    int rightShortest = this.right.getShortestIndex(heights, from, to);

    if (leftShortest != -1 && rightShortest != -1) {
      return heights[leftShortest] < heights[rightShortest] ? leftShortest : rightShortest;
    }
    return leftShortest == -1 ? rightShortest : leftShortest;
  }
}
