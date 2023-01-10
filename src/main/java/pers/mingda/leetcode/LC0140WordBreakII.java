package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LC0140WordBreakII {

}

class LC0140Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie root = buildTrie(wordDict);
        List<List<String>> result = new LinkedList<>();
        buildResult(result, new LinkedList<>(), root, s);
        List<String> sentences = new LinkedList<>();
        buildSentences(result, sentences);
        return sentences;
    }

    private void buildResult(List<List<String>> result, List<String> sentence, Trie trie, String s) {

        if (s.isEmpty()) {
            List<String> copiedSentence = new LinkedList<>(sentence);
            result.add(copiedSentence);
            return;
        }
        Trie current = trie;
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (current.next[letter] != null) {
                current = current.next[letter];
                if (current.isWord) {
                    sentence.add(s.substring(0, i + 1));
                    buildResult(result, sentence, trie, s.substring(i + 1));
                    sentence.remove(sentence.size() - 1);
                }
            } else {
                break;
            }
        }
    }

    private Trie buildTrie(List<String> wordDict) {
        Trie trie = new Trie(' ');
        for (String word: wordDict) {
            Trie current = trie;
            for (char letter: word.toCharArray()) {
                if (current.next[letter] == null)
                    current.next[letter] = new Trie(letter);
                current = current.next[letter];
            }
            current.isWord = true;
        }
        return trie;
    }

    private void buildSentences(List<List<String>> result, List<String> sentences) {
        for (List<String> words: result) {
            StringBuilder sb = new StringBuilder();
            for (String word: words) {
                if (!sb.isEmpty())
                    sb.append(" ");
                sb.append(word);
            }

            String sentence = sb.toString();
            sentences.add(sentence);
        }
    }
}

class Trie {
    char c;
    Trie[] next;
    boolean isWord;
    public Trie(char c) {
        this.c = c;
        this.isWord = false;
        this.next = new Trie[128];
    }
}
