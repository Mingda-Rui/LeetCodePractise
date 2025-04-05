package pers.mingda.leetcode;

public class LC1899MergeTripletsToFormTargetTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] result = new boolean[3];
        for (int[] triplet: triplets) {
            boolean[] localResult = new boolean[3];
            boolean isValid = true;
            for (int i = 0; i < triplet.length; i++) {
                if (triplet[i] > target[i]) {
                    isValid = false;
                } else if (triplet[i] == target[i]) {
                    localResult[i] = true;
                }
            }
            if (isValid) {
                for (int i = 0; i < result.length; i++) {
                    result[i] |= localResult[i];
                }
            }
            if (isFindResult(result)) {
                return true;
            }
        }
        return false;
    }

    private boolean isFindResult(boolean[] result) {
        for (boolean item: result) {
            if (!item) {
                return false;
            }
        }
        return true;
    }
}
