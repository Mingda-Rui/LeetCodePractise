package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

public class _8_3MagicIndex {
    public int findMagicIndex(int[] array) {
        return findMagicIndex(array, 0, array.length);
    }

    public int findMagicIndex(int[] array, int from, int to) {
        if (from == to)
            return -1;
        else if (from + 1 == to) {
            return array[from] == from ? from : -1;
        }
        int index = (from + to) / 2;
        return array[index] > index ? findMagicIndex(array, from, index) : findMagicIndex(array, index, to);
    }
}
