package pers.mingda.crackingcodinginterview.chapter3stacksandqueues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class _3_2StackMinTest {
    @Test
    public void testStackWithMin() {
        StackWithMin swm = new StackWithMin();
        swm.push(5);
        swm.push(2);
        swm.push(3);
        swm.push(1);
        swm.push(4);

        assertEquals(1, swm.min());
        assertEquals(4, swm.pop().val);
        assertEquals(1, swm.min());
        assertEquals(1, swm.pop().val);
        assertEquals(2, swm.min());
        assertEquals(3, swm.pop().val);
        assertEquals(2, swm.min());
        assertEquals(2, swm.pop().val);
        assertEquals(5, swm.min());
        assertEquals(5, swm.pop().val);
    }

}
