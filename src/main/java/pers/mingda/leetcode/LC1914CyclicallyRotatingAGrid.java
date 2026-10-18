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

class LC1914Solution {
  public int[][] rotateGrid(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;

    int layers = Math.min(m, n) / 2;
    for (int l = 0; l < layers; l++) {
      int perimeter = (m + n - 4 * l - 2) * 2;
      int[] rows = new int[perimeter];
      int[] cols = new int[perimeter];
      int[] vals = new int[perimeter];

      int bottom = l + m - 2 * l - 1;
      int right = l + n - 2 * l - 1;
      int index = 0;

      // go down
      for (int r = l; r < bottom; r++) {
        rows[index] = r;
        cols[index] = l;
        vals[index] = grid[r][l];
        index++;
      }

      // go right
      for (int c = l; c < right; c++) {
        rows[index] = bottom;
        cols[index] = c;
        vals[index] = grid[bottom][c];
        index++;
      }

      // go up
      for (int r = bottom; r > l; r--) {
        rows[index] = r;
        cols[index] = right;
        vals[index] = grid[r][right];
        index++;
      }

      // go left
      for (int c = right; c > l; c--) {
        rows[index] = l;
        cols[index] = c;
        vals[index] = grid[l][c];
        index++;
      }

      int rotation = k % perimeter;
      for (int i = 0; i < perimeter; i++) {
        int r = rows[i];
        int c = cols[i];

        int rotatedIndex = (i + perimeter - rotation) % perimeter;
        grid[r][c] = vals[rotatedIndex];
      }
    }
    return grid;
  }
}