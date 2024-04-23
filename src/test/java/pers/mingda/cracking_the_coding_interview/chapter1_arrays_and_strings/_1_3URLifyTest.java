package pers.mingda.cracking_the_coding_interview.chapter1_arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class _1_3URLifyTest {
    
    @Test
    public void testURLify() {
        String testStr = "Mr John Smith   ";
        assertEquals("Mr%20John%20Smith", _1_3URLify.urlify(testStr.toCharArray(), 13));

        testStr = "Mr  John ";
        assertEquals("Mr%20%20John", _1_3URLify.urlify(testStr.toCharArray(), 8));

        testStr = "  MrJohn ";
        assertEquals("%20%20MrJohn", _1_3URLify.urlify(testStr.toCharArray(), 8));
    }

    @Test
    public void testURLifySameArray() {
        char[] testArr = "Mr John Smith    ".toCharArray();
        _1_3URLify.urlifySameArray(testArr, 13);
        assertArrayEquals("Mr%20John%20Smith".toCharArray(), testArr);

        testArr = "Mr  John    ".toCharArray();
        _1_3URLify.urlifySameArray(testArr, 8);
        assertArrayEquals("Mr%20%20John".toCharArray(), testArr);

        testArr = "  MrJohn    ".toCharArray();
        _1_3URLify.urlifySameArray(testArr, 8);
        assertArrayEquals("%20%20MrJohn".toCharArray(), testArr);
    }
}
