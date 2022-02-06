package pers.mingda.crackingcodinginterview.chapter3stacksandqueues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _3_5SortStackTest {

    private _3_5SortStack ss;

    @BeforeEach
    public void setup() {
        ss = new _3_5SortStack();
    }

    @Test
    public void testSortStack() {
        ss.push(1);
        assertEquals(1, ss.pop());

        ss.push(2);
        ss.push(3);
        ss.push(4);
        assertEquals(2, ss.pop());
        ss.push(1);
        ss.push(5);
        ss.push(3);
        assertEquals(1, ss.pop());
        assertEquals(3, ss.pop());
        assertEquals(3, ss.pop());
        assertEquals(4, ss.pop());
        assertEquals(5, ss.pop());
    }

    @Test
    public void testSort() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        ss.sort(stack);
        assertEquals(1, stack.pop());

        stack = new Stack<>();
        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(5);
        ss.sort(stack);
        assertEquals(1, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(5, stack.pop());
    }
}
