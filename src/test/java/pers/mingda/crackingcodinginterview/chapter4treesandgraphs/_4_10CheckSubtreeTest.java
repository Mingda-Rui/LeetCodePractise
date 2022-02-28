package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _4_10CheckSubtreeTest {

    private TreeNodeTestHelper testHelper;

    @BeforeEach
    public void setup() {
        testHelper = new TreeNodeTestHelper();
    }

    @Test
    public void testContainsTree() {
        TreeNode t1 = null;
        TreeNode t2 = null;
        assertTrue(_4_10CheckSubtree.containsTree(t1, t2));

        t1 = testHelper.createTreeNode(1, 2, 3);
        t2 = null;
        assertTrue(_4_10CheckSubtree.containsTree(t1, t2));

        t1 = testHelper.createTreeNode(1, 2, 3);
        t2 = new TreeNode(2);
        assertTrue(_4_10CheckSubtree.containsTree(t1, t2));

        t1 = testHelper.createTreeNode(1, 2, 3);
        t2 = testHelper.createTreeNode(1, 2, 3);
        assertTrue(_4_10CheckSubtree.containsTree(t1, t2));

        TreeNode two = testHelper.createTreeNode(2, 4, 5);
        TreeNode three = testHelper.createTreeNode(3, 6, 7);
        t1 = testHelper.createTreeNode(1, two, three);
        t2 = new TreeNode(5);
        assertTrue(_4_10CheckSubtree.containsTree(t1, t2));


        two = testHelper.createTreeNode(2, 4, 5);
        three = testHelper.createTreeNode(3, 6, 7);
        t1 = testHelper.createTreeNode(1, two, three);
        t2 = testHelper.createTreeNode(3, 6, 7);
        assertTrue(_4_10CheckSubtree.containsTree(t1, t2));


        two = testHelper.createTreeNode(2, 4, 5);
        three = testHelper.createTreeNode(3, 6, 7);
        t1 = testHelper.createTreeNode(1, two, three);
        t2 = testHelper.createTreeNode(2, 5, 4);
        assertFalse(_4_10CheckSubtree.containsTree(t1, t2));
    }
}
