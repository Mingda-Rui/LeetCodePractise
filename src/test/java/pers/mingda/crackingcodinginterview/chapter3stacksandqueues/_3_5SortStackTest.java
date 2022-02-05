package pers.mingda.crackingcodinginterview.chapter3stacksandqueues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _3_5SortStackTest {

    private _3_5SortStack ss;

    @BeforeEach
    public void setup() {
        ss = new _3_5SortStack();
    }

    @Test
    public void test() {
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
}
