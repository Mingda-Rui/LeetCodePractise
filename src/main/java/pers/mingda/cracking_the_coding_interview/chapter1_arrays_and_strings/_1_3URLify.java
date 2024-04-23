package pers.mingda.cracking_the_coding_interview.chapter1_arrays_and_strings;

/*
  * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
  * has sufficient space at the end to hold the additional characters, and that you are given the "true"
  * length of the string. (Note: If implementing in Java, please use a character array so that you can
  * perform this operation in place.)
  * EXAMPLE
  * Input:     "Mr John Smith    ", 13
  * Output:    "Mr%20John%20Smith"
  * */

public class _1_3URLify {
    public static String urlify(char[] url, int length) {
        StringBuilder sb = new StringBuilder();        
        int consecutiveSpaceCounter = 0;
        for (char c: url) {
            if (c == ' ')
                consecutiveSpaceCounter++;
            else {
                while (consecutiveSpaceCounter > 0) {
                    sb.append("%20");
                    consecutiveSpaceCounter--;
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void urlifySameArray(char[] url, int length) {
        int tailIndex = url.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (url[i] == ' ') {
                url[tailIndex] = '0';
                tailIndex--;
                url[tailIndex] = '2';
                tailIndex--;
                url[tailIndex] = '%';
                tailIndex--;
            } else {
                url[tailIndex] = url[i];
                tailIndex--;
            }
        }
        
    }
}
