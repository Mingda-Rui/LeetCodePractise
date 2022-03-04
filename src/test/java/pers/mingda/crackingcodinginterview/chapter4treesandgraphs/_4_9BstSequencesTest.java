package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _4_9BstSequencesTest {

    private TreeNodeTestHelper testHelper;

    @BeforeEach
    public void setup() {
        testHelper = new TreeNodeTestHelper();
    }

    @Test
    public void testAllSequences() {
        TreeNode node = testHelper.createTreeNode(2, 1, 3);
        List<List<Integer>> result = _4_9BstSequences.allSequences(node);
        int[][] expected = {{2, 1, 3}, {2, 3, 1}};
        Set<int[]> expectedSet = new HashSet<>();
        Collections.addAll(expectedSet, expected);
        assertTrue(arrayEquals(expectedSet, result));
    }

    private boolean arrayEquals(Set<int[]> expected, List<List<Integer>> results) {
        if (expected.size() != results.size())
            return false;
        for (List<Integer> result: results) {
            int[] resultArr = result.stream().mapToInt(i -> i).toArray();

            int[] sameArr = null;
            for (int[] expectedArr: expected) {
                if (Arrays.equals(expectedArr, resultArr)) {
                    sameArr = expectedArr;
                    break;
                }
            }
            if (sameArr != null)
                expected.remove(sameArr);
            else
                return false;
        }
        return expected.isEmpty();
    }
}