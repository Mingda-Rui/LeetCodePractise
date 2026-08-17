package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LC4017PeaksInArrayII {}

class LC4017Solution {
  public long[] countOfPeaks(int[] nums, int[][] queries) {
    // l p1 p2 p3 r
    // [p1 - l] * [r - p1]
    // + [p2 - p1] * [r - p2]
    // + [p3 - p2] * [r - p3]

    // r * (p1 - l) - p1 * (p1 - l) + r * (p2 - p1) - p2 * (p2 - p1) + r * (p3 - p2) - p3 * (p3 -
    // p2)
    // r * (p1 - l) + r * (p2 - p1) + r * (p3 - p2) - [p1 * (p1 - l) + p2 * (p2 - p1) + p3 * (p3 -
    // p2)]
    // r * (p3 - l) - [p1 * (p1 - l) + p2 * (p2 - p1) + p3 * (p3 - p2)]

    LC4017SegmentTree st = new LC4017SegmentTree(nums);
    st.init();

    List<Long> result = new LinkedList<>();
    for (int[] query : queries) {
      if (query[0] == 1) {
        long count = st.query(query[1], query[2]);
        result.add(count);
      } else {
        st.update(query[1], query[2]);
      }
    }
    return result.stream().mapToLong(Long::longValue).toArray();
  }
}

class LC4017SegmentTree {
  int[] nums;
  LC4017SegTreeNode root;

  public LC4017SegmentTree(int[] nums) {
    this.nums = nums;
  }

  public void init() {
    this.root = init(0, nums.length - 1);
  }

  public LC4017SegTreeNode init(int start, int end) {
    if (start == end) {
      LC4017SegTreeNode leaf = new LC4017SegTreeNode();
      leaf.leftRange = start;
      leaf.rightRange = end;
      boolean isPeak = isPeak(start);
      leaf.leftPeak = isPeak ? start : -1;
      leaf.rightPeak = isPeak ? end : -1;
      return leaf;
    }

    LC4017SegTreeNode node = new LC4017SegTreeNode();
    // 0 1 2 3
    // mid = 1

    // 0 1 2 3 4
    // mid = 2
    int mid = (start + end) / 2;
    LC4017SegTreeNode leftChild = init(start, mid);
    LC4017SegTreeNode rightChild = init(mid + 1, end);
    node.left = leftChild;
    node.right = rightChild;
    node.leftRange = start;
    node.rightRange = end;
    merge(node);
    return node;
  }

  public void update(int index, int val) {
    nums[index] = val;
    update(root, index);
    update(root, index - 1);
    update(root, index + 1);
  }

  private void update(LC4017SegTreeNode node, int index) {
    if (index < node.leftRange || index > node.rightRange) {
      return;
    } else if (node.isLeaf()) {
      node.leftPeak = isPeak(index) ? index : -1;
      node.rightPeak = isPeak(index) ? index : -1;
      return;
    }

    LC4017SegTreeNode leftChild = node.left;
    LC4017SegTreeNode rightChild = node.right;

    update(leftChild, index);
    update(rightChild, index);
    merge(node);
  }

  private void merge(LC4017SegTreeNode node) {
    LC4017SegTreeNode leftChild = node.left;
    LC4017SegTreeNode rightChild = node.right;

    node.leftPeak = leftChild.leftPeak == -1 ? rightChild.leftPeak : leftChild.leftPeak;
    node.rightPeak = rightChild.rightPeak == -1 ? leftChild.rightPeak : rightChild.rightPeak;

    node.weight = leftChild.weight + rightChild.weight;
    if (leftChild.rightPeak != -1 && rightChild.leftPeak != -1) {
      node.weight += ((long) rightChild.leftPeak * (rightChild.leftPeak - leftChild.rightPeak));
    }
  }

  public long query(int l, int r) {
    int rightPeak = getRightPeak(root, l + 1, r - 1);

    if (rightPeak < 0) {
      return 0;
    }
    int leftPeak = getLeftPeak(root, l + 1, r - 1);

    long weight = adjustQuery(root, l + 1, r - 1);

    return (long) r * (rightPeak - l) - (long) leftPeak * (leftPeak - l) - weight;
  }

  private long adjustQuery(LC4017SegTreeNode node, int l, int r) {
    if (node.leftRange > r || node.rightRange < l || node.isLeaf()) {
      return 0;
    }

    if (node.leftRange >= l && node.rightRange <= r) {
      return node.weight;
    }

    long leftQuery = adjustQuery(node.left, l, r);
    long rightQuery = adjustQuery(node.right, l, r);
    long result = leftQuery + rightQuery;

    LC4017SegTreeNode leftChild = node.left;
    LC4017SegTreeNode rightChild = node.right;

    if (leftChild.rightPeak >= l && rightChild.leftPeak >= 0 && rightChild.leftPeak <= r) {
      result += ((long) rightChild.leftPeak * (rightChild.leftPeak - leftChild.rightPeak));
    }

    return result;
  }

  private int getLeftPeak(LC4017SegTreeNode node, int l, int r) {
    if (node.leftRange > r || node.rightRange < l) {
      return -1;
    } else if (node.isLeaf() || node.leftRange >= l && node.rightRange <= r) {
      return node.leftPeak;
    }
    int leftPeak = getLeftPeak(node.left, l, r);
    return leftPeak == -1 ? getLeftPeak(node.right, l, r) : leftPeak;
  }

  private int getRightPeak(LC4017SegTreeNode node, int l, int r) {
    if (node.leftRange > r || node.rightRange < l) {
      return -1;
    } else if (node.isLeaf() || node.leftRange >= l && node.rightRange <= r) {
      return node.rightPeak;
    }
    int rightPeak = getRightPeak(node.right, l, r);
    return rightPeak == -1 ? getRightPeak(node.left, l, r) : rightPeak;
  }

  private boolean isPeak(int index) {
    if (index <= 0 || index >= nums.length - 1) {
      return false;
    }
    return nums[index - 1] < nums[index] && nums[index + 1] < nums[index];
  }
}

class LC4017SegTreeNode {
  int leftPeak;
  int rightPeak;
  int leftRange;
  int rightRange;
  LC4017SegTreeNode left;
  LC4017SegTreeNode right;

  long weight;

  public LC4017SegTreeNode() {
    this.leftPeak = -1;
    this.rightPeak = -1;
    this.weight = 0;
  }

  public boolean isLeaf() {
    return leftRange == rightRange;
  }
}
