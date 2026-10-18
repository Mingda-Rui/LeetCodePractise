package pers.mingda.leetcode;

public class LC1914CyclicallyRotatingAGrid {
}

class LC1914MathematicalSolution {
  public int[][] rotateGrid(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    int layers = Math.min(m, n) / 2;

    int[][] rotatedGrid = new int[m][n];

    // outermost layer is 0
    for (int i = 0; i < layers; i++) {
      rotateLayer(grid, rotatedGrid, k, i);
    }

    return rotatedGrid;
  }

  private void rotateLayer(int[][] grid, int[][] rotatedGrid, int k, int layer) {
    int perimeter = getPerimeter(grid, layer);
    int rotation = k % perimeter;

    int[] coord = {layer, layer};
    for (int i = 0; i < perimeter; i++) {
      int val = grid[coord[0]][coord[1]];
      int[] nextLoc = rotate(grid, coord, layer, rotation);
      rotatedGrid[nextLoc[0]][nextLoc[1]] = val;
      coord = getNext(grid, coord, layer);
    }
  }

  private int getPerimeter(int[][] grid, int layer) {
    int length = getLength(grid, layer);
    int width = getWidth(grid, layer);
    return (length - 1) * 2 + (width - 1) * 2;
  }

  private int getLength(int[][] grid, int layer) {
    return grid.length - layer * 2;
  }

  private int getWidth(int[][] grid, int layer) {
    return grid[0].length - layer * 2;
  }

  private int[] rotate(int[][] grid, int[] coordinate, int layer, int rotation) {
    int x = coordinate[0];
    int y = coordinate[1];

    int top = layer;
    int bottom = getBottomBoundary(grid, layer);
    int left = layer;
    int right = getRightBoundary(grid, layer);

    while (rotation != 0) {
      // go down
      if (y == left && x != bottom) {
        int move = Math.min(rotation, bottom - x);
        rotation -= move;
        x += move;
      }

      // go right
      if (x == bottom && y != right && rotation != 0) {
        int move = Math.min(rotation, right - y);
        rotation -= move;
        y += move;
      }

      // go up
      if (y == right && x != top && rotation != 0) {
        int move = Math.min(rotation, x - top);
        rotation -= move;
        x -= move;
      }

      // go left
      if (x == top && y != left && rotation != 0) {
        int move = Math.min(rotation, y - left);
        rotation -= move;
        y -= move;
      }
    }
    return new int[]{x, y};
  }

  private int[] getNext(int[][] grid, int[] coordinate, int layer) {
    return rotate(grid, coordinate, layer, 1);
  }

  private int getRightBoundary(int[][] grid, int layer) {
    int width = getWidth(grid, layer);
    return layer + width - 1;
  }

  private int getBottomBoundary(int[][] grid, int layer) {
    int length = getLength(grid, layer);
    return layer + length - 1;
  }
}