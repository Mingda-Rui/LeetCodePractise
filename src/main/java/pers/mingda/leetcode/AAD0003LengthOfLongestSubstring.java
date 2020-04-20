package pers.mingda.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class AADLengthOfLongestSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring("abba");
        System.out.println(i);
    }
}

class Solution {
    Set<Character> set = new HashSet<>();
    LinkedList<Character> list = new LinkedList<>();
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains( s.charAt(i) )) {
                if ( max < set.size())
                    max = set.size();
                while (!list.getFirst().equals(s.charAt(i))) {
                    set.remove( list.getFirst() );
                    list.removeFirst();
                }
                set.remove( list.getFirst() );
                list.removeFirst();
            } 
            set.add( s.charAt(i) );
            list.add( s.charAt(i) );
        }
        int size = list.size();
        return max > size ? max : size;
    }
}
