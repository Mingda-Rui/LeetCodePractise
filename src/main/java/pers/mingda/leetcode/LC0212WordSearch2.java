package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LC0212WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        for (String word: words) {
            int currSize = result.size();
            for (int i = 0; i < board.length && currSize == result.size(); i++) {
                for (int j = 0; j < board[0].length && currSize == result.size(); j++)
                    if (findWordReverse(board, i, j, word, word.length() - 1, new boolean[board.length][board[0].length]))
                        result.add(word);
            }

        }
        return result;
    }

    private boolean findWordReverse(char[][] board, int x, int y, String word, int index, boolean[][] visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return false;
        char c =  word.charAt(index);
        if (visited[x][y] || board[x][y] != c)
            return false;
        visited[x][y] = true;
        boolean found = false;
        if (index == 0)
            return true;
        index--;
        found = found || findWordReverse(board, x + 1, y, word, index, visited);
        found = found || findWordReverse(board, x - 1, y, word, index, visited);
        found = found || findWordReverse(board, x, y + 1, word, index, visited);
        found = found || findWordReverse(board, x, y - 1, word, index, visited);
        visited[x][y] = false;
        return found;
    }
}
