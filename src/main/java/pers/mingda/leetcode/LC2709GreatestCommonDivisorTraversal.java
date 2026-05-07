package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC2709GreatestCommonDivisorTraversal {
}

class LC2709Solution {
  public boolean canTraverseAllPairs(int[] nums) {
    if (nums.length == 1) {
      return true;
    }
    int maxVal = 0;

    for (int num : nums) {
      maxVal = Math.max(maxVal, num);
    }

    int[] smallestPrimes = new int[maxVal + 1];
    for (int i = 2; i <= maxVal; i++) {
      if (smallestPrimes[i] != 0) {
        continue;
      }

      for (int j = 0; j <= maxVal; j += i) {
        smallestPrimes[j] = i;
      }
    }

    int combinedSize = maxVal + 1 + nums.length;
    UnionFind uf = new UnionFind(combinedSize);
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      List<Integer> primes = getPrimes(num, smallestPrimes);
      for (int p : primes) {
        uf.union(maxVal + 1 + i, p, num, p);
      }
    }
    return areSameGroup(uf, combinedSize, nums.length);
  }

  private List<Integer> getPrimes(int num, int[] smallestPrimes) {
    List<Integer> primes = new ArrayList<>();
    while (num > 1) {
      int prime = smallestPrimes[num];
      primes.add(prime);
      while (num % prime == 0) {
        num /= prime;
      }
    }
    return primes;
  }

  private boolean areSameGroup(UnionFind uf, int combinedSize, int numLen) {
    for (int i = combinedSize - numLen + 1; i < combinedSize; i++) {
      if (uf.find(i) != uf.find(i - 1)) {
        return false;
      }
    }
    return true;
  }
}

class UnionFind {

  final private int[] parents;
  final private int[] sizes;

  public UnionFind(int size) {
    this.parents = new int[size];
    this.sizes = new int[size];

    for (int i = 0; i < size; i++) {
      this.parents[i] = i;
      this.sizes[i] = 1;
    }
  }

  public void union(int a, int p, int vA, int vP) {
    int parent1 = find(a);
    int parent2 = find(p);
    if (parent1 == parent2) {
      return;
    }

    if (!checkGcd(vA, vP)) {
      return;
    }

    int greaterGroup = sizes[parent1] > sizes[parent2] ? parent1 : parent2;
    int smallerGroup = sizes[parent1] > sizes[parent2] ? parent2 : parent1;

    parents[smallerGroup] = greaterGroup;
    sizes[greaterGroup] += sizes[smallerGroup];
  }

  public int find(int num) {
    if (parents[num] != num) {
      int currentP = parents[num];
      parents[num] = find(currentP);
    }
    return parents[num];
  }

  private boolean checkGcd(int v1, int v2) {
    return v1 % v2 == 0;
  }
}