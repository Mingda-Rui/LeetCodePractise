package pers.mingda.crackingcodinginterview.chapter2linkedlists;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _2_5SumListsTest {
    
    private LinkedListTestHelper testHelper;

    @BeforeEach
    public void setup() {
        testHelper = new LinkedListTestHelper();
    }

    @Test
    public void testSumLists() {
        LinkedListNode l1 = testHelper.buildNodeList(List.of(7, 1, 6));
        LinkedListNode l2 = testHelper.buildNodeList(List.of(5, 9, 2));
        LinkedListNode expected = testHelper.buildNodeList(List.of(2, 1, 9));
        
        LinkedListNode result = _2_5SumLists.sumLists(l1, l2);
        assertTrue(testHelper.equals(expected, result));


        l1 = testHelper.buildNodeList(List.of(7, 1, 7));
        l2 = testHelper.buildNodeList(List.of(5, 9, 2));
        expected = testHelper.buildNodeList(List.of(2, 1, 0, 1));
        
        result = _2_5SumLists.sumLists(l1, l2);
        assertTrue(testHelper.equals(expected, result));

        l1 = testHelper.buildNodeList(List.of(1));
        l2 = testHelper.buildNodeList(List.of(9, 9, 9));
        expected = testHelper.buildNodeList(List.of(0, 0, 0, 1));
        
        result = _2_5SumLists.sumLists(l1, l2);
        assertTrue(testHelper.equals(expected, result));
    }

    @Test
    public void testSumListsRecursive() {
        LinkedListNode l1 = testHelper.buildNodeList(List.of(7, 1, 6));
        LinkedListNode l2 = testHelper.buildNodeList(List.of(5, 9, 2));
        LinkedListNode expected = testHelper.buildNodeList(List.of(2, 1, 9));
        
        LinkedListNode result = _2_5SumLists.sumListsRecursive(l1, l2);
        assertTrue(testHelper.equals(expected, result));


        l1 = testHelper.buildNodeList(List.of(7, 1, 7));
        l2 = testHelper.buildNodeList(List.of(5, 9, 2));
        expected = testHelper.buildNodeList(List.of(2, 1, 0, 1));
        
        result = _2_5SumLists.sumListsRecursive(l1, l2);
        assertTrue(testHelper.equals(expected, result));

        l1 = testHelper.buildNodeList(List.of(1));
        l2 = testHelper.buildNodeList(List.of(9, 9, 9));
        expected = testHelper.buildNodeList(List.of(0, 0, 0, 1));
        
        result = _2_5SumLists.sumListsRecursive(l1, l2);
        assertTrue(testHelper.equals(expected, result));
    }

    @Test
    public void testSumListsFollowUpReverse() {
        LinkedListNode l1 = testHelper.buildNodeList(List.of(6, 1, 7));
        LinkedListNode l2 = testHelper.buildNodeList(List.of(2, 9, 5));
        LinkedListNode expected = testHelper.buildNodeList(List.of(9, 1, 2));
        
        LinkedListNode result = _2_5SumLists.sumListsFollowUpReverse(l1, l2);
        assertTrue(testHelper.equals(expected, result));


        l1 = testHelper.buildNodeList(List.of(7, 1, 7));
        l2 = testHelper.buildNodeList(List.of(2, 9, 5));
        expected = testHelper.buildNodeList(List.of(1, 0, 1, 2));
        
        result = _2_5SumLists.sumListsFollowUpReverse(l1, l2);
        assertTrue(testHelper.equals(expected, result));

        l1 = testHelper.buildNodeList(List.of(1));
        l2 = testHelper.buildNodeList(List.of(9, 9, 9));
        expected = testHelper.buildNodeList(List.of(1, 0, 0, 0));
        
        result = _2_5SumLists.sumListsFollowUpReverse(l1, l2);
        assertTrue(testHelper.equals(expected, result));
    }

    @Test
    public void testSumListsFollowUp() {
        LinkedListNode l1 = testHelper.buildNodeList(List.of(6, 1, 7));
        LinkedListNode l2 = testHelper.buildNodeList(List.of(2, 9, 5));
        LinkedListNode expected = testHelper.buildNodeList(List.of(9, 1, 2));
        
        LinkedListNode result = _2_5SumLists.sumListsFollowUp(l1, l2);
        assertTrue(testHelper.equals(expected, result));


        l1 = testHelper.buildNodeList(List.of(7, 1, 7));
        l2 = testHelper.buildNodeList(List.of(2, 9, 5));
        expected = testHelper.buildNodeList(List.of(1, 0, 1, 2));
        
        result = _2_5SumLists.sumListsFollowUp(l1, l2);
        assertTrue(testHelper.equals(expected, result));

        l1 = testHelper.buildNodeList(List.of(1));
        l2 = testHelper.buildNodeList(List.of(9, 9, 9));
        expected = testHelper.buildNodeList(List.of(1, 0, 0, 0));
        
        result = _2_5SumLists.sumListsFollowUp(l1, l2);
        assertTrue(testHelper.equals(expected, result));
    }
}
