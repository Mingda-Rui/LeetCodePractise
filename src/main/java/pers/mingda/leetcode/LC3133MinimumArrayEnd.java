package pers.mingda.leetcode;

public class LC3133MinimumArrayEnd {
}

class LC3133Solution {
  public long minEnd(int n, int x) {
    long result = x;

    while (n - 1 > 0) {
      result = (result + 1) | x;
      n--;
    }

    return result;
  }
}

class LC3133BitManipulationSolution {
  public long minEnd(int n, int x) {
    long result = x;
    int pos = 0;
    n--;

    while (n != 0) {
      int xBit = x & 1;
      x >>= 1;
      pos++;

      if (xBit == 1) {
        continue;
      }

      int nBit = n & 1;
      n >>= 1;
      if (nBit == 0) {
        continue;
      }

      result |= (1L << (pos - 1));
    }
    return result;
  }
}