package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _17_20ContinuousMedian {
    PriorityQueue<Integer> larger = new PriorityQueue<>();
    PriorityQueue<Integer> smaller = new PriorityQueue<>(Comparator.reverseOrder());

    void addNumber(int number) {
        if (larger.isEmpty() || larger.peek() <= number) {
            larger.add(number);
            if (larger.size() - smaller.size() > 1) {
                smaller.add(larger.poll());
            }
        } else {
            if (larger.size() == smaller.size()) {
                smaller.add(number);
                larger.add(smaller.poll());
            } else {
                smaller.add(number);
            }
        }
    }

    int getMedian() {
        if (larger.isEmpty()) {
            return -1;
        }
        if (larger.size() == smaller.size()) {
            return (larger.peek() + smaller.peek()) / 2;
        }
        return larger.peek();
    }
}
