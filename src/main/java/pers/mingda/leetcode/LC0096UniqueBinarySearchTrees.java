package pers.mingda.leetcode;

public class LC0096UniqueBinarySearchTrees {
    public int numTrees(int n) {
        return numTrees(n, 1, n + 1, new int[n + 1]);
    }

    private int numTrees(int n, int start, int end, int[] record) {
        int distance = end - start;
        if (distance <= 1)
            return 1;
        if (record[distance] != 0)
            return record[distance];
        int count = 0;
        for (int i = start; i < end; i++)
            count += (numTrees(n, start, i, record) * numTrees(n, i + 1, end, record));
        record[distance] = count;
        return count;
    }
}
