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
    // Note that you don't need to copy the contents
    // of A after running out of elements in B.
    // They are already in place.
    while (indexB >= 0) {
      if (indexA >= 0 && A[indexA] > B[indexB]) {
        A[backIndex] = A[indexA];
        indexA--;
      } else {
        A[backIndex] = B[indexB];
        indexB--;
      }
      backIndex--;
    }
  }
}
