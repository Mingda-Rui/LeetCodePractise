package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class _4_11RandomNodeTest {

    private static TreeNodeTestHelper TEST_HELPER;

    @BeforeAll
    public static void setup() {
        TEST_HELPER = new TreeNodeTestHelper();
    }

    /**
     *     4
     *    / \
     *   2   6
     *  /\  /\
     * 1 3 5 7
     */
    @Test
    public void test() {
        TreeNode left = TEST_HELPER.createTreeNode(2, 1, 3);
        TreeNode right = TEST_HELPER.createTreeNode(6, 5, 7);
        TreeNode root = TEST_HELPER.createTreeNode(4, left, right);
        System.out.println(root.getRandomNode().data);
    }
}
