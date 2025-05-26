package pers.mingda.cracking_the_coding_interview.chapter5_bit_manipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _5_1InsertionTest {

  private _5_1Insertion subject;

  @BeforeEach
  public void setUp() {
    subject = new _5_1Insertion();
  }

  @Test
  public void testInsertion() {
    final int N = Integer.parseInt("10000000000", 2);
    final int M = Integer.parseInt("10011", 2);
    final int i = 2;
    final int j = 6;
    final int expected = Integer.parseInt("10001001100", 2);
    assertEquals(expected, subject.insertion(N, M, i, j));
  }
}
