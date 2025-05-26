package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class LC1466ReorderRoutesToMakeAllPathsLeadToTheCityZero {

  public int minReorder(int n, int[][] connections) {
    Map<Integer, Set<List<Integer>>> map = new HashMap<>();
    for (int[] connection : connections) {
      mapConnection(connection, map);
    }

    return countFlip(0, -1, map);
  }

  private int countFlip(
    int city,
    int parentCity,
    Map<Integer, Set<List<Integer>>> map
  ) {
    int count = 0;
    for (List<Integer> dest : map.get(city)) {
      int destCity = dest.getFirst();
      boolean isOriginalEdge = dest.getLast() == 1;
      if (destCity == parentCity) {
        continue;
      }
      if (isOriginalEdge) {
        count++;
      }
      count += countFlip(destCity, city, map);
    }
    return count;
  }

  private void mapConnection(
    int[] connection,
    Map<Integer, Set<List<Integer>>> map
  ) {
    int origin = connection[0];
    int dest = connection[1];
    map.computeIfAbsent(origin, computeEmptySet()).add(List.of(dest, 1));
    map.computeIfAbsent(dest, computeEmptySet()).add(List.of(origin, 0));
  }

  private Function<Integer, Set<List<Integer>>> computeEmptySet() {
    return key -> new HashSet<>();
  }
}
