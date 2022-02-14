package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TreeNodeTestHelperTest {

    private TreeNodeTestHelper testHelper;

    @BeforeEach
    public void setup() {
        testHelper = new TreeNodeTestHelper();
    }

    @Test
    public void testRemoveTailingNull() {
        String str = "1, 2, 3, NULL, 4, NULL,";
        assertEquals("1, 2, 3, NULL, 4", testHelper.removeTailingNull(str));

        str = "1, 2, 3, NULL, NULL";
        assertEquals("1, 2, 3", testHelper.removeTailingNull(str));

        str = "a, b, c, d";
        assertEquals("", testHelper.removeTailingNull(str));
    }

    @Test
    public void testTreeNodeSerializer() {
        TreeNode root = testHelper.createTreeNode(1, 2, 3);
        assertEquals("[1, 2, 3]", testHelper.treeNodeSerialize(root));

        TreeNode left = testHelper.createTreeNode(2, 4, 5);
        TreeNode right = testHelper.createTreeNode(3, 6, 7);
        root = testHelper.createTreeNode(1, left, right);
        assertEquals("[1, 2, 3, 4, 5, 6, 7]", testHelper.treeNodeSerialize(root));

        root = testHelper.createTreeNode(1, new TreeNode(2), right);
        right = testHelper.createTreeNode(3, 6, 7);
        assertEquals("[1, 2, 3, null, null, 6, 7]", testHelper.treeNodeSerialize(root));

        TreeNode five = testHelper.createTreeNode(5, 7, 8);
        left = testHelper.createTreeNode(2, null, five);
        right = testHelper.createTreeNode(3, null, new TreeNode(6));
        root = testHelper.createTreeNode(1, left, right);
        assertEquals("[1, 2, 3, null, 5, null, 6, 7, 8]", testHelper.treeNodeSerialize(root));
    }

    @Test
    public void testCreateTreeNode() {
        TreeNode root = testHelper.createTreeNode(1, 2, 3);
        assertEquals(1, root.data);
        assertEquals(2, root.left.data);
        assertEquals(3, root.right.data);

        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(6);
        root = testHelper.createTreeNode(4, left, right);
        assertEquals(4, root.data);
        assertEquals(5, root.left.data);
        assertEquals(6, root.right.data);

        left = new TreeNode(8);
        root = testHelper.createTreeNode(7, left, null);
        assertEquals(7, root.data);
        assertEquals(8, root.left.data);
        assertNull(root.right);
    }

    @Test
    public void testCompare() {
        final TreeNode root1 = testHelper.createTreeNode(1, 2, 3);
        TreeNode root2 = testHelper.createTreeNode(1, 2, 3);
        assertTrue(testHelper.compare(root1, root2));

        root2 = testHelper.createTreeNode(1, 2, 4);
        assertFalse(testHelper.compare(root1, root2));

        root2 = testHelper.createTreeNode(1, new TreeNode(2), null);
        assertFalse(testHelper.compare(root1, root2));
    }

    @Test
    public void testGetNextIndex() {
        String serial = "[]";
        assertEquals(-1, testHelper.getNextIndex(serial, 0));

        serial = "[1, 22, 333, null, 4]";
        //        01234567890123456789
        assertEquals(1, testHelper.getNextIndex(serial, 0));
        assertEquals(4, testHelper.getNextIndex(serial, 1));
        assertEquals(8, testHelper.getNextIndex(serial, 5));
        assertEquals(13, testHelper.getNextIndex(serial, 11));
        assertEquals(19, testHelper.getNextIndex(serial, 15));
        assertEquals(-1, testHelper.getNextIndex(serial, 25));
    }

    @Test
    public void testGetValue() {

    }
}
