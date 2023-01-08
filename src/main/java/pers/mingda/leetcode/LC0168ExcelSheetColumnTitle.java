package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.List;

public class LC0168ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
             int digit = columnNumber % 26;
             sb.append(covertInt(digit));
             if (digit == 0)
                 columnNumber -= 26;
             columnNumber /= 26;
        }

        return sb.reverse().toString();
    }

    private char covertInt(int num) {
        List<Character> letterList = Arrays.asList('Z', 'A', 'B', 'C', 'D', 'E',
        'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O',
        'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y');
        return letterList.get(num);
    }
}
