package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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

class LC1462BfsSolution {
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

  private boolean checkPrerequisite(int[] query, Map<Integer, Set<Integer>> prerequisiteMap) {
    int startClass = query[0];
    int targetClass = query[1];
    Queue<Integer> classQueue = new LinkedList<>();
    classQueue.add(startClass);

    Set<Integer> seen = new HashSet<>();
    while (!classQueue.isEmpty()) {
      int size = classQueue.size();
      for (int i = 0; i < size; i++) {
        int current = classQueue.remove();
        if (seen.contains(current)) {
          continue;
        }
        seen.add(current);
        if (current == targetClass) {
          return true;
        }
        if (prerequisiteMap.containsKey(current)) {
          classQueue.addAll(prerequisiteMap.get(current));
        }
      }
    }
    return false;
  }
}

class LC1462BiDirectionMapSolution {
  public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
    Map<Integer, Set<Integer>> dependentMap = buildMap(prerequisites);
    List<Boolean> result = new LinkedList<>();
    for (int[] query : queries) {
      int prerequisiteCourse = query[0];
      int dependentCourse = query[1];
      boolean isPrerequisite = dependentMap.containsKey(prerequisiteCourse) && dependentMap.get(prerequisiteCourse).contains(dependentCourse);
      result.add(isPrerequisite);
    }
    return result;
  }

  private Map<Integer, Set<Integer>> buildMap(int[][] prerequisites) {

    Map<Integer, Set<Integer>> prerequisiteMap = new HashMap<>();
    for (int[] prerequisite : prerequisites) {
      int prerequisiteCourse = prerequisite[0];
      int dependentCourse = prerequisite[1];

      prerequisiteMap.computeIfAbsent(dependentCourse, k -> new HashSet<>()).add(prerequisiteCourse);
    }

    Map<Integer, Set<Integer>> dependentMap = new HashMap<>();
    for (int dependentCourse : prerequisiteMap.keySet()) {
      for (int prerequisiteCourse : findAllPrerequisites(dependentCourse, prerequisiteMap)) {
        dependentMap.computeIfAbsent(prerequisiteCourse, k -> new HashSet<>()).add(dependentCourse);
      }
    }
    return dependentMap;
  }

  private Set<Integer> findAllPrerequisites(int course, Map<Integer, Set<Integer>> prerequisiteMap) {
    Set<Integer> seen = new HashSet<>();
    findAllPrerequisites(course, prerequisiteMap, seen);
    return seen;
  }

  private void findAllPrerequisites(int course, Map<Integer, Set<Integer>> prerequisiteMap, Set<Integer> seen) {
    if (seen.contains(course)) {
      return;
    }
    seen.add(course);
    if (!prerequisiteMap.containsKey(course)) {
      return;
    }
    for (int prerequisiteCourse : prerequisiteMap.get(course)) {
      findAllPrerequisites(prerequisiteCourse, prerequisiteMap, seen);
    }
  }
}