package pers.mingda.cracking_the_coding_interview.chapter5_bit_manipulation;

public class _5_1Insertion {
    public int insertion(int N, int M, int i, int j) {
        int mBits = countBits(M);
        int shiftedM = M << (j - mBits);
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
