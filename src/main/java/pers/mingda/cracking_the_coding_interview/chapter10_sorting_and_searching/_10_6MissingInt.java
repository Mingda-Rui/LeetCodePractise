package pers.mingda.cracking_the_coding_interview.chapter10_sorting_and_searching;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class _10_6MissingInt {
    long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
    byte[] bitfield = new byte[(int) (numberOfInts / 8)];
    String filename = "testFile.txt";

    public void findOpenNumber() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(filename));
        while (in.hasNextInt()) {
            int n = in.nextInt();
            /*
            * Finds the corresponding number in the bitfield by using the OR operator to
            * set the nth bit of a byte (e.g., 10 would correspond to the 2nd bit of
            * index 2 in the byte array). */
            bitfield [n / 8] |= 1 << (n % 8);
        }

        for (int i = 0; i < bitfield.length; i++) {
            for (int j = 0; j < 8; j++) {
                /*
                * Retrieves the individual bits of each byte. When 0 bit is found, print
                * the corresponding value. */
                if ((bitfield[i] & (1 << j)) == 0) {
                    System.out.println(i * 8 + j);
                    return;
                }
            }
        }
    }
}
