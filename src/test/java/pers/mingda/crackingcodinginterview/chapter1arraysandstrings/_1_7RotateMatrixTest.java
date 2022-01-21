package pers.mingda.crackingcodinginterview.chapter1arraysandstrings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class _1_7RotateMatrixTest {
    
    @Test
    public void testRotate() {
        int[][] testMatrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        int[][] expectedMatrix = {{13,9,5,1}, {14,10,6,2}, {15,11,7,3}, {16,12,8,4}};

        _1_7RotateMatrix.rotate(testMatrix);
        
        for (int[] row: testMatrix) {
            System.out.println(Arrays.toString(row));
        }
        assertArrayEquals(expectedMatrix, testMatrix);

        int[][] testMatrix2 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] expectedMatrix2 = {{7,4,1}, {8,5,2}, {9,6,3}};

        _1_7RotateMatrix.rotate(testMatrix2);
        assertArrayEquals(expectedMatrix2, testMatrix2);

        int[][] testMatrix3 = {{1}};
        int[][] expectedMatrix3 = {{1}};

        _1_7RotateMatrix.rotate(testMatrix3);
        assertArrayEquals(expectedMatrix3, testMatrix3);
    }

    @Test
    public void testRotateByLayer() {
        int[][] testMatrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        int[][] expectedMatrix = {{13,9,5,1}, {14,10,6,2}, {15,11,7,3}, {16,12,8,4}};

        _1_7RotateMatrix.rotateByLayer(testMatrix);
        
        for (int[] row: testMatrix) {
            System.out.println(Arrays.toString(row));
        }
        assertArrayEquals(expectedMatrix, testMatrix);

        int[][] testMatrix2 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] expectedMatrix2 = {{7,4,1}, {8,5,2}, {9,6,3}};

        _1_7RotateMatrix.rotateByLayer(testMatrix2);
        assertArrayEquals(expectedMatrix2, testMatrix2);

        int[][] testMatrix3 = {{1}};
        int[][] expectedMatrix3 = {{1}};

        _1_7RotateMatrix.rotateByLayer(testMatrix3);
        assertArrayEquals(expectedMatrix3, testMatrix3);
    }
}
