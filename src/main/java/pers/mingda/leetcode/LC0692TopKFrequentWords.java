package pers.mingda.leetcode;

import java.util.*;

public class LC0692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            int count = map.getOrDefault(word, 0);
            map.put(word, count + 1);
        }

        LC0692Trie[] bucket = new LC0692Trie[words.length + 1];
        for (String word: map.keySet()) {
            int count = map.get(word);
            if (bucket[count] == null)
                bucket[count] = new LC0692Trie('#');
            bucket[count].add(word);
        }

        List<String> result = new LinkedList<>();
        for (int i = bucket.length - 1; i > 0; i--) {
            if (result.size() == k)
                return result;
            LC0692Trie LC0692Trie = bucket[i];
            if (LC0692Trie != null)
                addResult(result, LC0692Trie, k);
        }
        return result;
    }

    private void addResult(List<String> result, LC0692Trie LC0692Trie, int k) {
        List<String> words = new LinkedList<>();
        LC0692Trie.extraWords(words);
        int index = 0;
        while (index < words.size() && result.size() < k) {
            result.add(words.get(index));
            index++;
        }
    }
}

class LC0692Trie {
    LC0692Trie[] children;
    char c;
    String word;

    public LC0692Trie(char c) {
        this.children = new LC0692Trie[128];
        this.c = c;
        this.word = null;
    }

    public void add(String word) {
        LC0692Trie pointer = this;

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (pointer.children[letter] == null)
                pointer.children[letter] = new LC0692Trie(letter);
            pointer = pointer.children[letter];
            if (i == word.length() - 1)
                pointer.word = word;
        }
    }

    public void extraWords(List<String> list) {
        for (LC0692Trie child: children) {
            if (child != null) {
                if (child.word != null)
                    list.add(child.word);
                child.extraWords(list);
            }
        }
    }
}
