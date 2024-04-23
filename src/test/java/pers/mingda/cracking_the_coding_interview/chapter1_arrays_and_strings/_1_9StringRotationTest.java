package pers.mingda.cracking_the_coding_interview.chapter1_arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class _1_9StringRotationTest {
    
    @Test
    public void stringRotationTest() {
        String str1 = "abcd";
        String str2 = "cdab";
        assertTrue(_1_9StringRotation.stringRotation(str1, str2));

        str1 = "abcd";
        str2 = "cda";
        assertFalse(_1_9StringRotation.stringRotation(str1, str2));

        str1 = "abcd";
        str2 = "cdaa";
        assertFalse(_1_9StringRotation.stringRotation(str1, str2));
    }
}
