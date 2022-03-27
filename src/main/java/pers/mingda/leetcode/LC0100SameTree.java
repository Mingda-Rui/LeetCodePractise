package pers.mingda.leetcode;

public class LC0100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        boolean isSame = p.val == q.val;
        isSame = isSame && isSameTree(p.left, q.left);
        isSame = isSame && isSameTree(p.right, q.right);
        return isSame;
    }
}
