package pers.mingda.cracking_the_coding_interview.chapter10_sorting_and_searching;

public class _10_10RankFromStream {

  RankNode root;

  public void track(int x) {
    root.add(x);
  }

  public int getRankOfNumber(int x) {
    return root.getRankOfNumber(x);
  }
}

class RankNode {
  int count;
  int value;
  RankNode left, right;

  public RankNode(int value) {
    this.value = value;
    this.count = 1;
  }

  private int getLeftCount() {
    return left == null ? 0 : left.count;
  }

  private int getLeftRankNumber(int x) {
    return left == null ? 0 : left.getLeftRankNumber(x);
  }

  private int getRightRankNumber(int x) {
    return right == null ? 0 : right.getRightRankNumber(x);
  }

  public void add(int x) {
    if (x > value) {
      if (right == null) {
        right = new RankNode(x);
      } else {
        right.add(x);
      }
    } else {
      if (left == null) {
        left = new RankNode(x);
      } else {
        left.add(x);
      }
    }
    count++;
  }

  public int getRankOfNumber(int x) {
    if (x < value) {
      return getLeftRankNumber(x);
    } else if (x > value) {
      return getRightRankNumber(x) + getLeftCount() + 1;
    } else { // x == value
      return getLeftCount();
    }
  }
}
