package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _4_3ListOfDepthsTest {

    private TreeNodeTestHelper testHelper;

    @BeforeEach
    public void setup() {
        testHelper = new TreeNodeTestHelper();
    }

    @Test
    public void testCreateLevelLinkedList() {
        TreeNode node = testHelper.createTreeNode(1, 2, 3);
        List<List<TreeNode>> result = _4_3ListOfDepths.createLevelLinkedList(node);
        assertEquals(2, result.size());
        List<TreeNode> firstList = result.get(0);
        assertEquals(1, firstList.size());
        assertEquals(1, firstList.get(0).data);
        List<TreeNode> secondList = result.get(1);
        assertEquals(2, secondList.size());
        assertEquals(2, secondList.get(0).data);
        assertEquals(3, secondList.get(1).data);


        TreeNode five = testHelper.createTreeNode(5, 7, 8);
        TreeNode four = testHelper.createTreeNode(4, new TreeNode(6), null);
        TreeNode three = testHelper.createTreeNode(3, four, five);
        node = testHelper.createTreeNode(1, new TreeNode(2), three);

        result = _4_3ListOfDepths.createLevelLinkedList(node);
        assertEquals(4, result.size());
        firstList = result.get(0);
        assertEquals(1, firstList.size());
        assertEquals(1, firstList.get(0).data);

        secondList = result.get(1);
        assertEquals(2, secondList.size());
        assertEquals(2, secondList.get(0).data);
        assertEquals(3, secondList.get(1).data);

        List<TreeNode> thirdList = result.get(2);
        assertEquals(2, thirdList.size());
        assertEquals(4, thirdList.get(0).data);
        assertEquals(5, thirdList.get(1).data);

        List<TreeNode> fourthList = result.get(3);
        assertEquals(3, fourthList.size());
        assertEquals(6, fourthList.get(0).data);
        assertEquals(7, fourthList.get(1).data);
        assertEquals(8, fourthList.get(2).data);
    }

    @Test
    public void testCreateLevelLinkedListRecursive() {
        TreeNode node = testHelper.createTreeNode(1, 2, 3);
        List<List<TreeNode>> result = _4_3ListOfDepths.createLevelLinkedListRecursive(node);
        assertEquals(2, result.size());
        List<TreeNode> firstList = result.get(0);
        assertEquals(1, firstList.size());
        assertEquals(1, firstList.get(0).data);
        List<TreeNode> secondList = result.get(1);
        assertEquals(2, secondList.size());
        assertEquals(2, secondList.get(0).data);
        assertEquals(3, secondList.get(1).data);


        TreeNode five = testHelper.createTreeNode(5, 7, 8);
        TreeNode four = testHelper.createTreeNode(4, new TreeNode(6), null);
        TreeNode three = testHelper.createTreeNode(3, four, five);
        node = testHelper.createTreeNode(1, new TreeNode(2), three);

        result = _4_3ListOfDepths.createLevelLinkedListRecursive(node);
        assertEquals(4, result.size());
        firstList = result.get(0);
        assertEquals(1, firstList.size());
        assertEquals(1, firstList.get(0).data);

        secondList = result.get(1);
        assertEquals(2, secondList.size());
        assertEquals(2, secondList.get(0).data);
        assertEquals(3, secondList.get(1).data);

        List<TreeNode> thirdList = result.get(2);
        assertEquals(2, thirdList.size());
        assertEquals(4, thirdList.get(0).data);
        assertEquals(5, thirdList.get(1).data);

        List<TreeNode> fourthList = result.get(3);
        assertEquals(3, fourthList.size());
        assertEquals(6, fourthList.get(0).data);
        assertEquals(7, fourthList.get(1).data);
        assertEquals(8, fourthList.get(2).data);
    }
}
