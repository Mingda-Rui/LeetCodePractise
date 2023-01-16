package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC0286WallsAndGates {

}

class LC0286Solution {
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
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                rooms[x][y] = Math.min(rooms[x][y], distance);
                enqueueSurrondings(node, rooms, distance, queue);
            }
            distance++;
        }
    }

    private void enqueueSurrondings(int[] coord, int[][] rooms, int distance, Queue<int[]> queue) {
        int x = coord[0];
        int y = coord[1];
        int[][] directions = {{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}};
        for (int[] neighbour: directions) {
            if (!checkCoord(neighbour, rooms))
                continue;
            int neighX = neighbour[0];
            int neighY = neighbour[1];
            if (rooms[neighX][neighY] == Integer.MAX_VALUE)
                queue.add(neighbour);
        }
    }

    private boolean checkCoord(int[] coord, int[][] rooms) {
        int row = rooms.length;
        int column = rooms[0].length;
        return coord[0] >= 0 && coord[0] < row && coord[1] >= 0 && coord[1] < column;
    }
}