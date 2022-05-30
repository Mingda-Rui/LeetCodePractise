package pers.mingda.leetcode;

public class LC0720LongestWordInDictionary {
    public String longestWord(String[] words) {
        Trie root = new Trie();
        root.word = "";
        for (String word: words)
            constructTrie(root, word);
        return getLongest(root);
    }

    private Trie constructTrie(Trie root, String word) {
        Trie trie = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (trie.arr[c] == null)
                trie.arr[c] = new Trie();
            trie = trie.arr[c];
        }
        trie.word = word;
        return root;
    }

    private String getLongest(Trie trie) {
        if (trie == null || trie.word == null)
            return "";
        String result = trie.word;
        for (int i = 97; i <= 122; i++) {
            String child = getLongest(trie.arr[i]);
            if (child.length() > result.length())
                result = child;
        }
        return result;
    }
}

class Trie {
    Trie[] arr;
    String word;

    public Trie() {
        this.arr = new Trie[256];
        this.word = null;
    }
}
