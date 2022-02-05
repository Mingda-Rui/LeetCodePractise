package pers.mingda.crackingcodinginterview.chapter3stacksandqueues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _3_4QueueViaStacksTest {

    _3_4QueueViaStacks qvs;

    @BeforeEach
    public void setup() {
        qvs = new _3_4QueueViaStacks();
    }

    @Test
    public void test() {
        qvs.add(1);
        assertEquals(1, qvs.remove());

        qvs.add(2);
        qvs.add(3);
        assertEquals(2, qvs.remove());
        qvs.add(4);
        assertEquals(3, qvs.remove());
        assertEquals(4, qvs.remove());
    }
}
