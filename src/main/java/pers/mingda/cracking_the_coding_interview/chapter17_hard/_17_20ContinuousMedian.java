package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.PriorityQueue;

public class _17_20ContinuousMedian {
    PriorityQueue<Integer> larger;
    int totalNum;

    void addNumber(int number) {
        larger.add(number);
        totalNum++;
        if (larger.size() * 2 - totalNum > 1) {
            larger.poll();
        }
    }

    int getMedian() {
        if (!larger.isEmpty()) {
            return larger.peek();
        }
        return -1;
    }
}
