package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

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
    public void testSerializeTreeNode() {
        TreeNode root = testHelper.createTreeNode(1, 2, 3);
        assertEquals("[1, 2, 3]", testHelper.serializeTreeNode(root));

        TreeNode left = testHelper.createTreeNode(2, 4, 5);
        TreeNode right = testHelper.createTreeNode(3, 6, 7);
        root = testHelper.createTreeNode(1, left, right);
        assertEquals("[1, 2, 3, 4, 5, 6, 7]", testHelper.serializeTreeNode(root));

        root = testHelper.createTreeNode(1, new TreeNode(2), right);
        right = testHelper.createTreeNode(3, 6, 7);
        assertEquals("[1, 2, 3, null, null, 6, 7]", testHelper.serializeTreeNode(root));

        TreeNode five = testHelper.createTreeNode(5, 7, 8);
        left = testHelper.createTreeNode(2, null, five);
        right = testHelper.createTreeNode(3, null, new TreeNode(6));
        root = testHelper.createTreeNode(1, left, right);
        assertEquals("[1, 2, 3, null, 5, null, 6, 7, 8]", testHelper.serializeTreeNode(root));
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
    public void testCreateTreeNodeParentReference() {
        TreeNode left = new TreeNode(2);
        TreeNode right = new  TreeNode(3);
        TreeNode root = testHelper.createTreeNode(1, left, right);
        assertTrue(root == left.parent);
        assertTrue(root == right.parent);
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
        String serial = "[]";
        assertTrue(testHelper.getValue(serial, 0).isEmpty());

        serial = "[1, 22, 333, null, 4]";
        //        01234567890123456789
        assertEquals("", testHelper.getValue(serial, 0));
        assertEquals("1", testHelper.getValue(serial, 1));
        assertEquals("", testHelper.getValue(serial, 3));
        assertEquals("22", testHelper.getValue(serial, 4));
        assertEquals("333", testHelper.getValue(serial, 8));
        assertEquals("null", testHelper.getValue(serial, 13));
        assertEquals("4", testHelper.getValue(serial, 19));
        assertEquals("", testHelper.getValue(serial, 25));
    }

    @Test
    public void testDeserializeTreeNode() {
        String serial = "[]";
        assertNull(testHelper.deserializeTreeNode(serial));


        serial = "[1, 2, 3]";
        TreeNode node = testHelper.deserializeTreeNode(serial);
        TreeNode expectedNode = testHelper.createTreeNode(1, 2, 3);
        assertTrue(testHelper.compare(expectedNode, node));


        serial = "[1, 2, 3, 4, 5, 6, 7]";
        node = testHelper.deserializeTreeNode(serial);
        TreeNode left = testHelper.createTreeNode(2, 4, 5);
        TreeNode right = testHelper.createTreeNode(3, 6, 7);
        expectedNode = testHelper.createTreeNode(1, left, right);
        assertTrue(testHelper.compare(expectedNode, node));


        serial = "[1, 2, 3, null, null, 6, 7]";
        node = testHelper.deserializeTreeNode(serial);
        right = testHelper.createTreeNode(3, 6, 7);
        expectedNode = testHelper.createTreeNode(1, new TreeNode(2), right);
        assertTrue(testHelper.compare(expectedNode, node));


        serial = "[1, 2, 3, null, 5, null, 6, 7, 8]";
        node = testHelper.deserializeTreeNode(serial);
        TreeNode five = testHelper.createTreeNode(5, 7, 8);
        left = testHelper.createTreeNode(2, null, five);
        right = testHelper.createTreeNode(3, null, new TreeNode(6));
        expectedNode = testHelper.createTreeNode(1, left, right);
        assertTrue(testHelper.compare(expectedNode, node));
    }
}
