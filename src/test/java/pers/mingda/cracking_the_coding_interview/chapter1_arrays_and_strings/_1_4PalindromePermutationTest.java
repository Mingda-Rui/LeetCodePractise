package pers.mingda.cracking_the_coding_interview.chapter1_arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class _1_4PalindromePermutationTest {
    
    @Test
    public void testPalindromePermutationCaseSensitive() {
        String testStr = "tact coa";
        assertTrue(_1_4PalindromePermutation.palindromePermutationCaseSensitive(testStr));

        testStr = "Tact Coa";
        assertFalse(_1_4PalindromePermutation.palindromePermutationCaseSensitive(testStr));

        testStr = "tact coac";
        assertFalse(_1_4PalindromePermutation.palindromePermutationCaseSensitive(testStr));
    }

    @Test
    public void testPalindromePermutationCaseInsensitive() {
        String testStr = "tact coa";
        assertTrue(_1_4PalindromePermutation.palindromePermutationCaseInsensitive(testStr));

        testStr = "Tact Coa";
        assertTrue(_1_4PalindromePermutation.palindromePermutationCaseInsensitive(testStr));

        testStr = "tact coac";
        assertFalse(_1_4PalindromePermutation.palindromePermutationCaseInsensitive(testStr));
    }
}
