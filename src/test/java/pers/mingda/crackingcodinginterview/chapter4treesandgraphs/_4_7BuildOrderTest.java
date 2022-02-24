package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class _4_7BuildOrderTest {

    @Test
    public void testFindBuildOrder() {
        String[] projects = new String[]{"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = new String[][]{new String[]{"a", "d"}, new String[]{"f", "b"}, new String[]{"b", "d"}, new String[]{"f", "a"}, new String[]{"d", "c"}};
        String[] orderedBuild = _4_7BuildOrder.findBuildOrder(projects, dependencies);
        boolean isEqual = Arrays.compare(new String[]{"e", "f", "a", "b", "d", "c"}, orderedBuild) == 0;
        isEqual = isEqual || Arrays.compare(new String[]{"f", "e", "a", "b", "d", "c"}, orderedBuild) == 0;
        isEqual = isEqual || Arrays.compare(new String[]{"e", "f", "b", "a", "d", "c"}, orderedBuild) == 0;
        isEqual = isEqual || Arrays.compare(new String[]{"f", "e", "b", "a", "d", "c"}, orderedBuild) == 0;
        assertTrue(isEqual);
    }
}
