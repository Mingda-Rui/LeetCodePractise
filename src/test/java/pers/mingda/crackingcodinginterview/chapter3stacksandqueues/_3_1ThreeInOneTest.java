package pers.mingda.crackingcodinginterview.chapter3stacksandqueues;

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

        RuntimeException re = assertThrows(RuntimeException.class, () -> fms.push(2, 5));
        assertEquals("The stack is full", re.getMessage());

        assertEquals(4, fms.pull(0));
        assertEquals(1, fms.pull(0));
        assertThrows(EmptyStackException.class, () -> fms.pull(0));

        assertEquals(3, fms.pull(2));
        assertEquals(2, fms.pull(1));
    }

}
