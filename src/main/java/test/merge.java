package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class merge {

  private List<Integer> mergeArrays(int[] nums1, int m, int[] nums2, int n) {
    List<Integer> list = new ArrayList<>();
    int i = 0, j = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        list.add(nums1[i++]);
      } else {
        list.add(nums2[j++]);
      }
    }
    while (i < nums1.length) {
      list.add(nums1[i++]);
    }
    while (j < nums2.length) {
      list.add(nums2[j++]);
    }
    return list;
  }

  private void print(List<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i));
      if (i != list.size() - 1) {
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(2);
    final Scanner sc = new Scanner(System.in);
    final int a = sc.nextInt();
    final int[] ta = new int[a];
    final int b = sc.nextInt();
    final int[] tb = new int[b];
    for (int ai = 0; ai < a; ++ai) {
      ta[ai] = sc.nextInt();
    }
    for (int bi = 0; bi < b; ++bi) {
      tb[bi] = sc.nextInt();
    }
    merge obj = new merge();
    List<Integer> res = obj.mergeArrays(ta, ta.length, tb, tb.length);
    obj.print(res);
    sc.close();
  }
}
