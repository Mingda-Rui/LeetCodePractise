package pers.mingda.leetcode;

public class LC0427ConstructQuadTree {}

// Definition for a QuadTree LC0427Node.
class LC0427Node {

  public boolean val;
  public boolean isLeaf;
  public LC0427Node topLeft;
  public LC0427Node topRight;
  public LC0427Node bottomLeft;
  public LC0427Node bottomRight;

  public LC0427Node() {
    this.val = false;
    this.isLeaf = false;
    this.topLeft = null;
    this.topRight = null;
    this.bottomLeft = null;
    this.bottomRight = null;
  }

  public LC0427Node(boolean val, boolean isLeaf) {
    this.val = val;
    this.isLeaf = isLeaf;
    this.topLeft = null;
    this.topRight = null;
    this.bottomLeft = null;
    this.bottomRight = null;
  }

  public LC0427Node(
    boolean val,
    boolean isLeaf,
    LC0427Node topLeft,
    LC0427Node topRight,
    LC0427Node bottomLeft,
    LC0427Node bottomRight
  ) {
    this.val = val;
    this.isLeaf = isLeaf;
    this.topLeft = topLeft;
    this.topRight = topRight;
    this.bottomLeft = bottomLeft;
    this.bottomRight = bottomRight;
  }
}

class LC0427Solution {

  public LC0427Node construct(int[][] grid) {
    return construct(grid, 0, 0, grid[0].length);
  }

  private LC0427Node construct(int[][] grid, int row, int col, int len) {
    if (len == 1) {
      return new LC0427Node(grid[row][col] == 1, true);
    }

    int halfLen = len / 2;
    LC0427Node topLeft = construct(grid, row, col, halfLen);
    LC0427Node topRight = construct(grid, row, col + halfLen, halfLen);
    LC0427Node bottomLeft = construct(grid, row + halfLen, col, halfLen);
    LC0427Node bottomRight = construct(grid, row + halfLen, col + halfLen, halfLen);
    return combineLeaves(topLeft, topRight, bottomLeft, bottomRight);
  }

  private LC0427Node combineLeaves(
    LC0427Node topLeft,
    LC0427Node topRight,
    LC0427Node bottomLeft,
    LC0427Node bottomRight
  ) {
    boolean areAllLeaves =
      topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;
    boolean areValEqual =
      topLeft.val == topRight.val &&
      topLeft.val == bottomLeft.val &&
      topLeft.val == bottomRight.val;
    if (areAllLeaves && areValEqual) {
      return new LC0427Node(topLeft.val, true);
    }
    return new LC0427Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
  }
}
