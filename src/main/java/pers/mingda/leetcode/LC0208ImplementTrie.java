package pers.mingda.leetcode;

public class LC0208ImplementTrie {

}

class Trie {

    Trie[] record;

    public Trie() {
        record = new Trie[128];
    }

    public void insert(String word) {
        insert(word + "#", 0);
    }

    private void insert(String word, int index) {
        if (index < word.length()) {
            char c = word.charAt(index);
            if (record[c] == null) {
                record[c] = new Trie();
            }
            record[c].insert(word, index + 1);
        }
    }

    public boolean search(String word) {
        return search(word + "#", 0);
    }

    private boolean search(String prefix, int index) {
        if (index == prefix.length())
            return true;
        char c = prefix.charAt(index);
        if (record[c] == null)
            return false;
        return record[c].search(prefix, index + 1);
    }

    public boolean startsWith(String prefix) {
        return search(prefix, 0);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */