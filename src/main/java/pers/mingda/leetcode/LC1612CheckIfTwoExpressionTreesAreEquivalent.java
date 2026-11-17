package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LC1612CheckIfTwoExpressionTreesAreEquivalent {
}

class LC1612Node {
  char val;
      LC1612Node left;
      LC1612Node right;
      LC1612Node() {this.val = ' ';}
      LC1612Node(char val) { this.val = val; }
      LC1612Node(char val, LC1612Node left, LC1612Node right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
  }
 
class LC1612Solution {
  public boolean checkEquivalence(LC1612Node root1, LC1612Node root2) {
    Map<Character, Integer> nodeCount1 = new HashMap<>();
    countLC1612Node(root1, nodeCount1);
    Map<Character, Integer> nodeCount2 = new HashMap<>();
    countLC1612Node(root2, nodeCount2);
    return Objects.equals(nodeCount1, nodeCount2);
  }

  private void countLC1612Node(LC1612Node root, Map<Character, Integer> count) {
    if (root == null) {
      return;
    }
    int c = count.getOrDefault(root.val, 0);
    count.put(root.val, c + 1);
    countLC1612Node(root.left, count);
    countLC1612Node(root.right, count);
  }
}
