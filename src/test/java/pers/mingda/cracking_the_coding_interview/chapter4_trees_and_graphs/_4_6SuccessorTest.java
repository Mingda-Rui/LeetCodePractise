package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _4_6SuccessorTest {

  private TreeNodeTestHelper testHelper;

  @BeforeEach
  public void setup() {
    testHelper = new TreeNodeTestHelper();
  }

  @Test
  public void testInorderSucc() {
    TreeNode four = new TreeNode(4);
    TreeNode five = new TreeNode(5);
    TreeNode two = testHelper.createTreeNode(2, four, five);
    TreeNode six = new TreeNode(6);
    TreeNode three = testHelper.createTreeNode(3, six, 7);
    TreeNode root = testHelper.createTreeNode(1, two, three);

    assertTrue(root == _4_6Successor.inorderSucc(five));
    assertTrue(six == _4_6Successor.inorderSucc(root));
    assertTrue(two == _4_6Successor.inorderSucc(four));
    assertTrue(five == _4_6Successor.inorderSucc(two));
    assertTrue(three == _4_6Successor.inorderSucc(six));
  }
}
