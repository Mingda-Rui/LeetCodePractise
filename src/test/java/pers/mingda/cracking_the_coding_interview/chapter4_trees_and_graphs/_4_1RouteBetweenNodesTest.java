package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class _4_1RouteBetweenNodesTest {

    @Test
    public void testSearch() {
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        zero.addAdjacentNode(one);
        one.addAdjacentNode(two);
        two.addAdjacentNode(zero);
        Graph graph = new Graph(List.of(zero, one, two));
        assertTrue(_4_1RouteBetweenNodes.search(graph, zero, two));

        zero = new Node(0);
        one = new Node(1);
        two = new Node(2);
        Node three = new Node(3);
        zero.addAdjacentNode(one);
        one.addAdjacentNode(two);
        two.addAdjacentNode(zero);
        graph = new Graph(List.of(zero, one, two));
        assertFalse(_4_1RouteBetweenNodes.search(graph, zero, three));
    }
}
