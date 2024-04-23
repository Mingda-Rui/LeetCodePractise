package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

/**
 *  4.10 Check Subtree: T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an
 *  algorithm to determine if T2 is a subtree of T1.
 *
 *  A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
 *  That is, if you cut off the tree at node n, the two trees would be identical.
 */

public class _4_10CheckSubtree {
    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        boolean containsSubtree = matchTree(t1, t2);
        if (!containsSubtree && t1 != null)
            return containsTree(t1.left, t2) || containsTree(t1.right, t2);

        return containsSubtree;
    }

    private static boolean matchTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;

        if (t1.data == t2.data)
            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);

        return false;
    }

}
