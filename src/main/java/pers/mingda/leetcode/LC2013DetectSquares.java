package pers.mingda.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC2013DetectSquares {}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
class DetectSquares {

    private static final int MAX_VALUE = 1000;
    private final int[][] count;
    private final Set<List<Integer>> points;

    public DetectSquares() {
        int size = MAX_VALUE + 1;
        count = new int[size][size];
        points = new HashSet<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        count[x][y] += 1;
        points.add(List.of(x, y));
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int ans = 0;
        for (List<Integer> p3 : points) {
            if (!isDiagonal(x, y, p3)) {
                continue;
            }
            int p3X = p3.getFirst();
            int p3Y = p3.getLast();
            ans += count[p3X][p3Y] * count[x][p3Y] * count[p3X][y];
        }
        return ans;
    }

    private boolean isDiagonal(int x, int y, List<Integer> point) {
        int pX = point.getFirst();
        int pY = point.getLast();
        return x != pX && (Math.abs(x - pX) == Math.abs(y - pY));
    }
}