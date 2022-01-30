package pers.mingda.crackingcodinginterview.chapter2linkedlists;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _2_7IntersectionTest {

    private LinkedListTestHelper testHelper;

    @BeforeEach
    public void setup() {
        testHelper = new LinkedListTestHelper();
    }

    @Test
    public void test() {
        LinkedListNode l1 = testHelper.buildNodeList(List.of(3, 1, 5, 9, 7, 2, 1));
        LinkedListNode l2 = testHelper.buildNodeList(List.of(4, 6, 7, 2, 1));

        assertNull(_2_7Intersection.findIntersection(l1, l2));
    }
}