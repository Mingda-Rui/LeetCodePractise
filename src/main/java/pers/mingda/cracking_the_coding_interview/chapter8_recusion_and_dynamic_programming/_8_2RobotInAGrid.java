package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

import java.util.ArrayList;

public class _8_2RobotInAGrid {
    private boolean isAtOrigin;

    ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0)
            return null;
        ArrayList<Point> path = new ArrayList<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
        /* If there's a path from the start to here, add my location. */
        if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }
}

class Point {
    private int row;
    private int col;
    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}