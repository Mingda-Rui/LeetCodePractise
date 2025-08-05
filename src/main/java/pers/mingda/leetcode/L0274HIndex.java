package pers.mingda.leetcode;

import java.util.Arrays;

public class L0274HIndex {}

class LC0274Solution {

  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int hIndex = 0;
    for (int i = citations.length - 1; i >= 0; i--) {
      int cite = citations[i];
      if (cite >= hIndex + 1) {
        hIndex++;
      } else {
        return hIndex;
      }
    }

    return hIndex;
  }
}

class LC0274CountingSolution {

  public int hIndex(int[] citations) {
    int len = citations.length;

    int[] record = new int[len + 1];
    for (int cite : citations) {
      int normalizedCite = Math.min(len, cite);
      record[normalizedCite]++;
    }

    int paperLeft = len;
    for (int numOfCite = 0; numOfCite < record.length; numOfCite++) {
      int numOfPaperWithCites = record[numOfCite];
      if (numOfPaperWithCites == 0) {
        continue;
      }

      if (numOfCite >= paperLeft) {
        return paperLeft;
      }
      paperLeft -= numOfPaperWithCites;
    }
    return 0;
  }
}
