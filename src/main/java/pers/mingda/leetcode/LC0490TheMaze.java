package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC0490TheMaze {}

class LC0490Solution {

  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    Set<List<Integer>> seen = new HashSet<>();
    return findPath(
      maze,
      Arrays.asList(start[0], start[1]),
      Arrays.asList(destination[0], destination[1]),
      seen
    );
  }

  private boolean findPath(
    int[][] maze,
    List<Integer> start,
    List<Integer> destination,
    Set<List<Integer>> seen
  ) {
    if (isSameSpot(start, destination)) return true;
    seen.add(start);
    List<Integer> upperWall = findUpperWall(maze, start);
    if (
      !seen.contains(upperWall) && findPath(maze, upperWall, destination, seen)
    ) return true;
    List<Integer> bottomWall = findBottomWall(maze, start);
    if (
      !seen.contains(bottomWall) &&
      findPath(maze, bottomWall, destination, seen)
    ) return true;
    List<Integer> leftWall = findLeftWall(maze, start);
    if (
      !seen.contains(leftWall) && findPath(maze, leftWall, destination, seen)
    ) return true;
    List<Integer> rightWall = findRightWall(maze, start);
    if (
      !seen.contains(rightWall) && findPath(maze, rightWall, destination, seen)
    ) return true;
    return false;
  }

  private boolean isSameSpot(List<Integer> start, List<Integer> dest) {
    return start.get(0) == dest.get(0) && start.get(1) == dest.get(1);
  }

  private List<Integer> findUpperWall(int[][] maze, List<Integer> start) {
    int[] dir = { -1, 0 };
    return findWalls(maze, dir, start);
  }

  private List<Integer> findBottomWall(int[][] maze, List<Integer> start) {
    int[] dir = { 1, 0 };
    return findWalls(maze, dir, start);
  }

  private List<Integer> findLeftWall(int[][] maze, List<Integer> start) {
    int[] dir = { 0, -1 };
    return findWalls(maze, dir, start);
  }

  private List<Integer> findRightWall(int[][] maze, List<Integer> start) {
    int[] dir = { 0, 1 };
    return findWalls(maze, dir, start);
  }

  private List<Integer> findWalls(
    int[][] maze,
    int[] dir,
    List<Integer> start
  ) {
    int x = start.get(0);
    int y = start.get(1);
    while (
      x + dir[0] >= 0 &&
      x + dir[0] < maze.length &&
      y + dir[1] >= 0 &&
      y + dir[1] < maze[0].length &&
      maze[x + dir[0]][y + dir[1]] == 0
    ) {
      x += dir[0];
      y += dir[1];
    }

    return Arrays.asList(x, y);
  }
}

class LC0490BfsSolution {

  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    Set<List<Integer>> seen = new HashSet<>();
    Queue<List<Integer>> queue = new LinkedList<>();
    queue.offer(Arrays.asList(start[0], start[1]));

    List<Integer> dest = Arrays.asList(destination[0], destination[1]);
    while (!queue.isEmpty()) {
      List<Integer> current = queue.poll();
      if (isSameSpot(current, dest)) return true;
      seen.add(current);
      List<Integer> upperWall = findUpperWall(maze, current);
      if (!seen.contains(upperWall)) queue.offer(upperWall);
      List<Integer> bottomWall = findBottomWall(maze, current);
      if (!seen.contains(bottomWall)) queue.offer(bottomWall);
      List<Integer> leftWall = findLeftWall(maze, current);
      if (!seen.contains(leftWall)) queue.offer(leftWall);
      List<Integer> rightWall = findRightWall(maze, current);
      if (!seen.contains(rightWall)) queue.offer(rightWall);
    }
    return false;
  }

  private boolean isSameSpot(List<Integer> start, List<Integer> dest) {
    return start.get(0) == dest.get(0) && start.get(1) == dest.get(1);
  }

  private List<Integer> findUpperWall(int[][] maze, List<Integer> start) {
    int[] dir = { -1, 0 };
    return findBoundryWall(maze, dir, start);
  }

  private List<Integer> findBottomWall(int[][] maze, List<Integer> start) {
    int[] dir = { 1, 0 };
    return findBoundryWall(maze, dir, start);
  }

  private List<Integer> findLeftWall(int[][] maze, List<Integer> start) {
    int[] dir = { 0, -1 };
    return findBoundryWall(maze, dir, start);
  }

  private List<Integer> findRightWall(int[][] maze, List<Integer> start) {
    int[] dir = { 0, 1 };
    return findBoundryWall(maze, dir, start);
  }

  private List<Integer> findBoundryWall(
    int[][] maze,
    int[] dir,
    List<Integer> start
  ) {
    int x = start.get(0);
    int y = start.get(1);
    while (
      x + dir[0] >= 0 &&
      x + dir[0] < maze.length &&
      y + dir[1] >= 0 &&
      y + dir[1] < maze[0].length &&
      maze[x + dir[0]][y + dir[1]] == 0
    ) {
      x += dir[0];
      y += dir[1];
    }

    return Arrays.asList(x, y);
  }
}
