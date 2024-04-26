package pers.mingda.cracking_the_coding_interview.chapter5_bit_manipulation;

import java.util.logging.Logger;

public class _5_1Insertion {

    private static final Logger LOGGER = Logger.getLogger(_5_1Insertion.class.getName());

    public int insertion(int N, int M, int i, int j) {
        int mBits = countBits(M);
        int shiftedM = M << (j - mBits);
        LOGGER.info("shiftedM: %s".formatted(Integer.toBinaryString(shiftedM)));
        int clearedBitsN = clearBits(N, j);
        return clearedBitsN | shiftedM;
    }

    public int countBits(int num) {
        int count = 0;
        while (num > 0) {
            count ++;
            num /= 2;
        }
        return count;
    }

    public int clearBits(int num, int i) {
        return num & (-1 << i + 1);
    }
}
