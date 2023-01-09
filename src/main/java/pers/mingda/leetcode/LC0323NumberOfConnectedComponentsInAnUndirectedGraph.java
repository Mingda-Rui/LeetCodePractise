package pers.mingda.leetcode;

public class LC0323NumberOfConnectedComponentsInAnUndirectedGraph {

}

class LC0323UnionFindSolution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges)
            uf.union(edge[0], edge[1]);
        return uf.getSetCount();
    }
}

class UnionFind {
    private int[] parent;
    private int setCount;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.setCount = n;
        for (int i = 0; i < n; i ++)
            parent[i] = i;
    }

    private int find(int node) {
        while (parent[node] != node)
            node = parent[node];
        return node;
    }

    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2)
            setCount--;
        parent[root1] = root2;
    }

    public int getSetCount() {
        return setCount;
    }
}