package pers.mingda.cracking_the_coding_interview.chapter8_triple_step;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming._8_3MagicIndex;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _8_3MagicIndexTest {

    _8_3MagicIndex subject;

    @BeforeEach
    public void setUp() {
        this.subject = new _8_3MagicIndex();
    }

    @Test
    public void itFindsMagicIndex() {
        // Case with a Magic Index
        int[] array1 = new int[]{-3, -1, 1, 3, 5, 7};
        assertEquals(3, subject.findMagicIndex(array1));

        // Case with No Magic Index:
        int[] array2 = new int[]{-5, -2, 0, 2, 4, 7};
        assertEquals(4, subject.findMagicIndex(array2));

        // Case with Multiple Elements, Magic Index at Start
        int[] array3 = new int[]{0, 2, 5, 10, 12};
        assertEquals(0, subject.findMagicIndex(array3));

        // Case with a Large Array and Magic Index in Middle
        int[] array4 = new int[]{-10, -5, -2, 3, 7, 12, 17};
        assertEquals(3, subject.findMagicIndex(array4));

        // Edge Case with Only One Element (Matching)
        int[] array5 = new int[]{0};
        assertEquals(0, subject.findMagicIndex(array5));

        // Edge Case with Only One Element (Not Matching)
        int[] array6 = new int[]{2};
        assertEquals(-1, subject.findMagicIndex(array6));

        // Case with All Positive Integers
        int[] array7 = new int[]{1, 2, 3, 4, 5, 6};
        assertEquals(-1, subject.findMagicIndex(array7));

        // Case with Negative Numbers
        int[] array8 = new int[]{-5, -3, -2, -1, 0, 1, 3};
        assertEquals(-1, subject.findMagicIndex(array8));
    }
}
