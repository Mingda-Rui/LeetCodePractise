package pers.mingda.cracking_the_coding_interview.chapter2_linked_lists;

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
  public void testFindIntersection() {
    LinkedListNode l1 = testHelper.buildNodeList(List.of(3, 1, 5, 9, 7, 2, 1));
    LinkedListNode l2 = testHelper.buildNodeList(List.of(4, 6, 7, 2, 1));

    LinkedListNode actualIntersection = _2_7Intersection.findIntersection(l1, l2);
    assertNull(actualIntersection);

    l1 = testHelper.buildNodeList(List.of(3, 1, 5, 9, 7, 2, 1));
    l2 = testHelper.buildNodeList(List.of(3, 1, 5, 9, 7, 2, 1));

    actualIntersection = _2_7Intersection.findIntersection(l1, l2);
    assertNull(actualIntersection);

    l1 = testHelper.buildNodeList(List.of(3, 1, 5, 9, 7, 2, 1));
    l2 = l1;

    actualIntersection = _2_7Intersection.findIntersection(l1, l2);
    assertTrue(l1 == actualIntersection);

    LinkedListNode l1Front = testHelper.buildNodeList(List.of(3, 1, 5, 9));
    LinkedListNode l2Front = testHelper.buildNodeList(List.of(4, 6));
    LinkedListNode intersection = testHelper.buildNodeList(List.of(7, 2, 1));
    l1Front.next = intersection;
    l2Front.next = intersection;

    actualIntersection = _2_7Intersection.findIntersection(l1Front, l2Front);
    assertTrue(intersection == actualIntersection);

    l1Front = testHelper.buildNodeList(List.of(5, 9));
    l2Front = testHelper.buildNodeList(List.of(4, 6));
    intersection = testHelper.buildNodeList(List.of(7, 2, 1));
    l1Front.next = intersection;
    l2Front.next = intersection;

    actualIntersection = _2_7Intersection.findIntersection(l1Front, l2Front);
    assertTrue(intersection == actualIntersection);

    l1Front = testHelper.buildNodeList(List.of(3, 1, 5, 9));
    l2Front = testHelper.buildNodeList(List.of(4, 6));
    intersection = testHelper.buildNodeList(List.of(7));
    l1Front.next = intersection;
    l2Front.next = intersection;

    actualIntersection = _2_7Intersection.findIntersection(l1Front, l2Front);
    assertTrue(intersection == actualIntersection);
  }

  @Test
  public void testFindIntersectionChopOff() {
    LinkedListNode l1 = testHelper.buildNodeList(List.of(3, 1, 5, 9, 7, 2, 1));
    LinkedListNode l2 = testHelper.buildNodeList(List.of(4, 6, 7, 2, 1));

    LinkedListNode actualIntersection = _2_7Intersection.findIntersectionChopOff(l1, l2);
    assertNull(actualIntersection);

    l1 = testHelper.buildNodeList(List.of(3, 1, 5, 9, 7, 2, 1));
    l2 = testHelper.buildNodeList(List.of(3, 1, 5, 9, 7, 2, 1));

    actualIntersection = _2_7Intersection.findIntersectionChopOff(l1, l2);
    assertNull(actualIntersection);

    l1 = testHelper.buildNodeList(List.of(3, 1, 5, 9, 7, 2, 1));
    l2 = l1;

    actualIntersection = _2_7Intersection.findIntersectionChopOff(l1, l2);
    assertTrue(l1 == actualIntersection);

    LinkedListNode l1Front = testHelper.buildNodeList(List.of(3, 1, 5, 9));
    LinkedListNode l2Front = testHelper.buildNodeList(List.of(4, 6));
    LinkedListNode intersection = testHelper.buildNodeList(List.of(7, 2, 1));
    l1Front.next = intersection;
    l2Front.next = intersection;

    actualIntersection = _2_7Intersection.findIntersectionChopOff(l1Front, l2Front);
    assertTrue(intersection == actualIntersection);

    l1Front = testHelper.buildNodeList(List.of(5, 9));
    l2Front = testHelper.buildNodeList(List.of(4, 6));
    intersection = testHelper.buildNodeList(List.of(7, 2, 1));
    l1Front.next = intersection;
    l2Front.next = intersection;

    actualIntersection = _2_7Intersection.findIntersectionChopOff(l1Front, l2Front);
    assertTrue(intersection == actualIntersection);

    l1Front = testHelper.buildNodeList(List.of(3, 1, 5, 9));
    l2Front = testHelper.buildNodeList(List.of(4, 6));
    intersection = testHelper.buildNodeList(List.of(7));
    l1Front.next = intersection;
    l2Front.next = intersection;

    actualIntersection = _2_7Intersection.findIntersectionChopOff(l1Front, l2Front);
    assertTrue(intersection == actualIntersection);
  }
}
