package pers.mingda.leetcode;

public class LC0200NumberOfIslands {
    public int numIslandsDfs(char[][] grid) {
        int counter = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (exploreIsland(grid, i, j, visited))
                    counter++;

        return counter;
    }

    private boolean exploreIsland(char[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= grid.length)
            return false;
        if (y < 0 || y >= grid[0].length)
            return false;
        if (visited[x][y])
            return false;

        visited[x][y] = true;
        if (grid[x][y] == '0')
            return false;

        exploreIsland(grid, x - 1, y, visited);
        exploreIsland(grid, x + 1, y, visited);
        exploreIsland(grid, x, y - 1, visited);
        exploreIsland(grid, x, y + 1, visited);
        return true;
    }
}
