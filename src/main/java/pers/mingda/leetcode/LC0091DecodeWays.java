package pers.mingda.leetcode;

public class LC0091DecodeWays {

}

class SolutionOne {
    public int numDecodings(String s) {
        // if (s.charAt(0) == '0') return 0;
        String keNengFenGe = "";
        int currentPossibility = 1;
        for (int i = 0; i < s.length(); i++) {
            keNengFenGe += s.charAt(i);
            if (s.charAt(i) != '1' && s.charAt(i) != '2') {
                if (keNengFenGe.length() != 1) {
                    currentPossibility = currentPossibility * getPossibility(keNengFenGe);
                } else if (s.charAt(i) == '0') {
                    currentPossibility = 0;
                    break;
                }

                keNengFenGe = "";
            } else if ((i+1)>=s.length()) {
                currentPossibility = currentPossibility * getPossibility(keNengFenGe);
            }
        }
        return currentPossibility;
    }

    public int getPossibility(String s) {
        int length = s.length();
        if (s.charAt(length-1) == '0') {
            length -= 2;
        } else if (length >= 2 && s.charAt(length-2) == '2') {
            if (s.charAt(length-1) == '7' ||
                s.charAt(length-1) == '8' ||
                s.charAt(length-1) == '9') {
                length -= 1;
            }
        }
        int sum = length;
        for (int i = 2; i <= length/2; i++ ) {
            int current = length - i;
            sum += (current)*(current-1)/i/(i-1);
        }

        if (sum<=0) sum = 1;
        return sum;
    }
}

class SolutionTwo {
    public int numDecodings(String s) {
        if (null == s || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++){
            if (isValid(s.substring(i - 2, i))){
                dp[i] += dp[i - 2];
            }
            if (isValid(s.substring(i - 1, i))){
                dp[i] += dp[i - 1];
            }
        }
        return dp[s.length()];
        //        1 2 3 1 2
        // index: 0 1 2 3 4
        // dp:
    }

    private boolean isValid(String str){
        if (str.charAt(0) == '0') return false;
        int num = Integer.parseInt(str);
        return num >= 1 && num <= 26;
    }
}
