package pers.mingda.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC1650LowestCommonAncestorOfABinaryTreeIII {
}

class LC1659Node {
    public int val;
    public LC1659Node left;
    public LC1659Node right;
    public LC1659Node parent;
};

class LC1650SetSolution {
  public LC1659Node lowestCommonAncestor(LC1659Node p, LC1659Node q) {
    Set<LC1659Node> pAncestors = new HashSet<>();
    while (p != null) {
      pAncestors.add(p);
      p = p.parent;
    }
    while (q != null) {
      if (pAncestors.contains(q)) {
        return q;
      }
      q = q.parent;
    }
    return null;
  }
}

class LC1650TwoRunnersCircleTrackSolution {
  public LC1659Node lowestCommonAncestor(LC1659Node p, LC1659Node q) {
    LC1659Node a = p;
    LC1659Node b = q;
    while (a != b) {
      a = (a == null ? q : a.parent);
      b = (b == null ? p : b.parent);
    }
    return a;
  }
}