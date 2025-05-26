package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LC0054SpiralMatrix {

  public List<Integer> spiralOrder(int[][] matrix) {
    return spiralOrderIterative(matrix);
  }

  public List<Integer> spiralOrderIterative(int[][] matrix) {
    List<Integer> result = new LinkedList<>();
    int rowL = matrix.length;
    int columnL = matrix[0].length;
    int[] coord = new int[] { 0, 0 };
    while (rowL > 0 && columnL > 0) {
      if (rowL == 1) {
        fastForwardLine(matrix, coord, result, 0, 1, columnL);
      } else if (columnL == 1) {
        fastForwardLine(matrix, coord, result, 1, 0, rowL);
      } else {
        fastForwardCircle(matrix, coord, result, rowL, columnL);
      }

      coord[0]++;
      coord[1]++;
      rowL -= 2;
      columnL -= 2;
    }

    return result;
  }

  private void fastForwardCircle(
    int[][] matrix,
    int[] coord,
    List<Integer> result,
    int rowL,
    int columnL
  ) {
    fastForwardLine(matrix, coord, result, 0, 1, columnL - 1);
    fastForwardLine(matrix, coord, result, 1, 0, rowL - 1);
    fastForwardLine(matrix, coord, result, 0, -1, columnL - 1);
    fastForwardLine(matrix, coord, result, -1, 0, rowL - 1);
  }

  public List<Integer> spiralOrderIterativeRefactored(int[][] matrix) {
    List<Integer> result = new LinkedList<>();
    int rowL = matrix.length;
    int columnL = matrix[0].length;
    int[] coord = new int[] { 0, 0 };
    while (rowL > 0 && columnL > 0) {
      fastForwardCircleRefactored(matrix, coord, result, rowL, columnL);
      coord[0]++;
      coord[1]++;
      rowL -= 2;
      columnL -= 2;
    }

    return result;
  }

  private void fastForwardCircleRefactored(
    int[][] matrix,
    int[] coord,
    List<Integer> result,
    int rowL,
    int columnL
  ) {
    int columnB = columnL - (rowL == 1 ? 0 : 1);
    int rowB = rowL - (columnL == 1 && rowL != 1 ? 0 : 1);
    fastForwardLine(matrix, coord, result, 0, 1, columnB);
    fastForwardLine(matrix, coord, result, 1, 0, rowB);
    if (rowL > 1 && columnL > 1) {
      fastForwardLine(matrix, coord, result, 0, -1, columnB);
      fastForwardLine(matrix, coord, result, -1, 0, rowB);
    }
  }

  private void fastForwardLine(
    int[][] matrix,
    int[] coord,
    List<Integer> result,
    int xOffset,
    int yOffset,
    int length
  ) {
    for (int i = 0; i < length; i++) {
      int val = getVal(matrix, coord);
      result.add(val);
      coord[0] += xOffset;
      coord[1] += yOffset;
    }
  }

  private int getVal(int[][] matrix, int[] coord) {
    int x = coord[0];
    int y = coord[1];
    return matrix[x][y];
  }

  public List<Integer> spiralOrderRecursive(int[][] matrix) {
    int[] coord = new int[] { 0, 0 };
    int[] boundary = new int[] { 0, 0 };
    List<Integer> result = new LinkedList<>();
    return spiralOrderRecursive(matrix, coord, boundary, result);
  }

  private List<Integer> spiralOrderRecursive(
    int[][] matrix,
    int[] coord,
    int[] boundary,
    List<Integer> result
  ) {
    int x = coord[0];
    int y = coord[1];

    int top = boundary[0];
    int bottom = matrix.length - top - 1;
    int left = boundary[1];
    int right = matrix[0].length - left - 1;

    if (top > bottom || left > right) return result;
    if (x < top || x > bottom || y < left || y > right) return result;

    int val = matrix[x][y];
    result.add(val);
    boolean onTop = x == top;
    boolean onBottom = x == bottom;
    boolean onLeft = y == left;
    boolean onRight = y == right;

    if ((onTop && !onRight) || (onBottom && !onLeft)) coord[1] += (onTop
        ? 1
        : -1);
    else if ((onLeft && !onTop) || (onRight && !onBottom)) coord[0] += (onRight
        ? 1
        : -1);

    if (top == coord[0] && left == coord[1]) {
      coord[0]++;
      coord[1]++;
      boundary[0]++;
      boundary[1]++;
    }
    return spiralOrderRecursive(matrix, coord, boundary, result);
  }
}
