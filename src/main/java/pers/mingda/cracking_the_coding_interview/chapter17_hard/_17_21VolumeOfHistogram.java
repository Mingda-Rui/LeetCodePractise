package pers.mingda.cracking_the_coding_interview.chapter17_hard;

public class _17_21VolumeOfHistogram {

  int computeHistogramVolume(int[] histogram) {
    int[] leftHighestIndex = new int[histogram.length];
    int[] rightHighestIndex = new int[histogram.length];
    int lHighestIndex = 0;
    for (int i = 0; i < histogram.length; i++) {
      leftHighestIndex[i] = lHighestIndex;
      if (histogram[i] >= histogram[lHighestIndex]) {
        lHighestIndex = i;
      }
    }

    int rHighestIndex = 0;
    for (int i = histogram.length - 1; i >= 0; i--) {
      rightHighestIndex[i] = rHighestIndex;
      if (histogram[i] >= histogram[rHighestIndex]) {
        rHighestIndex = i;
      }
    }

    int max = 0;
    for (int i = 0; i < leftHighestIndex.length; i++) {
      int height = Math.min(leftHighestIndex[i], rightHighestIndex[i]);
      int currentHeight = histogram[i];
      max += Math.max(0, height - currentHeight);
    }
    return max;
  }
}
