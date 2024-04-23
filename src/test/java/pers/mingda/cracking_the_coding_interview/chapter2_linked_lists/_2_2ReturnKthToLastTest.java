package pers.mingda.cracking_the_coding_interview.chapter2_linked_lists;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _2_2ReturnKthToLastTest {

    private LinkedListTestHelper testHelper;

    @BeforeEach
    public void setup() {
        testHelper = new LinkedListTestHelper();
    }

    @Test
    public void testPrintKthToLast() {
        List<Integer> nodeValues = List.of(1, 2, 3, 4, 5, 6);
        LinkedListNode node = testHelper.buildNodeList(nodeValues);        
        LinkedListNode kthNode = _2_2ReturnKthToLast.kthToLast(node, 4);
        assertEquals(3, kthNode.data);

        kthNode = _2_2ReturnKthToLast.kthToLast(node, 1);
        assertEquals(6, kthNode.data);

        kthNode = _2_2ReturnKthToLast.kthToLast(node, 6);
        assertEquals(1, kthNode.data);

        Exception thrown = assertThrows(IllegalArgumentException.class, () -> {
            _2_2ReturnKthToLast.kthToLast(node, 10);
        });
        assertEquals("The size of the list is " + nodeValues.size() + ", which is less than " + 10, thrown.getMessage());
    }
    
    @Test
    public void testPrintKthToLastRecursive() {
        List<Integer> nodeValues = List.of(1, 2, 3, 4, 5, 6);
        LinkedListNode node = testHelper.buildNodeList(nodeValues);        
        LinkedListNode kthNode = _2_2ReturnKthToLast.kthToLastRecursive(node, 4);
        assertEquals(3, kthNode.data);

        kthNode = _2_2ReturnKthToLast.kthToLastRecursive(node, 1);
        assertEquals(6, kthNode.data);

        kthNode = _2_2ReturnKthToLast.kthToLastRecursive(node, 6);
        assertEquals(1, kthNode.data);

        Exception thrown = assertThrows(IllegalArgumentException.class, () -> {
            _2_2ReturnKthToLast.kthToLastRecursive(node, 10);
        });
        assertEquals("The size of the list is " + nodeValues.size() + ", which is less than " + 10, thrown.getMessage());
    }
}
