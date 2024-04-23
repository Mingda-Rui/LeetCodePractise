package pers.mingda.cracking_the_coding_interview.chapter1_arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class _1_8ZeroMatrixTest {

    @Test
    public void testSetZeros() {
        int[][] testMatrix = new int[][] {{0,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}};
        int[][] expectedMatrix = new int[][] {{0,0,0,0}, {0,1,1,1}, {0,1,1,1}, {0,1,1,1}};
        _1_8ZeroMatrix.setZeros(testMatrix);
        assertArrayEquals(expectedMatrix, testMatrix);

        testMatrix = new int[][] {{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,0}};
        expectedMatrix = new int[][] {{1,1,1,0}, {1,1,1,0}, {1,1,1,0},{0,0,0,0}};
        _1_8ZeroMatrix.setZeros(testMatrix);
        assertArrayEquals(expectedMatrix, testMatrix);


        testMatrix = new int[][] {{1,1,1,1}, {1,0,1,1}, {1,1,0,1}, {1,1,1,1}};
        expectedMatrix = new int[][] {{1,0,0,1}, {0,0,0,0}, {0,0,0,0},{1,0,0,1}};
        _1_8ZeroMatrix.setZeros(testMatrix);
        assertArrayEquals(expectedMatrix, testMatrix);

        testMatrix = new int[][] {{1,1,1,0}, {1,1,0,1}, {1,0,1,1}, {0,1,1,1}};
        expectedMatrix = new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        _1_8ZeroMatrix.setZeros(testMatrix);
        assertArrayEquals(expectedMatrix, testMatrix);

        testMatrix = new int[][] {{1,2,3,4}, {4,3,2,1}, {1,1,1,1}, {1,1,1,1}};
        expectedMatrix = new int[][] {{1,2,3,4}, {4,3,2,1}, {1,1,1,1}, {1,1,1,1}};
        _1_8ZeroMatrix.setZeros(testMatrix);
        assertArrayEquals(expectedMatrix, testMatrix);
    }
    
    @Test
    public void testSetZerosNoExtraSpace() {
        int[][] testMatrix = new int[][] {{0,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}};
        int[][] expectedMatrix = new int[][] {{0,0,0,0}, {0,1,1,1}, {0,1,1,1}, {0,1,1,1}};
        _1_8ZeroMatrix.setZerosNoExtraSpace(testMatrix);
        assertArrayEquals(expectedMatrix, testMatrix);

        testMatrix = new int[][] {{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,0}};
        expectedMatrix = new int[][] {{1,1,1,0}, {1,1,1,0}, {1,1,1,0},{0,0,0,0}};
        _1_8ZeroMatrix.setZerosNoExtraSpace(testMatrix);
        assertArrayEquals(expectedMatrix, testMatrix);


        testMatrix = new int[][] {{1,1,1,1}, {1,0,1,1}, {1,1,0,1}, {1,1,1,1}};
        expectedMatrix = new int[][] {{1,0,0,1}, {0,0,0,0}, {0,0,0,0},{1,0,0,1}};
        _1_8ZeroMatrix.setZerosNoExtraSpace(testMatrix);
        assertArrayEquals(expectedMatrix, testMatrix);

        testMatrix = new int[][] {{1,1,1,0}, {1,1,0,1}, {1,0,1,1}, {0,1,1,1}};
        expectedMatrix = new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        _1_8ZeroMatrix.setZerosNoExtraSpace(testMatrix);
        assertArrayEquals(expectedMatrix, testMatrix);

        testMatrix = new int[][] {{1,2,3,4}, {4,3,2,1}, {1,1,1,1}, {1,1,1,1}};
        expectedMatrix = new int[][] {{1,2,3,4}, {4,3,2,1}, {1,1,1,1}, {1,1,1,1}};
        _1_8ZeroMatrix.setZerosNoExtraSpace(testMatrix);
        assertArrayEquals(expectedMatrix, testMatrix);
    }
}
