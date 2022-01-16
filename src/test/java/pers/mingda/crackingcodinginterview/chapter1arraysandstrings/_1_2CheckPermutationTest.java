package pers.mingda.crackingcodinginterview.chapter1arraysandstrings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class _1_2CheckPermutationTest {

    @Test
    public void testCheckPermutation() {
        String str1 = "aabbbbcce";
        String str2 = "abcabcbeb";
        assertTrue(_1_2CheckPermutation.checkPermutation(str1, str2));

        str1 = "aaabe";
        str2 = "aabbe";
        assertFalse(_1_2CheckPermutation.checkPermutation(str1, str2));

        // check permuration with tailing white space
        str1 = "a ab";
        str2 = "aba ";
        assertTrue(_1_2CheckPermutation.checkPermutation(str1, str1));

        // check permutation with different number of white space
        str1 = "aab  ";
        str2 = "a ab";
        assertFalse(_1_2CheckPermutation.checkPermutation(str1, str2));
    }

    @Test
    public void testCHeckPermutationSorting() {
        String str1 = "aabbbbcce";
        String str2 = "abcabcbeb";
        assertTrue(_1_2CheckPermutation.checkPermutationSorting(str1, str2));

        str1 = "aaabe";
        str2 = "aabbe";
        assertFalse(_1_2CheckPermutation.checkPermutationSorting(str1, str2));

        // check permuration with tailing white space
        str1 = "a ab";
        str2 = "aba ";
        assertTrue(_1_2CheckPermutation.checkPermutationSorting(str1, str1));

        // check permutation with different number of white space
        str1 = "aab  ";
        str2 = "a ab";
        assertFalse(_1_2CheckPermutation.checkPermutationSorting(str1, str2));
    }
    
}
