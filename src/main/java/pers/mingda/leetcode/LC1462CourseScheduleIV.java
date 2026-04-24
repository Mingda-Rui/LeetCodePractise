package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC1462CourseScheduleIV {
}

class LC1462Solution {
  public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
    Map<Integer, Set<Integer>> prerequisiteMap = buildMap(prerequisites);
    List<Boolean> result = new ArrayList<>();
    for (int[] query : queries) {
      result.add(checkPrerequisite(query, prerequisiteMap));
    }
    return result;
  }

  private Map<Integer, Set<Integer>> buildMap(int[][] prerequisites) {
    Map<Integer, Set<Integer>> prerequisiteMap = new HashMap<>();
    for (int[] prerequisite : prerequisites) {
      int prerequisiteClass = prerequisite[0];
      int dependentClass = prerequisite[1];
      prerequisiteMap.computeIfAbsent(prerequisiteClass, k -> new HashSet<>()).add(dependentClass);
    }
    return prerequisiteMap;
  }

  private boolean checkPrerequisite(int[] prerequisite, Map<Integer, Set<Integer>> prerequisiteMap) {
    int prerequisiteClass = prerequisite[0];
    int dependentClass = prerequisite[1];
    Set<Integer> seen = new HashSet<>();
    return findDependent(prerequisiteClass, dependentClass, prerequisiteMap, seen);
  }
  private boolean findDependent(int current, int target, Map<Integer, Set<Integer>> prerequisiteMap, Set<Integer> seen) {
    if (current == target) {
      return true;
    }

    if (seen.contains(current)) {
      return false;
    }

    if (!prerequisiteMap.containsKey(current)) {
      return false;
    }

    seen.add(current);
    for (int next : prerequisiteMap.get(current)) {
      if (findDependent(next, target, prerequisiteMap, seen)) {
        return true;
      }
    }
    return false;
  }
}