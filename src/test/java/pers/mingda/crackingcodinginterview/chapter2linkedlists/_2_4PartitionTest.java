package pers.mingda.crackingcodinginterview.chapter2linkedlists;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _2_4PartitionTest {
    
    private LinkedListTestHelper testHelper;

    @BeforeEach
    public void setup() {
        testHelper = new LinkedListTestHelper();
    }

    @Test
    public void testPartition() {
        // Input:       3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
        // Output:      3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8

        List<Integer> testValues = List.of(3, 5, 8, 5, 10, 2, 1);
        LinkedListNode testNode = testHelper.buildNodeList(testValues);

        int partitionVal  = 5;
        LinkedListNode result = _2_4Partition.partition(testNode, partitionVal);
        int resultSize = testHelper.getSize(result);
        assertEquals(testValues.size(), resultSize);
        
        boolean shouldSmall = true;
        while (result != null) {
            if (result.data >= partitionVal && shouldSmall) {
                shouldSmall = false;
            }
            if (shouldSmall) {
                assertTrue(result.data < partitionVal);
            } else {
                assertFalse(result.data < partitionVal);
            }
            result = result.next;
        }
    }

    @Test
    public void testPartitionAddToHead() {
        // Input:       3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
        // Output:      3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8

        List<Integer> testValues = List.of(3, 5, 8, 5, 10, 2, 1);
        LinkedListNode testNode = testHelper.buildNodeList(testValues);

        int partitionVal  = 5;
        LinkedListNode result = _2_4Partition.partitionAddToHead(testNode, partitionVal);
        int resultSize = testHelper.getSize(result);
        assertEquals(testValues.size(), resultSize);
        
        boolean shouldSmall = true;
        while (result != null) {
            if (result.data >= partitionVal && shouldSmall) {
                shouldSmall = false;
            }
            if (shouldSmall) {
                assertTrue(result.data < partitionVal);
            } else {
                assertFalse(result.data < partitionVal);
            }
            result = result.next;
        }
    }
}
