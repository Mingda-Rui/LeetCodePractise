package pers.mingda.cracking_the_coding_interview.chapter2_linked_lists;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _2_6PalindromeTest {

    private LinkedListTestHelper testHelper;

    @BeforeEach
    public void setup() {
        testHelper = new LinkedListTestHelper();
    }

    @Test
    public void testIsPalindrome() {
        LinkedListNode testList = testHelper.buildNodeList(List.of(1, 2, 3));
        assertFalse(_2_6Palindrome.isPalindrome(testList));

        testList = testHelper.buildNodeList(List.of(1));
        assertTrue(_2_6Palindrome.isPalindrome(testList));

        testList = testHelper.buildNodeList(List.of(1, 2, 3, 2, 1));
        assertTrue(_2_6Palindrome.isPalindrome(testList));

        testList = testHelper.buildNodeList(List.of(1, 2, 3, 3, 2, 1));
        assertTrue(_2_6Palindrome.isPalindrome(testList));
    }

    @Test
    public void testIsPalindromeRecursion() {
        LinkedListNode testList = testHelper.buildNodeList(List.of(1, 2, 3));
        assertFalse(_2_6Palindrome.isPalindromeRecursion(testList));

        testList = testHelper.buildNodeList(List.of(1));
        assertTrue(_2_6Palindrome.isPalindromeRecursion(testList));

        testList = testHelper.buildNodeList(List.of(1, 2, 3, 2, 1));
        assertTrue(_2_6Palindrome.isPalindromeRecursion(testList));

        testList = testHelper.buildNodeList(List.of(1, 2, 3, 3, 2, 1));
        assertTrue(_2_6Palindrome.isPalindromeRecursion(testList));
    }

    @Test
    public void testIsPalindromeRecursionVw() {
        LinkedListNode testList = testHelper.buildNodeList(List.of(1, 2, 3));
        assertFalse(_2_6Palindrome.isPalindromeRecursionV2(testList));

        testList = testHelper.buildNodeList(List.of(1));
        assertTrue(_2_6Palindrome.isPalindromeRecursionV2(testList));

        testList = testHelper.buildNodeList(List.of(1, 2, 3, 2, 1));
        assertTrue(_2_6Palindrome.isPalindromeRecursionV2(testList));

        testList = testHelper.buildNodeList(List.of(1, 2, 3, 3, 2, 1));
        assertTrue(_2_6Palindrome.isPalindromeRecursionV2(testList));
    }

    @Test
    public void testIsPalindromeTwoPointer() {
        LinkedListNode testList = testHelper.buildNodeList(List.of(1, 2, 3));
        assertFalse(_2_6Palindrome.isPalindromeTwoPointer(testList));

        testList = testHelper.buildNodeList(List.of(1));
        assertTrue(_2_6Palindrome.isPalindromeTwoPointer(testList));

        testList = testHelper.buildNodeList(List.of(1, 2, 3, 2, 1));
        assertTrue(_2_6Palindrome.isPalindromeTwoPointer(testList));

        testList = testHelper.buildNodeList(List.of(1, 2, 3, 3, 2, 1));
        assertTrue(_2_6Palindrome.isPalindromeTwoPointer(testList));
    }
}
