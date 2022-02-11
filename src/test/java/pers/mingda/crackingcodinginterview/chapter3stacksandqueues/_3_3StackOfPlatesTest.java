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

    @Test
    public void testStackOfPlatesPopAt() {
        SetOfStacks sos = new SetOfStacks(2);
        sos.push(1);
        sos.push(2);
        sos.push(3);
        sos.push(4);
        sos.push(5);
        sos.push(6);
        assertEquals(6, sos.popAt(5));
        assertEquals(5, sos.popAt(4));
        assertEquals(4, sos.popAt(3));
        assertEquals(3, sos.popAt(2));
        assertEquals(2, sos.popAt(1));
        assertEquals(1, sos.popAt(0));
        assertThrows(EmptyStackException.class, () -> sos.popAt(0));

        SetOfStacks sos2 = new SetOfStacks(2);
        sos2.push(1);
        sos2.push(2);
        sos2.push(3);
        sos2.push(4);
        sos2.push(5);
        sos2.push(6);
        assertEquals(1, sos2.popAt(0));
        assertEquals(2, sos2.popAt(0));
        assertEquals(3, sos2.popAt(0));
        assertEquals(4, sos2.popAt(0));
        assertEquals(5, sos2.popAt(0));
        assertEquals(6, sos2.popAt(0));
        assertThrows(EmptyStackException.class, () -> sos2.popAt(0));

        SetOfStacks sos3 = new SetOfStacks(2);
        sos3.push(1);
        sos3.push(2);
        sos3.push(3);
        sos3.push(4);
        sos3.push(5);
        sos3.push(6);
        assertEquals(1, sos3.popAt(0));
        assertEquals(3, sos3.popAt(1));
        assertEquals(5, sos3.popAt(2));
        assertEquals(2, sos3.popAt(0));
        assertEquals(6, sos3.popAt(1));
        assertEquals(4, sos3.popAt(0));
        assertThrows(EmptyStackException.class, () -> sos2.popAt(0));
    }
}
