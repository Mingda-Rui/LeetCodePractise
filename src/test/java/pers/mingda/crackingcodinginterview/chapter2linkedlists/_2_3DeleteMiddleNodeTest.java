package pers.mingda.crackingcodinginterview.chapter2linkedlists;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _2_3DeleteMiddleNodeTest {
    
    private LinkedListTestHelper testHelper;

    @BeforeEach
    public void setup() {
        testHelper = new LinkedListTestHelper();
    }
    
    @Test
    public void testDeleteNode() {
        // test remove node in between
        List<Integer> nodeValues = List.of(1, 2, 3, 4, 5);
        LinkedListNode deletedNode = null;
        LinkedListNode node = new LinkedListNode(null, nodeValues.get(0));
        LinkedListNode head = node;
        for (int i = 1; i < nodeValues.size(); i++) {
            node.next = new LinkedListNode(null, nodeValues.get(i));
            node = node.next;
            if (node.data == 2) {
                deletedNode = node;
            }
        }

        List<Integer> expectedValues = List.of(1, 3, 4, 5);
        LinkedListNode expected = testHelper.buildNodeList(expectedValues);

        assertTrue(_2_3DeleteMiddleNode.deleteNode(deletedNode));
        assertTrue(testHelper.equals(expected, head));


        // test remove the last node
        deletedNode = null;
        node = new LinkedListNode(null, nodeValues.get(0));
        for (int i = 1; i < nodeValues.size(); i++) {
            node.next = new LinkedListNode(null, nodeValues.get(i));
            node = node.next;
            if (node.data == 5) {
                deletedNode = node;
            }
        }
        assertFalse(_2_3DeleteMiddleNode.deleteNode(deletedNode));
    }
}
