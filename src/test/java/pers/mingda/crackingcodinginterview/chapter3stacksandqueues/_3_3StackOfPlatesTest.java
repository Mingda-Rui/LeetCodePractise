package pers.mingda.crackingcodinginterview.chapter3stacksandqueues;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

public class _3_3StackOfPlatesTest {
    @Test
    public void testStackOfPlates() {
        SetOfStacks sos = new SetOfStacks(2);
        sos.push(1);
        sos.push(2);
        sos.push(3);
        assertEquals(3, sos.pop());
        sos.push(4);
        sos.push(5);
        sos.push(6);
        assertEquals(6, sos.pop());
        assertEquals(5, sos.pop());
        assertEquals(4, sos.pop());
        assertEquals(2, sos.pop());
        assertEquals(1, sos.pop());
        assertThrows(EmptyStackException.class, () -> sos.pop());
    }
}
