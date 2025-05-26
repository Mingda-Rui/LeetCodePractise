package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _4_4CheckBalancedTest {

  private TreeNodeTestHelper testHelper;

  @BeforeEach
  public void setup() {
    testHelper = new TreeNodeTestHelper();
  }

  @Test
  public void testIsBalanced() {
    TreeNode node = testHelper.createTreeNode(1, null, null);
    assertTrue(_4_4CheckBalanced.isBalanced(node));

    TreeNode two = testHelper.createTreeNode(2, 4, 5);
    TreeNode three = testHelper.createTreeNode(3, 6, 7);
    node = testHelper.createTreeNode(1, two, three);
    assertTrue(_4_4CheckBalanced.isBalanced(node));

    two = testHelper.createTreeNode(2, new TreeNode(4), null);
    three = testHelper.createTreeNode(3, null, new TreeNode(7));
    node = testHelper.createTreeNode(1, two, three);
    assertTrue(_4_4CheckBalanced.isBalanced(node));

    TreeNode four = testHelper.createTreeNode(4, new TreeNode(5), null);
    two = testHelper.createTreeNode(2, four, null);
    node = testHelper.createTreeNode(1, two, new TreeNode(3));
    assertFalse(_4_4CheckBalanced.isBalanced(node));
  }
}
