package pers.mingda.leetcode;

public class LC91DecodeWays {

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