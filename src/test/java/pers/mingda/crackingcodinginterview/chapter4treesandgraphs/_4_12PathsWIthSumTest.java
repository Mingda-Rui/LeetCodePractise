package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _4_12PathsWIthSumTest {

    private TreeNodeTestHelper testHelper;

    @BeforeEach
    public void setup() {
        testHelper = new TreeNodeTestHelper();
    }

    @Test
    public void testCountPathsWithSum() {
        TreeNode three = testHelper.createTreeNode(3, 3, -2);
        TreeNode two = testHelper.createTreeNode(2, null, 1);
        TreeNode five = testHelper.createTreeNode(5, three, two);
        TreeNode minusThree = testHelper.createTreeNode(-3, null, 11);
        TreeNode root = testHelper.createTreeNode(10, five, minusThree);
        int pathsWithSum = _4_12PathsWithSum.countPathsWithSum(root, 8);
        assertEquals(3, pathsWithSum);
    }

    @Test
    public void testCountPathsWithSumOptimized() {
        TreeNode three = testHelper.createTreeNode(3, 3, -2);
        TreeNode two = testHelper.createTreeNode(2, null, 1);
        TreeNode five = testHelper.createTreeNode(5, three, two);
        TreeNode minusThree = testHelper.createTreeNode(-3, null, 11);
        TreeNode root = testHelper.createTreeNode(10, five, minusThree);
        int pathsWithSum = _4_12PathsWithSum.countPathsWithSumOptimized(root, 8);
        assertEquals(3, pathsWithSum);
    }
}
