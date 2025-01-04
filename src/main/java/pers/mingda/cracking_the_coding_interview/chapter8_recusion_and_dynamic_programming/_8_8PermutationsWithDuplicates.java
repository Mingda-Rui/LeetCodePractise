package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _8_8PermutationsWithDuplicates {
    public List<String> getPerms(String str) {
        if (str.isEmpty() || str.length() == 1) {
            return List.of(str);
        }
        Set<Character> chars = str.chars().boxed().map(c -> (char)c.intValue()).collect(Collectors.toSet());
        List<String> allPerms = new ArrayList<>();
        for (char c : chars) {
            String remains = str.replaceFirst(String.valueOf(c), "");
            List<String> subPerms = getPerms(remains);
            List<String> fullPerms = subPerms.stream().map(subP -> c + subP).toList();
            allPerms.addAll(fullPerms);
        }
        return allPerms;
    }
}
