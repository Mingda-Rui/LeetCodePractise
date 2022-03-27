package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC0417PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlanticDfs(int[][] heights) {
        List<List<Integer>> result = new LinkedList<>();
        int[][] record = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++)
            dfs(heights, record, i, 0, 0, 0, 1);

        for (int j = 0; j < heights[0].length; j++)
            dfs(heights, record, 0, j, 0, 0, 1);

        int maxX = heights.length - 1;
        int maxY = heights[0].length - 1;
        for (int i = 0; i < heights.length; i++)
            dfs(heights, record, i, maxY, maxX, maxY, 2);

        for (int j = 0; j < heights[0].length; j++)
            dfs(heights, record, maxX, j, maxX, maxY, 2);

        for (int i = 0; i < heights.length; i++)
            for (int j = 0; j < heights[0].length; j++)
                if (record[i][j] == 3)
                    result.add(Arrays.asList(i, j));

        return result;
    }

    private void dfs(int[][] heights, int[][] record, int x, int y, int shoreX, int shoreY, int sea) {
        if (record[x][y] >= sea)
            return;
        record[x][y] += sea;
        int[][] neighbors = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] neighbor: neighbors) {
            int nextX = x + neighbor[0];
            int nextY = y + neighbor[1];
            if (checkCoord(heights, nextX, nextY) && heights[nextX][nextY] >= heights[x][y])
                dfs(heights, record, nextX, nextY, shoreX, shoreY, sea);
        }
    }

    private boolean checkCoord(int[][] heights, int x, int y) {
        return x >= 0 && x < heights.length && y >= 0 && y < heights[0].length;
    }
}
