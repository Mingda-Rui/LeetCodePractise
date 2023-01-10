package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LC0271EncodeAndDecodeStrings {

}

class LC0271Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String delimiter = "# ";
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            for (char c: str.toCharArray()) {
                if (c == '#')
                    sb.append('#');
                sb.append(c);
            }
            sb.append(delimiter);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new LinkedList<>();
        if (s.isEmpty())
            return list;

        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                i++;
                char nextC = s.charAt(i);
                if (nextC == '#') {
                    str += c;
                } else {
                    list.add(str);
                    str = "";
                }
            } else {
                str += c;
            }
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));