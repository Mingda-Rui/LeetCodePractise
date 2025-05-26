package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _4_2MinimalTreeTest {

  private TreeNodeTestHelper testHelper;

  @BeforeEach
  public void setup() {
    testHelper = new TreeNodeTestHelper();
  }

  @Test
  public void testCreateMinimalBST() {
    int[] arrays = new int[] {};
    TreeNode minimalBST = _4_2MinimalTree.createMinimalBST(arrays);
    assertNull(minimalBST);

    arrays = new int[] { 1, 2, 3 };
    minimalBST = _4_2MinimalTree.createMinimalBST(arrays);
    TreeNode expected = testHelper.createTreeNode(2, 1, 3);
    assertTrue(testHelper.compare(expected, minimalBST));

    arrays = new int[] { 1, 2, 3, 4, 5, 6 };
    minimalBST = _4_2MinimalTree.createMinimalBST(arrays);
    String expectedSerial = "[4, 2, 6, 1, 3, 5]";
    expected = testHelper.deserializeTreeNode(expectedSerial);
    assertTrue(testHelper.compare(expected, minimalBST));
  }

  @Test
  public void testCreateMinimalBstInsertNode() {
    int[] arrays = new int[] {};
    TreeNode minimalBST = _4_2MinimalTree.createMinimalBstInsertNode(arrays);
    assertNull(minimalBST);

    arrays = new int[] { 1, 2, 3 };
    minimalBST = _4_2MinimalTree.createMinimalBstInsertNode(arrays);
    TreeNode expected = testHelper.createTreeNode(2, 1, 3);
    assertTrue(testHelper.compare(expected, minimalBST));

    arrays = new int[] { 1, 2, 3, 4, 5, 6 };
    minimalBST = _4_2MinimalTree.createMinimalBstInsertNode(arrays);
    String expectedSerial = "[4, 2, 6, 1, 3, 5]";
    expected = testHelper.deserializeTreeNode(expectedSerial);
    assertTrue(testHelper.compare(expected, minimalBST));
  }
}
