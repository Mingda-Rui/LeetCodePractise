package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC4013CountSubarraysWithEvenOddRatioII {}

class LC4013Solution {
  public long countRatioSubarrays(int[] nums, int a, int b) {
    // xEven / yOdd <= a / b
    // xEven * b <= yOdd * a
    // yOdd * a - xEven * b >= 0
    // prefixSum[j] - prefixSum[i] >= 0

    long[] prefixSum = new long[nums.length];
    for (int i = 0; i < nums.length; i++) {
      long delta = (nums[i] % 2 == 0 ? -b : a);
      long sum = (i == 0 ? 0 : prefixSum[i - 1]) + delta;
      prefixSum[i] = sum;
    }
    return mergeSortAndCount(prefixSum, 0, prefixSum.length);
  }

  private long mergeSortAndCount(long[] prefixSum, int start, int end) {
    if (start + 1 >= end) {
      return prefixSum[start] >= 0 ? 1 : 0;
    }

    int mid = start + (end - start) / 2;

    long count = mergeSortAndCount(prefixSum, start, mid) + mergeSortAndCount(prefixSum, mid, end);

    count += countValidSubarray(prefixSum, start, mid, end);

    inPlaceMerge(prefixSum, start, mid, end);

    return count;
  }

  private long countValidSubarray(long[] prefixSum, int start, int split, int end) {
    long count = 0;
    int i = start;
    for (int j = split; j < end; j++) {
      while (i < split && prefixSum[i] <= prefixSum[j]) {
        i++;
      }
      count += (i - start);
    }
    return count;
  }

  private void inPlaceMerge(long[] arr, int first, int second, int end) {
    int start = first;
    int mid = second;
    long[] temp = new long[end - start];

    int index = 0;
    while (first < mid || second < end) {
      boolean isBothNonExhausted = first < mid && second < end;
      if ((isBothNonExhausted && arr[first] < arr[second]) || (first < mid && second == end)) {
        temp[index] = arr[first];
        first++;
      } else {
        temp[index] = arr[second];
        second++;
      }
      index++;
    }
    System.arraycopy(temp, 0, arr, start, temp.length);
  }
}

class LC4013FenwickTreeSolution {
  public long countRatioSubarrays(int[] nums, int a, int b) {
    long[] prefixSum = getPrefixSum(nums, a, b);
    Map<Long, Integer> coordCompMap = coordinateComp(prefixSum);

    LC4013FenwickTree ft = new LC4013FenwickTree(coordCompMap.size() + 1);
    long result = 0;
    for (long p : prefixSum) {
      int coordinateCompIndex = coordCompMap.get(p);

      result += ft.querySum(coordinateCompIndex);
      if (p >= 0) {
        result++;
      }
      ft.increase(coordinateCompIndex);
    }
    return result;
  }

  private long[] getPrefixSum(int[] nums, int a, int b) {
    long[] prefixSum = new long[nums.length];
    // x / y <= a / b
    // x * b <= y * a
    // y * a - x * b >= 0
    // x -> even number
    // y -> odd number

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      prefixSum[i] = (i == 0 ? 0 : prefixSum[i - 1]) + (num % 2 == 0 ? -b : a);
    }

    return prefixSum;
  }

  private Map<Long, Integer> coordinateComp(long[] prefixSum) {
    Map<Long, Integer> coordinateComp = new HashMap<>();
    long[] copied = Arrays.copyOf(prefixSum, prefixSum.length);
    Arrays.sort(copied);
    int index = 1;
    for (long p : copied) {
      if (!coordinateComp.containsKey(p)) {
        coordinateComp.put(p, index);
        index++;
      }
    }
    return coordinateComp;
  }
}

class LC4013FenwickTree {
  long[] tree;
  int size;

  public LC4013FenwickTree(int size) {
    this.size = size;
    this.tree = new long[size];
  }

  public void increase(int index) {
    while (index < size) {
      tree[index]++;
      index += (index & -index);
    }
  }

  public long querySum(int index) {
    long sum = 0;
    while (index > 0) {
      sum += tree[index];
      index -= (index & -index);
    }
    return sum;
  }
}

class LC4013SegmentTreeSolution {
  public long countRatioSubarrays(int[] nums, int a, int b) {
    long[] prefixSum = getPrefixSum(nums, a, b);
    Map<Long, Integer> coordCompMap = coordinateComp(prefixSum);

    LC4013SegmentTree st = new LC4013SegmentTree(coordCompMap.size());
    long result = 0;
    for (long p : prefixSum) {
      int coordinateCompIndex = coordCompMap.get(p);

      if (p >= 0) {
        result++;
      }

      result += st.query(0, coordinateCompIndex + 1);
      st.increase(coordinateCompIndex);
    }
    return result;
  }

  private long[] getPrefixSum(int[] nums, int a, int b) {
    long[] prefixSum = new long[nums.length];
    // x / y <= a / b
    // x * b <= y * a
    // y * a - x * b >= 0
    // x -> even number
    // y -> odd number

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      prefixSum[i] = (i == 0 ? 0 : prefixSum[i - 1]) + (num % 2 == 0 ? -b : a);
    }

    return prefixSum;
  }

  private Map<Long, Integer> coordinateComp(long[] prefixSum) {
    Map<Long, Integer> coordinateComp = new HashMap<>();
    long[] copied = Arrays.copyOf(prefixSum, prefixSum.length);
    Arrays.sort(copied);
    int index = 0;
    for (long p : copied) {
      if (!coordinateComp.containsKey(p)) {
        coordinateComp.put(p, index);
        index++;
      }
    }
    return coordinateComp;
  }
}

class LC4013SegmentTree {
  int size;
  LC4013SegTreeNode root;

  public LC4013SegmentTree(int size) {
    this.size = size;
    this.root = init(0, size);
  }

  private LC4013SegTreeNode init(int start, int end) {
    LC4013SegTreeNode node = new LC4013SegTreeNode(0, start, end);
    if (start + 1 < end) {
      int mid = (start + end) / 2;
      node.left = init(start, mid);
      node.right = init(mid, end);
    }
    return node;
  }

  public void increase(int index) {
    increase(root, index);
  }

  public void increase(LC4013SegTreeNode root, int index) {
    if (root.start == index && root.end == index + 1) {
      root.val++;
    } else if (root.start <= index && root.end > index) {
      increase(root.left, index);
      increase(root.right, index);
      root.val = root.left.val + root.right.val;
    }
  }

  public long query(int start, int end) {
    return query(root, start, end);
  }

  private long query(LC4013SegTreeNode root, int start, int end) {
    if (root.end <= start || root.start >= end) {
      return 0;
    } else if (root.start >= start && root.end <= end) {
      return root.val;
    }
    return query(root.left, start, end) + query(root.right, start, end);
  }
}

class LC4013SegTreeNode {
  int start;
  int end;
  long val;
  LC4013SegTreeNode left;
  LC4013SegTreeNode right;

  public LC4013SegTreeNode(long val, int start, int end) {
    this.val = val;
    this.start = start;
    this.end = end;
  }
}
