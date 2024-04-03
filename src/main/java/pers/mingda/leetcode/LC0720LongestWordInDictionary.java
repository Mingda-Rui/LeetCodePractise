package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC0720LongestWordInDictionary {
    public String longestWord(String[] words) {
        LC0720Trie root = new LC0720Trie();
        root.word = "";
        for (String word: words)
            constructLC0720Trie(root, word);
        return getLongest(root);
    }

    private LC0720Trie constructLC0720Trie(LC0720Trie root, String word) {
        LC0720Trie LC0720Trie = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (LC0720Trie.arr[c] == null)
                LC0720Trie.arr[c] = new LC0720Trie();
            LC0720Trie = LC0720Trie.arr[c];
        }
        LC0720Trie.word = word;
        return root;
    }

    private String getLongest(LC0720Trie LC0720Trie) {
        if (LC0720Trie == null || LC0720Trie.word == null)
            return "";
        String result = LC0720Trie.word;
        for (int i = 97; i <= 122; i++) {
            String child = getLongest(LC0720Trie.arr[i]);
            if (child.length() > result.length())
                result = child;
        }
        return result;
    }

    public String longestWordSortingSolution(String[] words) {
        Arrays.sort(words);
        String result = "";
        Set<String> validWords = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int wordLen = word.length();
            String prev = word.substring(0, wordLen - 1);
            if (wordLen == 1 || validWords.contains(prev)) {
                validWords.add(word);
                result = wordLen > result.length() ? word : result;
            }
        }
        return result;
    }
}

class LC0720Trie {
    LC0720Trie[] arr;
    String word;

    public LC0720Trie() {
        this.arr = new LC0720Trie[256];
        this.word = null;
    }
}
