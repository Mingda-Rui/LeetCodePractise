package pers.mingda.leetcode;

public class LC0105ConstructBinaryTreeFromPreorderAndInorderTraversal {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int[] inorderMap = new int[6001];
    for (int i = 0; i < inorder.length; i++) {
      int val = inorder[i];
      inorderMap[val + 3000] = i;
    }
    return buildTree(preorder, 0, 0, inorder.length, inorderMap);
  }

  private TreeNode buildTree(int[] preorder, int index, int inL, int inR, int[] inorderMap) {
    if (inL == inR) return null;

    int parentVal = preorder[index];
    TreeNode parent = new TreeNode(parentVal);
    int pValInorder = inorderMap[parentVal + 3000];

    parent.left = buildTree(preorder, index + 1, inL, pValInorder, inorderMap);
    index = index + (pValInorder - inL + 1);
    parent.right = buildTree(preorder, index, pValInorder + 1, inR, inorderMap);
    return parent;
  }

  public TreeNode buildTreeNoMap(int[] preorder, int[] inorder) {
    return buildTreeNoMap(Integer.MAX_VALUE, preorder, new int[] {0}, inorder, new int[] {0});
  }

  public TreeNode buildTreeNoMap(
      int boundary, int[] preorder, int[] preIdxHolder, int[] inorder, int[] inIdxHolder) {
    if (preIdxHolder[0] >= preorder.length || boundary == inorder[inIdxHolder[0]]) return null;

    int val = preorder[preIdxHolder[0]];
    preIdxHolder[0]++;
    TreeNode node = new TreeNode(val);
    node.left = buildTreeNoMap(val, preorder, preIdxHolder, inorder, inIdxHolder);
    inIdxHolder[0]++;
    node.right = buildTreeNoMap(boundary, preorder, preIdxHolder, inorder, inIdxHolder);
    return node;
  }
}

// 1, 2, 3
// 2, 1, 3

//          1
//     2          3
//  4    5     6     7
// 8 9 10 11 12 13 14 15

//           0  1  2  3   4  5   6   7   8  9  10  11  12  13  14
// preorder: 1, 2, 4, 8,  9, 5, 10, 11,  3, 6, 12, 13,  7, 14, 15
//  inorder: 8, 4, 9, 2, 10, 5, 11,  1, 12, 6, 13,  3, 14,  7, 15
//           |  |  |  |  |   |  |    |

// helper(Max, pre0, in0)
//     val = 1;
//     pre1;
//     left = helper(1, pre1, in0);
//         val = 2;
//         pre2;
//         left = helper(2, pre2, in0);
//             val = 4;
//             pre3;
//             left = helper(4, pre3, in0);
//                 val = 8;
//                 pre4;
//                 left = helper(8, pre4 = 9, in0 = 8) = null;
//                 in1;
//                 right = helper(4, pre4 = 9, in1 = 4) = null;
//             left = 8;
//             in2;
//             right = helper(2, pre4, in2);
//             |   val = 9;
//             |   pre5;
//             |   left = helper(9, pre5, in2) = null;
//             |   in3;
//             |   right = helper(2, pre5, in3) = null;
//             right = 9;
//         left = 4;
