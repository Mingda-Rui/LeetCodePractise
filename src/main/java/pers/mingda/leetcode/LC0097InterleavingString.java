package pers.mingda.leetcode;

public class LC0097InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] invalidMemo = new boolean[s1.length() + 1][s2.length() + 1];
        return interleave(s1, 0, s2, 0, s3, 0, invalidMemo);
    }

    private boolean interleave(String s1, int i1, String s2, int i2, String s3, int i3, boolean[][] invalidMemo) {
        if (invalidMemo[i1][i2]) {
            return false;
        }

        if (i3 == s3.length()) {
            invalidMemo[i1][i2] = !(i1 == s1.length() && i2 == s2.length());
            return !invalidMemo[i1][i2];
        }

        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
            if (interleave(s1, i1 + 1, s2, i2, s3, i3 + 1, invalidMemo)) {
                return true;
            }
        }
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            if (interleave(s1, i1, s2, i2 + 1, s3, i3 + 1, invalidMemo)) {
                return true;
            }
        }
        invalidMemo[i1][i2] = true;
        return false;
    }
}
