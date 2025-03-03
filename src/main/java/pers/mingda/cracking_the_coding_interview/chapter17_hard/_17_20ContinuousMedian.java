package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _17_20ContinuousMedian {
    PriorityQueue<Integer> larger = new PriorityQueue<>();
    PriorityQueue<Integer> smaller = new PriorityQueue<>(Comparator.reverseOrder());

    void addNumber(int number) {
        larger.add(number);
        if (larger.size() - smaller.size() > 1) {
            int num = larger.poll();
            smaller.add(num);
        }
    }

    int getMedian() {
        if (larger.size() == smaller.size()) {
            return (larger.peek() + smaller.peek()) / 2;
        }
        return larger.peek();
    }
}
