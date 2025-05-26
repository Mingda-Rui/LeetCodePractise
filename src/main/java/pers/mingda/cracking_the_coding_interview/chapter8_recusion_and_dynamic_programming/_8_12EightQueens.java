package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _8_12EightQueens {
  private static final int GRID_SIZE = 8;

  public List<List<Integer>> solveNQueens(int n) {
    int[] rows = new int[GRID_SIZE];
    return placeQueens(rows, 0);
  }

  private List<List<Integer>> placeQueens(int[] rows, int currentRow) {
    if (currentRow == GRID_SIZE) {
      List<Integer> placement = Arrays.stream(rows).boxed().toList();
      return List.of(placement);
    }

    List<List<Integer>> allPlacements = new ArrayList<>();
    for (int column = 0; column < GRID_SIZE; column++) {
      if (checkValid(rows, currentRow, column)) {
        rows[currentRow] = column;
        List<List<Integer>> placements = placeQueens(rows, currentRow + 1);
        allPlacements.addAll(placements);
      }
    }
    return allPlacements;
  }

  private boolean checkValid(int[] rows, int row, int column) {
    for (int existingRow = 0; existingRow < row; existingRow++) {
      int existingColumn = rows[existingRow];
      if (existingColumn == column) {
        return false;
      }

      int rowDist = row - existingRow;
      int columnDist = Math.abs(column - existingColumn);
      if (rowDist == columnDist) {
        return false;
      }
    }

    return true;
  }
}
