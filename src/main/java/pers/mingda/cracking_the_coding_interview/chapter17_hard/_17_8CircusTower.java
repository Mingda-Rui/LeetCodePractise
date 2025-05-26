package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _17_8CircusTower {

  List<CircusTowerPerson> longestIncreasingSeq(List<CircusTowerPerson> people) {
    Collections.sort(people);
    return getLongestSeq(people, new ArrayList<>(), 0);
  }

  List<CircusTowerPerson> getLongestSeq(
    List<CircusTowerPerson> people,
    List<CircusTowerPerson> currentSeq,
    int index
  ) {
    if (index == people.size()) {
      return currentSeq;
    }
    CircusTowerPerson next = people.get(index);
    List<CircusTowerPerson> bestWithout = getLongestSeq(
      people,
      currentSeq,
      index + 1
    );
    if (!canFit(next, bestWithout)) {
      return bestWithout;
    }

    List<CircusTowerPerson> seqWithNext = new ArrayList<>(bestWithout);
    seqWithNext.add(next);
    List<CircusTowerPerson> bestWith = getLongestSeq(
      people,
      seqWithNext,
      index + 1
    );
    return bestWith.size() > bestWithout.size() ? bestWithout : bestWith;
  }

  boolean canFit(CircusTowerPerson bottom, List<CircusTowerPerson> seq) {
    CircusTowerPerson currentBottom = seq.getLast();
    return (
      bottom.height > currentBottom.height &&
      bottom.weight > currentBottom.weight
    );
  }
}

class CircusTowerPerson implements Comparable<CircusTowerPerson> {

  int height;
  int weight;

  @Override
  public int compareTo(CircusTowerPerson other) {
    int heightDiff = this.height - other.height;
    return heightDiff == 0 ? this.weight - other.weight : heightDiff;
  }
}
