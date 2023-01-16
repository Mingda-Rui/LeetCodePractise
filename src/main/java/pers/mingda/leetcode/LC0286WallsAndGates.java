package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC0286WallsAndGates {

}

class LC0286Solution {
    int[][] directions = {{1, 0}, {- 1, 0}, {0, 1}, {0, - 1}};

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    int[] coord = {i, j};
                    queue.add(coord);
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int parentX = node[0];
            int parentY = node[1];
            for (int[] dir: directions) {
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];
                int[] child = {x, y};
                if (!checkCoord(child, rooms) || rooms[x][y] != Integer.MAX_VALUE)
                    continue;
                rooms[x][y] = rooms[parentX][parentY] + 1;
                queue.add(child);
            }
        }
    }

    private boolean checkCoord(int[] coord, int[][] rooms) {
        int row = rooms.length;
        int column = rooms[0].length;
        return coord[0] >= 0 && coord[0] < row && coord[1] >= 0 && coord[1] < column;
    }
}