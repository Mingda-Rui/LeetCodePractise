package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _4_8FirstCommonAncestorTest {
    private TreeNodeTestHelper testHelper;

    @BeforeEach
    public void setup() {
        testHelper = new TreeNodeTestHelper();
    }

    @Test
    public void testCommonAncestor() {
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode root = testHelper.createTreeNode(1, two, three);
        TreeNode commonAncestor = _4_8FirstCommonAncestor.commonAncestor(root, two, three);
        assertTrue(root == commonAncestor);

        two = testHelper.createTreeNode(2, 4, 5);
        TreeNode nine = new TreeNode(9);
        TreeNode six = testHelper.createTreeNode(6, 8, nine);
        TreeNode eleven = new TreeNode(11);
        TreeNode seven = testHelper.createTreeNode(7, 10, eleven);
        three = testHelper.createTreeNode(3, six, seven);
        root = testHelper.createTreeNode(1, two, three);
        commonAncestor = _4_8FirstCommonAncestor.commonAncestor(root, nine, eleven);
        assertTrue(three == commonAncestor);

        TreeNode four = new TreeNode(4);
        TreeNode two2 = new TreeNode(2);
        TreeNode root2 = testHelper.createTreeNode(1, two, 3);
        Exception ex = assertThrows(RuntimeException.class, () -> _4_8FirstCommonAncestor.commonAncestor(root2, two2, four));
        assertEquals("No common ancestor!", ex.getMessage());
    }

    @Test
    public void testCommonAncestorReturnNode() {
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode root = testHelper.createTreeNode(1, two, three);
        TreeNode commonAncestor = _4_8FirstCommonAncestor.commonAncestorReturnNode(root, two, three);
        assertTrue(root == commonAncestor);

        two = testHelper.createTreeNode(2, 4, 5);
        TreeNode nine = new TreeNode(9);
        TreeNode six = testHelper.createTreeNode(6, 8, nine);
        TreeNode eleven = new TreeNode(11);
        TreeNode seven = testHelper.createTreeNode(7, 10, eleven);
        three = testHelper.createTreeNode(3, six, seven);
        root = testHelper.createTreeNode(1, two, three);
        commonAncestor = _4_8FirstCommonAncestor.commonAncestorReturnNode(root, nine, eleven);
        assertTrue(three == commonAncestor);

        TreeNode four = new TreeNode(4);
        TreeNode two2 = new TreeNode(2);
        TreeNode root2 = testHelper.createTreeNode(1, two, 3);
        Exception ex = assertThrows(RuntimeException.class, () -> _4_8FirstCommonAncestor.commonAncestorReturnNode(root2, two2, four));
        assertEquals("No common ancestor!", ex.getMessage());
    }

    @Test
    public void testCommonAncestorLinksToParents() {
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode root = testHelper.createTreeNode(1, two, three);
        TreeNode commonAncestor = _4_8FirstCommonAncestor.commonAncestorLinksToParents(two, three);
        assertTrue(root == commonAncestor);

        two = testHelper.createTreeNode(2, 4, 5);
        TreeNode nine = new TreeNode(9);
        TreeNode six = testHelper.createTreeNode(6, 8, nine);
        TreeNode eleven = new TreeNode(11);
        TreeNode seven = testHelper.createTreeNode(7, 10, eleven);
        three = testHelper.createTreeNode(3, six, seven);
        root = testHelper.createTreeNode(1, two, three);
        commonAncestor = _4_8FirstCommonAncestor.commonAncestorLinksToParents(nine, eleven);
        assertTrue(three == commonAncestor);

        TreeNode four = new TreeNode(4);
        TreeNode two2 = new TreeNode(2);
        TreeNode root2 = testHelper.createTreeNode(1, two, 3);
        Exception ex = assertThrows(RuntimeException.class, () -> _4_8FirstCommonAncestor.commonAncestorLinksToParents(two2, four));
        assertEquals("No common ancestor!", ex.getMessage());
    }

    @Test
    public void testCommonAncestorCheckCoverTheOtherNode() {
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode root = testHelper.createTreeNode(1, two, three);
        TreeNode commonAncestor = _4_8FirstCommonAncestor.commonAncestorCheckCoverTheOtherNode(two, three);
        assertTrue(root == commonAncestor);

        two = testHelper.createTreeNode(2, 4, 5);
        TreeNode nine = new TreeNode(9);
        TreeNode six = testHelper.createTreeNode(6, 8, nine);
        TreeNode eleven = new TreeNode(11);
        TreeNode seven = testHelper.createTreeNode(7, 10, eleven);
        three = testHelper.createTreeNode(3, six, seven);
        root = testHelper.createTreeNode(1, two, three);
        commonAncestor = _4_8FirstCommonAncestor.commonAncestorCheckCoverTheOtherNode(nine, eleven);
        assertTrue(three == commonAncestor);

        TreeNode four = new TreeNode(4);
        TreeNode two2 = new TreeNode(2);
        TreeNode root2 = testHelper.createTreeNode(1, two, 3);
        Exception ex = assertThrows(RuntimeException.class, () -> _4_8FirstCommonAncestor.commonAncestorCheckCoverTheOtherNode(two2, four));
        assertEquals("No common ancestor!", ex.getMessage());
    }
}
