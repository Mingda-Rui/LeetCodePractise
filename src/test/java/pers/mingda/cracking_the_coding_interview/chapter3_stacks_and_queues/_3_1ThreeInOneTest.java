package pers.mingda.cracking_the_coding_interview.chapter3_stacks_and_queues;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

public class _3_1ThreeInOneTest {

  @Test
  public void testFixedMultiStack() {
    FixedMultiStack fms = new FixedMultiStack(5);
    fms.push(0, 1);
    fms.push(1, 2);
    fms.push(2, 3);
    fms.push(0, 4);

    RuntimeException re = assertThrows(RuntimeException.class, () ->
      fms.push(2, 5)
    );
    assertEquals("The stack is full", re.getMessage());

    assertEquals(4, fms.pop(0));
    assertEquals(1, fms.pop(0));
    assertThrows(EmptyStackException.class, () -> fms.pop(0));

    assertEquals(3, fms.pop(2));
    assertEquals(2, fms.pop(1));
  }

  @Test
  public void testMultiStack() {
    MultiStack ms = new MultiStack(3, 2);
    ms.push(0, 1);
    ms.push(1, 2);
    ms.push(2, 3);
    ms.push(0, 4);
    ms.push(0, 5);
    ms.push(2, 6);

    assertEquals(5, ms.pop(0));
    assertEquals(4, ms.pop(0));
    assertEquals(1, ms.pop(0));

    assertEquals(6, ms.pop(2));
    assertEquals(2, ms.pop(1));
    assertEquals(3, ms.pop(2));

    ms = new MultiStack(3, 2);
    ms.push(0, 1);
    ms.push(0, 2);
    ms.push(0, 3);
    ms.push(2, 4);
    ms.push(2, 5);
    ms.push(1, 6);

    assertEquals(6, ms.pop(1));

    assertEquals(5, ms.pop(2));
    assertEquals(4, ms.pop(2));

    assertEquals(3, ms.pop(0));
    assertEquals(2, ms.pop(0));
    assertEquals(1, ms.pop(0));
  }
}
