package pers.mingda.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC0929UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String parsedEmail = parseLocalName(email);
            set.add(parsedEmail);
        }
        return set.size();
    }

    private String parseLocalName(String email) {
        String[] parsedEmail = email.split("@");
        String local = parsedEmail[0];
        String domain = parsedEmail[1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < local.length(); i++) {
            char c = local.charAt(i);
            if (c == '+') break;
            else if (c != '.') sb.append(c);
        }
        sb.append("@").append(domain);
        return sb.toString();
    }
}
