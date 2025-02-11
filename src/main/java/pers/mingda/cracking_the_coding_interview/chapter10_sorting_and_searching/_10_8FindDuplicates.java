package pers.mingda.cracking_the_coding_interview.chapter10_sorting_and_searching;

public class _10_8FindDuplicates {
    void checkDuplicates(int[] array) {
        MyBitSet bs = new MyBitSet(32000);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (bs.get(num)) {
                System.out.println(num);
            } else {
                bs.set(num);
            }
        }
    }
}

class MyBitSet {
    int[] bitset;

    public MyBitSet(int size) {
        bitset = new int[(size >> 5) + 1]; // divide by 32
    }

    boolean get(int pos) {
        int wordNumber = getWordNumber(pos);
        int bitNumber = getBitNumber(pos);
        return (bitset[wordNumber] & (1 << bitNumber)) != 0;
    }

    void set(int pos) {
        int wordNumber = getWordNumber(pos);
        int bitNumber = getBitNumber(pos);
        bitset[wordNumber] |= 1 << bitNumber;
    }

    private int getWordNumber(int pos) {
        return pos >> 5; // divide by 32
    }

    private int getBitNumber(int pos) {
        return pos & 0x1F; // mod 32
    }
}
