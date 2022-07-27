package pers.mingda.leetcode;

public class LC0329LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int longest = 0;
        int[][] record = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                longest = Math.max(longest, longestIncreasingPathDfs(matrix, record, i, j));
        return longest;
    }

    private int longestIncreasingPathDfs(int[][] matrix, int[][] record, int x, int y) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
            return 0;
        if (record[x][y] != 0)
            return record[x][y];
        int longest = 0;
        if (indexCheck(matrix, x - 1, y) && matrix[x][y] < matrix[x - 1][y])
            longest = Math.max(longest, longestIncreasingPathDfs(matrix, record, x - 1, y));
        if (indexCheck(matrix, x + 1, y) && matrix[x][y] < matrix[x + 1][y])
            longest = Math.max(longest, longestIncreasingPathDfs(matrix, record, x + 1, y));
        if (indexCheck(matrix, x, y - 1) && matrix[x][y] < matrix[x][y - 1])
            longest = Math.max(longest, longestIncreasingPathDfs(matrix, record, x, y - 1));
        if (indexCheck(matrix, x, y + 1) && matrix[x][y] < matrix[x][y + 1])
            longest = Math.max(longest, longestIncreasingPathDfs(matrix, record, x, y + 1));
        longest++;
        record[x][y] = longest;
        return longest;
    }

    private boolean indexCheck(int[][] matrix, int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }
}
