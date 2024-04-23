package pers.mingda.cracking_the_coding_interview.chapter2_linked_lists;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTestHelperTest {

    private LinkedListTestHelper testHelper;

    @BeforeEach
    public void setup() {
        testHelper = new LinkedListTestHelper();
    }

    @Test
    public void testBuildNodeList() {
        List<Integer> nodeValues = List.of(0, 1, 2, 3, 4);
        LinkedListNode node = testHelper.buildNodeList(nodeValues);

        for (int nodeValue: nodeValues) {
            assertEquals(nodeValue, node.data);
            node = node.next;
        }
        assertNull(node);
    }

    @Test
    public void testEquals() {
        List<Integer> nodeValues = List.of(0, 1, 2, 3, 4);
        
        LinkedListNode node = testHelper.buildNodeList(nodeValues);
        LinkedListNode equalNode = testHelper.buildNodeList(nodeValues);
        assertTrue(testHelper.equals(node, equalNode));

        List<Integer> unequalNodeValues = List.of(0, 1, 2, 3, 5);
        LinkedListNode unequalNode = testHelper.buildNodeList(unequalNodeValues);
        assertFalse(testHelper.equals(node, unequalNode));
    }

    @Test
    public void testGetSize() {
        List<Integer> nodeValues = List.of(0);
        LinkedListNode node = testHelper.buildNodeList(nodeValues);

        int nodeSize = testHelper.getSize(node);
        assertEquals(nodeValues.size(), nodeSize);

        
        nodeValues = List.of(0, 1, 2, 3, 4);
        node = testHelper.buildNodeList(nodeValues);

        nodeSize = testHelper.getSize(node);
        assertEquals(nodeValues.size(), nodeSize);
    }
}
