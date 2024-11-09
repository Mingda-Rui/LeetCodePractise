package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

public class _8_3MagicIndex {
    public int findMagicIndex(int[] array) {
        return findMagicIndex(array, 0, array.length);
    }

    public int findMagicIndex(int[] array, int from, int to) {
        int index = (from + to) / 2;
        if (from + 1 == to) {
            return array[index] == index ? index : -1;
        }
        return array[index] > index
                ? findMagicIndex(array, from, index)
                : findMagicIndex(array, index, to);
    }
}
