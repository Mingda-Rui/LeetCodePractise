package pers.mingda.crackingcodinginterview.chapter1arraysandstrings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class _1_6StringCompressionTest {
    
    @Test
    public void testStringCompression() {
        String testStr = "aabcccccaaa";
        assertEquals("a2b1c5a3", _1_6StringCompression.stringCompression(testStr));

        testStr = "abcde";
        assertEquals("abcde", _1_6StringCompression.stringCompression(testStr));

        testStr = "aabbccdd";
        assertEquals("aabbccdd", _1_6StringCompression.stringCompression(testStr));

        testStr = "aabbccddd";
        assertEquals("a2b2c2d3", _1_6StringCompression.stringCompression(testStr));
    }
}
