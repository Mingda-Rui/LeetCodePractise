package pers.mingda.crackingcodinginterview.chapter1arraysandstrings;

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
}
