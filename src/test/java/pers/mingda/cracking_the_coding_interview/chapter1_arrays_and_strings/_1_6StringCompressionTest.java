package pers.mingda.cracking_the_coding_interview.chapter1_arrays_and_strings;

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

    testStr = "aaabbbc";
    assertEquals("a3b3c1", _1_6StringCompression.stringCompression(testStr));
  }

  @Test
  public void testStringCompressionCountFirst() {
    String testStr = "aabcccccaaa";
    assertEquals("a2b1c5a3", _1_6StringCompression.stringCompressionCountFirst(testStr));

    testStr = "abcde";
    assertEquals("abcde", _1_6StringCompression.stringCompressionCountFirst(testStr));

    testStr = "aabbccdd";
    assertEquals("aabbccdd", _1_6StringCompression.stringCompressionCountFirst(testStr));

    testStr = "aabbccddd";
    assertEquals("a2b2c2d3", _1_6StringCompression.stringCompressionCountFirst(testStr));

    testStr = "aaabbbc";
    assertEquals("a3b3c1", _1_6StringCompression.stringCompressionCountFirst(testStr));
  }
}
