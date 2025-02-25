package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.ArrayList;

public class _17_4MissingNumber {
    int findMissing(ArrayList<MissingNumberBitInteger> array) {
        /* Start from the least significant bit, and work our way up */
        return findMissing(array, 0);
    }

    int findMissing(ArrayList<MissingNumberBitInteger> input, int column) {
        if (column >= MissingNumberBitInteger.INTEGER_SIZE) { // We're done!
            return 0;
        }
        ArrayList<MissingNumberBitInteger> oneBits = new ArrayList<>(input.size() / 2);
        ArrayList<MissingNumberBitInteger> zeroBits = new ArrayList<>(input.size() / 2);

        for (MissingNumberBitInteger t : input) {
            if (t.fetch(column) == 0) {
                zeroBits.add(t);
            } else {
                oneBits.add(t);
            }
        }
        if (zeroBits.size() <= oneBits.size()) {
            int v = findMissing(zeroBits, column + 1);
            return v << 1; // equivalent of (v << 1) | 0
        } else {
            int v = findMissing(oneBits, column + 1);
            return (v << 1) | 1;
        }
    }
}

class MissingNumberBitInteger {
    public static int INTEGER_SIZE;
    int value;
    int fetch(int column) {
        return (value >> column) & 1;
    }
}
