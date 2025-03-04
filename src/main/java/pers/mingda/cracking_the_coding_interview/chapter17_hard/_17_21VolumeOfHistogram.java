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
            int lH = leftHighestIndex[i];
            int rH = rightHighestIndex[i];
            int currentHeight = histogram[i];
            if (histogram[lH] > currentHeight && histogram[rH] > currentHeight) {
                continue;
            }
            max += calculateHistogramVolume(histogram, lH, i);

        }
        return max;
    }

    int calculateHistogramVolume(int[] histogram, int a, int b) {
        int height = Math.min(histogram[a], histogram[b]);
        int width = Math.abs(a - b - 1);
        int offset = 0;
        for (int i = a + 1; i < b; i++) {
            offset -= histogram[i];
        }
        return height * width - offset;
    }
}
