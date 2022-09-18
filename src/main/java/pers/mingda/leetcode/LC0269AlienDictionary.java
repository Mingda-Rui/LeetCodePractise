package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class LC0269AlienDictionary {

}

class Solution {
    public String alienOrder(String[] words) {
        Trie trie = new Trie('#');
        Set<Character> allLetters = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if (!buildTrie(trie, i, words[i]))
                return "";
            for (char letter: words[i].toCharArray())
                allLetters.add(letter);
        }



        List<List<Trie>> rules = new LinkedList<>();
        parseAlienRule(trie, rules);

//        printRules(rules); // mr-test

        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Set<Character>> reversedMap = new HashMap<>();
        for (List<Trie> rule: rules) {
            if (!checkRule(rule))
                return "";
            buildRuleMap(rule, map, reversedMap);
        }


//        System.out.println("map size: " + map.size());
//        System.out.println("reversed map size: " + reversedMap.size());

        Queue<Character> queue = new LinkedList<>();
        for (char c: map.keySet())
            if (map.get(c).isEmpty())
                queue.offer(c);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char parent: reversedMap.getOrDefault(c, Collections.<Character>emptySet())) {
                Set<Character> children = map.get(parent);
                children.remove(c);
                if (children.isEmpty())
                    queue.offer(parent);
            }
        }

        if (sb.length() != map.size())
            return "";
        String result = sb.reverse().toString();
        for (char letter: result.toCharArray())
            allLetters.remove(letter);
        String restLetters = allLetters.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining());
        return result + restLetters;
    }

    private boolean buildTrie(Trie trie, int pos, String words) {
        if (words == null || words.isEmpty())
            return true;
        Trie current = trie;
        char c = words.charAt(0);
        if (current.children[c] == null) {
            Trie child = new Trie(c);
            current.children[c] = child;
            current.numOfChildren++;
        }
        current = current.children[c];
        current.addPos(pos);

        if (words.length() == 1 && current.numOfChildren != 0)
            return false;
        if (!buildTrie(current, pos, words.substring(1)))
            return false;
        return true;
    }

    private void parseAlienRule(Trie trie, List<List<Trie>> rules) {
        if (trie.numOfChildren == 0)
            return;
        Trie[] children = trie.children;
        Queue<Trie> queue = new PriorityQueue<>(Comparator.comparingInt(t -> t.headPos));
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null) {
                parseAlienRule(children[i], rules);
                queue.offer(children[i]);
            }
        }

        if (queue.size() <= 1)
            return;

        List<Trie> rule = new ArrayList<>();
        while (!queue.isEmpty()) {
            Trie headSort = queue.poll();
            rule.add(headSort);
        }

        rules.add(rule);
    }

    private boolean checkRule(List<Trie> rule) {
        for (int i = 0; i < rule.size() - 1; i++) {
            Trie parent = rule.get(i);
            Trie child = rule.get(i + 1);
            if (parent.tailPos > child.headPos)
                return false;
        }
        return true;
    }

    private void buildRuleMap(List<Trie> rule, Map<Character, Set<Character>> map, Map<Character, Set<Character>> reversedMap) {
        for (int i = 0; i < rule.size(); i++) {
            char parent = rule.get(i).c;
            map.putIfAbsent(parent, new HashSet<>());
            if (i + 1 < rule.size()) {
                char child = rule.get(i + 1).c;
                map.get(parent).add(child);
                map.putIfAbsent(child, new HashSet<>());
                reversedMap.putIfAbsent(child, new HashSet<>());
                reversedMap.get(child).add(parent);
            }
        }
    }
}

/*
0: w -> e -> r
1: r -> t
2: t -> f

*/

class Trie {
    int numOfChildren;
    char c;
    int headPos;
    int tailPos;
    Trie[] children;

    public Trie(char c) {
        this.numOfChildren = 0;
        this.c = c;
        this.headPos = Integer.MAX_VALUE;
        this.tailPos = Integer.MIN_VALUE;
        this.children = new Trie[128];
    }

    public void addPos(int pos) {
        headPos = Math.min(headPos, pos);
        tailPos = Math.max(tailPos, pos);
    }
}

/*
1 2   4   9
  2 3   5 9
  2 3 4 5

*/