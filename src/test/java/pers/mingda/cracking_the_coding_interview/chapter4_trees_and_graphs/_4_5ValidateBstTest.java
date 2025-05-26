package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _4_5ValidateBstTest {

  private TreeNodeTestHelper testHelper;

  @BeforeEach
  public void setup() {
    testHelper = new TreeNodeTestHelper();
  }

  @Test
  public void testCheckBst() {
    TreeNode node = testHelper.createTreeNode(2, 1, 3);
    assertTrue(_4_5ValidateBst.checkBst(node));

    node = testHelper.createTreeNode(1, null, new TreeNode(2));
    assertTrue(_4_5ValidateBst.checkBst(node));

    node = testHelper.createTreeNode(1, 1, 3);
    assertTrue(_4_5ValidateBst.checkBst(node));

    node = testHelper.createTreeNode(1, 2, 3);
    assertFalse(_4_5ValidateBst.checkBst(node));

    node = testHelper.createTreeNode(2, 1, 2);
    assertFalse(_4_5ValidateBst.checkBst(node));

    TreeNode two = testHelper.createTreeNode(2, 1, 3);
    TreeNode six = testHelper.createTreeNode(6, 5, 7);
    node = testHelper.createTreeNode(4, two, six);
    assertTrue(_4_5ValidateBst.checkBst(node));

    two = testHelper.createTreeNode(2, null, new TreeNode(2));
    node = testHelper.createTreeNode(3, two, null);
    assertFalse(_4_5ValidateBst.checkBst(node));

    TreeNode one = testHelper.createTreeNode(1, null, 3);
    node = testHelper.createTreeNode(2, one, null);
    assertFalse(_4_5ValidateBst.checkBst(node));
  }

  @Test
  public void testCheckBstMinMax() {
    TreeNode node = testHelper.createTreeNode(2, 1, 3);
    assertTrue(_4_5ValidateBst.checkBstMinMax(node));

    node = testHelper.createTreeNode(1, null, new TreeNode(2));
    assertTrue(_4_5ValidateBst.checkBstMinMax(node));

    node = testHelper.createTreeNode(1, 1, 3);
    assertTrue(_4_5ValidateBst.checkBstMinMax(node));

    node = testHelper.createTreeNode(1, 2, 3);
    assertFalse(_4_5ValidateBst.checkBstMinMax(node));

    node = testHelper.createTreeNode(2, 1, 2);
    assertFalse(_4_5ValidateBst.checkBstMinMax(node));

    TreeNode two = testHelper.createTreeNode(2, 1, 3);
    TreeNode six = testHelper.createTreeNode(6, 5, 7);
    node = testHelper.createTreeNode(4, two, six);
    assertTrue(_4_5ValidateBst.checkBstMinMax(node));

    two = testHelper.createTreeNode(2, null, new TreeNode(2));
    node = testHelper.createTreeNode(3, two, null);
    assertFalse(_4_5ValidateBst.checkBstMinMax(node));

    TreeNode one = testHelper.createTreeNode(1, null, 3);
    node = testHelper.createTreeNode(2, one, null);
    assertFalse(_4_5ValidateBst.checkBstMinMax(node));
  }
}
