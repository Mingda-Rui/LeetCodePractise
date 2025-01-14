package pers.mingda.cracking_the_coding_interview.chapter10_sorting_and_searching;

public class _10_1SortedMerge {
    /*
    10.1 Sorted Merge: You are given two sorted arrays,
    A and B, where A has a large enough buffer at the end
    to hold B. Write a method to merge B into A in sorted order.
     */

    public void merge(int[] A, int[] B) {
        int aActualLen = A.length - B.length;
        int indexA = aActualLen - 1;
        int indexB = B.length - 1;
        int backIndex = A.length - 1;
        while (indexA >= 0 || indexB >= 0) {
            int currentA = A[indexA];
            int currentB = B[indexB];
            if (currentA > currentB) {
                A[backIndex] = currentA;
                indexA--;
            } else {
                A[backIndex] = currentB;
                indexB--;
            }
            backIndex--;
        }
    }
}
