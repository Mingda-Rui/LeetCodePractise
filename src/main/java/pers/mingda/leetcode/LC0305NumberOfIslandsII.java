package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LC0305NumberOfIslandsII {

}

class LC0305Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        LC0305UnionFind uf = new LC0305UnionFind(m, n);
        List<Integer> result = new LinkedList<>();

        for (int[] pos: positions) {
            List<Integer> posList = Arrays.asList(pos[0], pos[1]);
            int islandNum = uf.LC0305UnionFind(posList);
            result.add(islandNum);
        }

        return result;
    }
}

class LC0305UnionFind {

    private int row;
    private int column;
    private int[][] positions;
    private int numOfIslands;
    private int[][] dir;
    private Map<List<Integer>, List<Integer>> record;

    public LC0305UnionFind(int row, int column) {
        this.row = row;
        this.column = column;
        this.positions = new int[row][column];
        this.numOfIslands = 0;
        int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        this.dir = d;
        this.record = new HashMap<>();
    }

    private List<Integer> find(List<Integer> pos) {
        while (record.containsKey(pos)) {
            List<Integer> parent = record.get(pos);
            if (isSame(parent, pos))
                return parent;
            pos = parent;
        }
        return pos;
    }

    public int LC0305UnionFind(List<Integer> pos) {
        int x = pos.get(0);
        int y = pos.get(1);
        positions[x][y] = 1;
        if (record.containsKey(pos))
            return numOfIslands;
        numOfIslands++;
        record.put(pos, pos);
        for (int[] offset: dir) {
            List<Integer> neigh = Arrays.asList(x + offset[0], y + offset[1]);
            if (!boundaryCheck(neigh) || !isIsland(neigh))
                continue;
            if (union(neigh, pos))
                numOfIslands--;
        }
        return numOfIslands;
    }

    private boolean union(List<Integer> neigh, List<Integer> pos) {
        List<Integer> neighRoot = find(neigh);
        List<Integer> posRoot = find(pos);

        if (isSame(neighRoot, posRoot))
            return false;
        record.put(posRoot, neighRoot);
        return true;
    }

    private boolean boundaryCheck(List<Integer> pos) {
        int x = pos.get(0);
        int y = pos.get(1);
        return x >= 0 && x < row && y >= 0 && y < column;
    }

    private boolean isSame(List<Integer> pos1, List<Integer> pos2) {
        return pos1.get(0) == pos2.get(0) && pos1.get(1) == pos2.get(1);
    }

    private boolean isIsland(List<Integer> pos) {
        int x = pos.get(0);
        int y = pos.get(1);
        return positions[x][y] == 1;
    }
}