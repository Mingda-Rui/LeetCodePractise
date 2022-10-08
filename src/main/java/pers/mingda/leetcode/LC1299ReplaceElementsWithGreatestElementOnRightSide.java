package pers.mingda.leetcode;

public class LC1299ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int max = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            int val = arr[i];
            arr[i] = max;
            max = Math.max(max, val);
        }
        arr[len - 1] = -1;
        return arr;
    }
}
