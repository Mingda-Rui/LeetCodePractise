package pers.mingda.leetcode;

public class LC0079WordSearch {
    public boolean exist(char[][] board, String word) {
        int height = board.length;
        int width = board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[height][width];
                boolean findWord = exist(board, i, j, word, 0, visited);
                if (findWord) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int x, int y, String word, int wordIndex, boolean[][] visited) {
        if (wordIndex == word.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        char curr = word.charAt(wordIndex);
        if (visited[x][y] || board[x][y] != curr) return false;

        visited[x][y] = true;
        boolean result = false;
        result = result || exist(board, x + 1, y, word, wordIndex + 1, visited);
        result = result || exist(board, x - 1, y, word, wordIndex + 1, visited);
        result = result || exist(board, x, y + 1, word, wordIndex + 1, visited);
        result = result || exist(board, x, y - 1, word, wordIndex + 1, visited);
        visited[x][y] = false;
        return result;
    }
}
