package pers.mingda.crackingcodinginterview.chapter2linkedlists;

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
        int kth = _2_2ReturnKthToLast.printKthToLast(node, 4);
        assertEquals(3, kth);

        kth = _2_2ReturnKthToLast.printKthToLast(node, 1);
        assertEquals(6, kth);

        kth = _2_2ReturnKthToLast.printKthToLast(node, 6);
        assertEquals(1, kth);

        Exception thrown = assertThrows(IllegalArgumentException.class, () -> {
            _2_2ReturnKthToLast.printKthToLast(node, 10);
        });
        assertEquals("The size of the list is " + nodeValues.size() + ", which is less than " + 10, thrown.getMessage());
    }
    
}
