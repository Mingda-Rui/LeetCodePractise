package pers.mingda.cracking_the_coding_interview.chapter2_linked_lists;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _2_1RemoveDupsTest {

  LinkedListTestHelper testHelper;

  @BeforeEach
  public void setup() {
    testHelper = new LinkedListTestHelper();
  }

  @Test
  public void testDeleteDups() {
    List<Integer> nodeValues = List.of(1, 2, 3, 4, 5, 1);
    LinkedListNode node = testHelper.buildNodeList(nodeValues);

    List<Integer> expectedNodeValues = List.of(1, 2, 3, 4, 5);
    LinkedListNode expectedNode = testHelper.buildNodeList(expectedNodeValues);

    _2_1RemoveDups.deleteDups(node);

    assertTrue(testHelper.equals(expectedNode, node));

    nodeValues = List.of(1, 2, 3, 4, 5, 1, 6, 2, 7);
    node = testHelper.buildNodeList(nodeValues);

    expectedNodeValues = List.of(1, 2, 3, 4, 5, 6, 7);
    expectedNode = testHelper.buildNodeList(expectedNodeValues);

    _2_1RemoveDups.deleteDups(node);

    assertTrue(testHelper.equals(expectedNode, node));

    nodeValues = List.of(1, 2, 3, 4);
    node = testHelper.buildNodeList(nodeValues);

    expectedNodeValues = nodeValues;
    expectedNode = testHelper.buildNodeList(expectedNodeValues);

    _2_1RemoveDups.deleteDups(node);

    assertTrue(testHelper.equals(expectedNode, node));
  }

  @Test
  public void testDeleteDupsNoBuffer() {
    List<Integer> nodeValues = List.of(1, 2, 3, 4, 5, 1);
    LinkedListNode node = testHelper.buildNodeList(nodeValues);

    List<Integer> expectedNodeValues = List.of(1, 2, 3, 4, 5);
    LinkedListNode expectedNode = testHelper.buildNodeList(expectedNodeValues);

    _2_1RemoveDups.deleteDupsNoBuffer(node);

    assertTrue(testHelper.equals(expectedNode, node));

    nodeValues = List.of(1, 2, 3, 4, 5, 1, 6, 2, 7);
    node = testHelper.buildNodeList(nodeValues);

    expectedNodeValues = List.of(1, 2, 3, 4, 5, 6, 7);
    expectedNode = testHelper.buildNodeList(expectedNodeValues);

    _2_1RemoveDups.deleteDupsNoBuffer(node);

    assertTrue(testHelper.equals(expectedNode, node));

    nodeValues = List.of(1, 2, 3, 4);
    node = testHelper.buildNodeList(nodeValues);

    expectedNodeValues = nodeValues;
    expectedNode = testHelper.buildNodeList(expectedNodeValues);

    _2_1RemoveDups.deleteDupsNoBuffer(node);

    assertTrue(testHelper.equals(expectedNode, node));
  }
}
