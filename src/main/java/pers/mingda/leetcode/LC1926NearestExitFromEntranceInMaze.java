package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class LC1926NearestExitFromEntranceInMaze {

  public int nearestExit(char[][] maze, int[] entrance) {
    int row = maze.length;
    int col = maze[0].length;
    boolean[][] visited = new boolean[row][col];
    visited[entrance[0]][entrance[1]] = true;

    Queue<List<Integer>> toVisit = new LinkedList<>();
    toVisit.add(IntStream.of(entrance).boxed().toList());
    int step = 0;
    while (!toVisit.isEmpty()) {
      int size = toVisit.size();
      step++;
      for (int i = 0; i < size; i++) {
        List<Integer> next = toVisit.poll();
        if (findExit(maze, next, visited, toVisit)) {
          return step;
        }
      }
    }
    return -1;
  }

  List<List<Integer>> offsets = List.of(
    List.of(0, 1),
    List.of(0, -1),
    List.of(-1, 0),
    List.of(1, 0)
  );

  private boolean findExit(
    char[][] maze,
    List<Integer> spot,
    boolean[][] visited,
    Queue<List<Integer>> toVisit
  ) {
    int row = spot.getFirst();
    int col = spot.getLast();

    for (List<Integer> offset : offsets) {
      int i = row + offset.getFirst();
      int j = col + offset.getLast();
      if (!checkRange(maze, i, j) || isWall(maze, i, j) || visited[i][j]) {
        continue;
      }
      if (isExit(maze, i, j)) {
        return true;
      }
      visited[i][j] = true;
      toVisit.add(List.of(i, j));
    }
    return false;
  }

  private boolean checkRange(char[][] maze, int row, int col) {
    return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length;
  }

  private boolean isWall(char[][] maze, int row, int col) {
    return maze[row][col] == '+';
  }

  private boolean isExit(char[][] maze, int row, int col) {
    // boolean isEmptyCell = maze[row][col] == '.';
    return (
      row == 0 ||
      col == 0 ||
      row == maze.length - 1 ||
      col == maze[0].length - 1
    );
  }
}
