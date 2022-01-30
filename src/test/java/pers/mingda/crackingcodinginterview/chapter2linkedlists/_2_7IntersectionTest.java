package pers.mingda.crackingcodinginterview.chapter2linkedlists;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        LinkedListNode l1Front = testHelper.buildNodeList(List.of(3, 1, 5, 9));
        LinkedListNode l2Front = testHelper.buildNodeList(List.of(4, 6));
        LinkedListNode intersection = testHelper.buildNodeList(List.of(7, 2, 1));
        l1Front.next = intersection;
        l2Front.next = intersection;

        LinkedListNode actualIntersection = _2_7Intersection.findIntersection(l1Front, l2Front);
        assertTrue(testHelper.equals(intersection, actualIntersection));


        l1Front = testHelper.buildNodeList(List.of(3, 1, 5, 9));
        l2Front = testHelper.buildNodeList(List.of(4, 6));
        intersection = testHelper.buildNodeList(List.of(7));
        l1Front.next = intersection;
        l2Front.next = intersection;

        actualIntersection = _2_7Intersection.findIntersection(l1Front, l2Front);
        assertTrue(testHelper.equals(intersection, actualIntersection));


        l1Front = testHelper.buildNodeList(List.of(3, 1, 5, 9));
        l2Front = l1Front;
        l1Front.next = intersection;
        l2Front.next = intersection;

        actualIntersection = _2_7Intersection.findIntersection(l1Front, l2Front);
        assertTrue(testHelper.equals(l1Front, actualIntersection));
    }
}