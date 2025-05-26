package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _16_19PondSizes {
  private static final int WATER = 0;

  List<Integer> computePondSizes(int[][] land) {
    List<Integer> pondSizes = new ArrayList<>();
    Set<List<Integer>> visited = new HashSet<>();
    for (int i = 0; i < land.length; i++) {
      for (int j = 0; j < land[0].length; j++) {
        List<Integer> location = List.of(i, j);
        if (land[i][j] == WATER && !visited.contains(location)) {
          int size = measurePond(land, visited, location);
          pondSizes.add(size);
        }
      }
    }
    return pondSizes;
  }

  int measurePond(int[][] land, Set<List<Integer>> visited, List<Integer> location) {
    if (visited.contains(location) || !checkBoundary(land, location)) {
      return 0;
    }
    if (land[location.getFirst()][location.getLast()] != WATER) {
      return 0;
    }
    visited.add(location);
    return getSurroundingLoc(location).stream()
            .map(loc -> measurePond(land, visited, loc))
            .mapToInt(Integer::intValue)
            .sum()
        + 1;
  }

  boolean checkBoundary(int[][] land, List<Integer> location) {
    return location.getFirst() >= 0
        && location.getFirst() < land.length
        && location.getLast() >= 0
        && location.getLast() < land[0].length;
  }

  List<List<Integer>> getSurroundingLoc(List<Integer> location) {
    List<List<Integer>> surroundingLoc = new ArrayList<>();
    for (int i = location.getFirst() - 1; i <= location.getFirst() + 1; i++) {
      for (int j = location.getLast() - 1; j <= location.getLast() + 1; j++) {
        if (i != location.getFirst() || j != location.getLast()) {
          surroundingLoc.add(List.of(i, j));
        }
      }
    }
    return surroundingLoc;
  }
}
