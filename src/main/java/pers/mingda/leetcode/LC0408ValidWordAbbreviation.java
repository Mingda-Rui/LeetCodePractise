package pers.mingda.leetcode;

public class LC0408ValidWordAbbreviation {

}

class LC0408Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int pointer = 0;
        for (int i = 0; i < abbr.length(); i++) {
            char c = abbr.charAt(i);
            if (Character.isDigit(c)) {
                if (c == '0')
                    return false;
                int num = c - '0';
                while (i + 1 < abbr.length() && Character.isDigit(abbr.charAt(i + 1))) {
                    i++;
                    num = num * 10 + (abbr.charAt(i) - '0');
                }
                pointer += num;
            } else {
                if (pointer >= word.length() || word.charAt(pointer) != c)
                    return false;
                pointer++;
            }
        }
        return pointer == word.length();
    }
}

class LC0408RefactoredSolution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int pointer = 0;
        int num = 0;

        for (char c: abbr.toCharArray()) {
            if (Character.isDigit(c)) {
                if (num == 0 && c == '0')
                    return false;
                num = num * 10 + (c - '0');
            } else {
                pointer += num;
                num = 0;
                if (pointer >= word.length() || word.charAt(pointer) != c)
                    return false;
                pointer++;
            }
        }
        pointer += num;
        return pointer == word.length();
    }
}