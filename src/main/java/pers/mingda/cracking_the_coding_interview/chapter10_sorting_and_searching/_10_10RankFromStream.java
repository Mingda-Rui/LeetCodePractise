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
        this.count = 0;
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
            if (left == null) {
                return 0;
            } else {
                return left.getRankOfNumber(x);
            }
        } else if (x > value) {
            if (right == null) {
                return count;
            } else {
                return right.getRankOfNumber(x) + count - right.count;
            }
        } else { // x == value
            if (left == null) {
                return 0;
            } else {
                return left.count;
            }
        }
    }
}
