package pers.mingda.leetcode;

import java.util.*;

public class LC0692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            int count = map.getOrDefault(word, 0);
            map.put(word, count + 1);
        }

        Trie[] bucket = new Trie[words.length + 1];
        for (String word: map.keySet()) {
            int count = map.get(word);
            if (bucket[count] == null)
                bucket[count] = new Trie('#');
            bucket[count].add(word);
        }

        List<String> result = new LinkedList<>();
        for (int i = bucket.length - 1; i > 0; i--) {
            if (result.size() == k)
                return result;
            Trie trie = bucket[i];
            if (trie != null)
                addResult(result, trie, k);
        }
        return result;
    }

    private void addResult(List<String> result, Trie trie, int k) {
        List<String> words = new LinkedList<>();
        trie.extraWords(words);
        int index = 0;
        while (index < words.size() && result.size() < k) {
            result.add(words.get(index));
            index++;
        }
    }
}

class Trie {
    Trie[] children;
    char c;
    String word;

    public Trie(char c) {
        this.children = new Trie[128];
        this.c = c;
        this.word = null;
    }

    public void add(String word) {
        Trie pointer = this;

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (pointer.children[letter] == null)
                pointer.children[letter] = new Trie(letter);
            pointer = pointer.children[letter];
            if (i == word.length() - 1)
                pointer.word = word;
        }
    }

    public void extraWords(List<String> list) {
        for (Trie child: children) {
            if (child != null) {
                if (child.word != null)
                    list.add(child.word);
                child.extraWords(list);
            }
        }
    }
}
