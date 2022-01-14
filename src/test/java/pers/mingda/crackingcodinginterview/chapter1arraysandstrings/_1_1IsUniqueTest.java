package pers.mingda.crackingcodinginterview.chapter1arraysandstrings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class _1_1IsUniqueTest {

    @Test
    public void testIsUniqueWithArrys() {    
        _1_1IsUnique subject = new _1_1IsUnique();

        String testStr = "abcdefg12345,.#@";
        assertTrue(subject.isUniqueWithArrys(testStr));

        testStr = "abcdea";
        assertFalse(subject.isUniqueWithArrys(testStr));
    }
}