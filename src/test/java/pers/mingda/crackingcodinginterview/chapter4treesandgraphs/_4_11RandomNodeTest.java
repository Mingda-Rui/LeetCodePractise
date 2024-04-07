package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class _4_11RandomNodeTest {

    private static TreeNodeTestHelper TEST_HELPER;

    @BeforeAll
    public static void setup() {
        TEST_HELPER = new TreeNodeTestHelper();
    }

    @Test
    public void getRandomNodeTest() {
        TreeNode root = createTestTree();
        assertNotNull(root.getRandomNode());
    }

    @Test
    public void deleteTest() {
        TreeNode root = createTestTree();
        root.delete(2);
        assertEquals(4, root.size());
    }

    @Test
    public void findTest() {
        TreeNode root = createTestTree();
        final int expectedData = 6;
        TreeNode found = root.find(expectedData);
        assertEquals(expectedData ,found.data);
    }

    /**
     *     4
     *    / \
     *   2   6
     *  /\  /\
     * 1 3 5 7
     */
    private TreeNode createTestTree() {
        TreeNode left = TEST_HELPER.createTreeNode(2, 1, 3);
        TreeNode right = TEST_HELPER.createTreeNode(6, 5, 7);
        return TEST_HELPER.createTreeNode(4, left, right);
    }
}
