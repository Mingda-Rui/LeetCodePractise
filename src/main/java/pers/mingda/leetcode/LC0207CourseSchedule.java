package pers.mingda.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC0207CourseSchedule {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> preMap = new HashMap<>();
    int[] deps = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
      int first = prerequisite[1];
      int second = prerequisite[0];
      preMap.putIfAbsent(first, new HashSet<>());
      preMap.get(first).add(second);
      deps[second]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < deps.length; i++) {
      if (deps[i] == 0) queue.add(i);
    }

    while (!queue.isEmpty()) {
      int preCourse = queue.remove();
      numCourses--;

      for (int course : preMap.getOrDefault(
        preCourse,
        Collections.emptySet()
      )) {
        deps[course]--;
        if (deps[course] == 0) queue.add(course);
      }
    }

    return numCourses == 0;
  }

  public boolean canFinishDfs(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] prereq : prerequisites) {
      int preCourse = prereq[1];
      int course = prereq[0];
      map.putIfAbsent(course, new HashSet<>());
      map.get(course).add(preCourse);
    }

    boolean[] visited = new boolean[numCourses];
    while (!map.isEmpty()) {
      int course = map.keySet().stream().findFirst().get();
      if (!canFinishDfs(course, map, visited)) return false;
    }

    return true;
  }

  private boolean canFinishDfs(
    int course,
    Map<Integer, Set<Integer>> map,
    boolean[] visited
  ) {
    if (visited[course]) return false;
    visited[course] = true;
    for (int preCourse : map.getOrDefault(course, Collections.emptySet())) {
      if (!canFinishDfs(preCourse, map, visited)) return false;
    }
    return true;
  }
}
