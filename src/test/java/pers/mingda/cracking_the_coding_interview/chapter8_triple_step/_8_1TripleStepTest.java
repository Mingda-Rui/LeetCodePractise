package pers.mingda.cracking_the_coding_interview.chapter8_triple_step;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming._8_1TripleStep;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _8_1TripleStepTest {

    private _8_1TripleStep subject;

    @BeforeEach
    public void setup() {
        this.subject = new _8_1TripleStep();
    }

    @Test
    public void itCountsPossibleTripleSteps() {
        assertEquals(1, subject.countPossibleWays(1));
        assertEquals(2, subject.countPossibleWays(2));
        assertEquals(4, subject.countPossibleWays(3));
        assertEquals(7, subject.countPossibleWays(4));
        assertEquals(13, subject.countPossibleWays(5));
        assertEquals(24, subject.countPossibleWays(6));
        assertEquals(44, subject.countPossibleWays(7));
        assertEquals(81, subject.countPossibleWays(8));
        assertEquals(149, subject.countPossibleWays(9));
        assertEquals(274, subject.countPossibleWays(10));
    }
}
