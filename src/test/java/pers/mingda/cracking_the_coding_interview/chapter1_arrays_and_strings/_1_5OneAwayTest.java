package pers.mingda.cracking_the_coding_interview.chapter1_arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class _1_5OneAwayTest {

  @Test
  public void testIsOneAway() {
    String testStr1 = "pale";
    String testStr2 = "ple";
    assertTrue(_1_5OneAway.isOneAway(testStr1, testStr2));

    testStr1 = "pales";
    testStr2 = "pale";
    assertTrue(_1_5OneAway.isOneAway(testStr1, testStr2));

    testStr1 = "pale";
    testStr2 = "bale";
    assertTrue(_1_5OneAway.isOneAway(testStr1, testStr2));

    testStr1 = "pale";
    testStr2 = "bae";
    assertFalse(_1_5OneAway.isOneAway(testStr1, testStr2));

    testStr1 = "pale";
    testStr2 = "apale";
    assertTrue(_1_5OneAway.isOneAway(testStr1, testStr2));
  }

  @Test
  public void testIsOneAwayOneDirection() {
    String testStr1 = "pale";
    String testStr2 = "ple";
    assertTrue(_1_5OneAway.isOneAwayOneDirection(testStr1, testStr2));

    testStr1 = "pales";
    testStr2 = "pale";
    assertTrue(_1_5OneAway.isOneAwayOneDirection(testStr1, testStr2));

    testStr1 = "pale";
    testStr2 = "bale";
    assertTrue(_1_5OneAway.isOneAwayOneDirection(testStr1, testStr2));

    testStr1 = "pale";
    testStr2 = "bae";
    assertFalse(_1_5OneAway.isOneAwayOneDirection(testStr1, testStr2));

    testStr1 = "pale";
    testStr2 = "apale";
    assertTrue(_1_5OneAway.isOneAwayOneDirection(testStr1, testStr2));
  }
}
