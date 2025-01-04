package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _8_9Parens {
    private final static String OPEN_PARENS = "(";
    private final static String CLOSE_PARENS = ")";

    public List<String> generateParens(int numOfParens) {
        return generateParens(numOfParens, numOfParens);
    }

    private List<String> generateParens(int remainOpenP, int remainCloseP) {
        if (remainCloseP == 0) {
            return List.of("");
        }

        List<String> allParens = new ArrayList<>();
        // remainOpenP == closeP => open
        // remainOpenP > closeP open / close
        // remainOpenP < closeP xx
        for (String prefix : getPossiblePrefixes(remainOpenP, remainCloseP)) {
            int newRemainOpenP = Objects.equals(prefix, OPEN_PARENS) ? remainOpenP - 1 : remainOpenP;
            int newRemainCloseP = Objects.equals(prefix, CLOSE_PARENS) ? remainCloseP - 1 : remainCloseP;
            List<String> newParens = generateParens(newRemainOpenP, newRemainCloseP).stream().map(parens -> prefix + parens).toList();
            allParens.addAll(newParens);
        }
        return allParens;
    }

    private List<String> getPossiblePrefixes(int remainOpenP, int remainCloseP) {
        if (remainOpenP < remainCloseP) {
            throw new IllegalStateException("remainOpenP must not be less than remainCloseP");
        }
        List<String> possiblePrefixes = new ArrayList<>();
        if (remainOpenP > 0) {
            possiblePrefixes.add(OPEN_PARENS);
        }
        if (remainOpenP > remainCloseP) {
            possiblePrefixes.add(CLOSE_PARENS);
        }
        return possiblePrefixes;
    }
}
