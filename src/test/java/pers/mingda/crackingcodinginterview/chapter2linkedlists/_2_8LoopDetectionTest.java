package pers.mingda.crackingcodinginterview.chapter2linkedlists;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _2_8LoopDetectionTest {

    private LinkedListTestHelper testHelper;

    @BeforeEach
    public void setup() {
        testHelper = new LinkedListTestHelper();
    }

    @Test
    public void testFindBeginning() {
        LinkedListNode front = testHelper.buildNodeList(List.of(1, 2));
        LinkedListNode loop = buildLoop(List.of(3, 4, 5));
        front.next = loop;

        LinkedListNode conjunction = _2_8LoopDetection.findBeginning(front);
        assertTrue(loop == conjunction);


        loop =  buildLoop(List.of(1, 2, 3, 4, 5));

        conjunction = _2_8LoopDetection.findBeginning(loop);
        assertTrue(loop == conjunction);


        front = testHelper.buildNodeList(List.of(1, 2, 3, 4, 5));

        conjunction = _2_8LoopDetection.findBeginning(front);
        assertNull(conjunction);
    }

    private LinkedListNode buildLoop(List<Integer> values) {
        int size = values.size();
        LinkedListNode tail = new LinkedListNode(null, values.get(size -  1));
        LinkedListNode next = tail;

        for (int i = size - 2; i >= 0; i--) {
            LinkedListNode current = new LinkedListNode(next, i);
            next = current;
        }
        tail.next = next;
        return next;
    }
}
