package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new LinkedList<>();
        Trie root = new Trie();
        for (String word: words)
            buildTrie(root, word);
        Comparator<Trie> comparator = (o1, o2) -> {
            if (o1.count == o2.count)
                return o1.word.compareTo(o2.word);
            return o2.count - o1.count;
        };
        Queue<Trie> queue = new PriorityQueue<>(comparator);
        sortWords(root, queue);
        for (int i = 0; i < k; i++) {
            Trie topWord = queue.remove();
            result.add(topWord.word);
        }

        return result;
    }

    private void buildTrie(Trie root, String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (root.arr[c] == null)
                root.arr[c] = new Trie();
            root = root.arr[c];
        }
        root.word = word;
        root.count++;
    }

    private void sortWords(Trie root, Queue<Trie> queue) {
        if (root == null)
            return;
        if (root.count != 0)
            queue.add(root);
        for (int i = 97; i <= 122; i++)
            sortWords(root.arr[i], queue);
    }

}

class Trie {
    Trie[] arr;
    String word;
    int count;

    public Trie() {
        this.arr = new Trie[128];
        this.word = null;
        this.count = 0;
    }
}
