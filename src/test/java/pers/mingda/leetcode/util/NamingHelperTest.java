package pers.mingda.leetcode.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pers.mingda.leetcode.util.NamingHelper.getClassNumByPrefix;
import static pers.mingda.leetcode.util.NamingHelper.getClassPrefixByNum;

import org.junit.jupiter.api.Test;

public class NamingHelperTest {

  @Test
  public void tesGetClassPrefixByNum() {
    assertThrows(IllegalArgumentException.class, () -> getClassPrefixByNum(0));
    assertEquals("AAB", getClassPrefixByNum(1));
    assertEquals("AAC", getClassPrefixByNum(2));
    assertEquals("AAK", getClassPrefixByNum(10));
    assertEquals("AAZ", getClassPrefixByNum(25));
    assertEquals("ABA", getClassPrefixByNum(26));
    assertEquals("AJQ", getClassPrefixByNum(250));
    assertEquals("AZA", getClassPrefixByNum(650));
    assertEquals("ZAA", getClassPrefixByNum(16900));
    assertEquals("ZCA", getClassPrefixByNum(16952));
    assertEquals("ZZZ", getClassPrefixByNum(17575));
    assertThrows(IllegalArgumentException.class, () ->
      getClassPrefixByNum(17576)
    );
  }

  @Test
  public void testGet() {
    assertEquals(0, getClassNumByPrefix("AAA"));
    assertEquals(1, getClassNumByPrefix("AAB"));
    assertEquals(2, getClassNumByPrefix("AAC"));
    assertEquals(10, getClassNumByPrefix("AAK"));
    assertEquals(25, getClassNumByPrefix("AAZ"));
    assertEquals(26, getClassNumByPrefix("ABA"));
    assertEquals(250, getClassNumByPrefix("AJQ"));
    assertEquals(650, getClassNumByPrefix("AZA"));
    assertEquals(16900, getClassNumByPrefix("ZAA"));
    assertEquals(16952, getClassNumByPrefix("ZCA"));
    assertEquals(17575, getClassNumByPrefix("ZZZ"));

    assertEquals(25, getClassNumByPrefix("Z"));
    assertEquals(26, getClassNumByPrefix("BA"));
    assertThrows(IllegalArgumentException.class, () -> getClassNumByPrefix(""));
    assertThrows(IllegalArgumentException.class, () -> getClassNumByPrefix("6#")
    );
    assertThrows(IllegalArgumentException.class, () ->
      getClassNumByPrefix("ZZZZ")
    );
  }
}
